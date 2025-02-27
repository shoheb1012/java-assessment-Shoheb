package processingmodule;

import dataingestionmodule.ReadingOfDataFromCSV;
import dataingestionmodule.SensorData;

import java.io.*;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SensorStatistics {
    public static Map<String, Map<YearMonth, MonthlyStats>> calculateMonthlyStats(List<SensorData> sensorDataList) {
        return sensorDataList.stream()
                .collect(Collectors.groupingBy(
                        data -> data.getSensorType(),
                        Collectors.groupingBy(
                                data -> data.getMonth(),
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            double avg = list.stream().mapToDouble(data -> data.getValue()).average().orElse(0);
                                            double max = list.stream().mapToDouble(data -> data.getValue()).max().orElse(0);
                                            double min = list.stream().mapToDouble(data -> data.getValue()).min().orElse(0);
                                            return new MonthlyStats(avg, max, min);
                                        }
                                )
                        )
                ));
    }

    public static void writeMonthlyStats(String filePath, Map<String, Map<YearMonth, MonthlyStats>> monthlyStats) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("sensor_type,month,avg_value,max_value,min_value\n");

            for (Map.Entry<String, Map<YearMonth, MonthlyStats>> sensorEntry : monthlyStats.entrySet()) {
                String sensorType = sensorEntry.getKey();
                Map<YearMonth, MonthlyStats> monthlyData = sensorEntry.getValue();

                for (Map.Entry<YearMonth, MonthlyStats> monthEntry : monthlyData.entrySet()) {
                    YearMonth month = monthEntry.getKey();
                    MonthlyStats stats = monthEntry.getValue();
                    bw.write(String.format("%s,%s,%.2f,%.2f,%.2f\n", sensorType, month, stats.avgValue, stats.maxValue, stats.minValue));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

