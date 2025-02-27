package outlierdetection;

import dataingestionmodule.SensorData;
import dataingestionmodule.Thresholds;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutlierIdentification {

    public  static List<SensorData> identifyOutliers(List<SensorData> sensorDataList, Map<String, Thresholds> thresholdsMap) {
        return sensorDataList.stream()
                .filter(data -> {
                    Thresholds thresholds = thresholdsMap.get(data.getSensorType());
                    return thresholds != null && (data.getValue() < thresholds.getMin_threshold() || data.getValue() > thresholds.getMax_threshold());
                })
                .collect(Collectors.toList());
    }

    public static void writeOutliers(String filePath, List<SensorData> outliers, Map<String, Thresholds> thresholdsMap) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("date,sensor_type,value,unit,location_id,threshold_exceeded\n");

            for (SensorData data : outliers) {
                String thresholdExceeded = data.getValue() < thresholdsMap.get(data.getSensorType()).getMin_threshold() ? "Min" : "Max";
                bw.write(String.format("%s,%s,%.2f,%s,%.2f,%s\n", data.getDate(), data.getSensorType(), data.getValue(), data.getUnit(), data.getLocationId(), thresholdExceeded));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

