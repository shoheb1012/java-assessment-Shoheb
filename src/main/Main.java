package main;
import dataingestionmodule.ReadingOfDataFromCSV;
import dataingestionmodule.SensorData;
import dataingestionmodule.Thresholds;
import errorhandling.FileNotFoundException;
import errorhandling.InvalidDataFormatException;
import errorhandling.ProcessingException;
import errorhandling.ThresholdsNotDefinedException;
import outlierdetection.OutlierIdentification;
import processingmodule.MonthlyStats;
import processingmodule.SensorStatistics;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
            String filePathSensorData = "C:\\Users\\ShohebPathan\\IdeaProjects\\java-assessment-Shoheb\\src\\dataingestionmodule\\sensor_data.csv";
            String filePathThresholds = "C:\\Users\\ShohebPathan\\IdeaProjects\\java-assessment-Shoheb\\src\\dataingestionmodule\\thresholds.csv";
            List<SensorData> sensorDataList = ReadingOfDataFromCSV.extractSensorData(filePathSensorData);
            List<Thresholds> thresholdsDataList = ReadingOfDataFromCSV.extractThresholdsData(filePathThresholds);

            List sensorDataList2;
            String outputFilePath;
            try {
                outputFilePath = "C:\\Users\\ShohebPathan\\IdeaProjects\\java-assessment-Shoheb\\src\\reportingmodule\\outliers.csv";
                sensorDataList2 = ReadingOfDataFromCSV.extractSensorData(filePathSensorData);
                List<Thresholds> thresholdsList = ReadingOfDataFromCSV.extractThresholdsData(filePathThresholds);
                Map<String, Thresholds> thresholdsMap = (Map)thresholdsList.stream().collect(Collectors.toMap((t) -> {
                    return t.getSensor_type();
                }, (t) -> {
                    return t;
                }));
                List<SensorData> outliers = OutlierIdentification.identifyOutliers(sensorDataList2, thresholdsMap);
                OutlierIdentification.writeOutliers(outputFilePath, outliers, thresholdsMap);
            } catch (FileNotFoundException var10) {
                FileNotFoundException e = var10;
                System.err.println("ERR001: " + e.getMessage());
            } catch (InvalidDataFormatException var11) {
                InvalidDataFormatException e = var11;
                System.err.println("ERR002: " + e.getMessage());
            } catch (ProcessingException var12) {
                ProcessingException e = var12;
                System.err.println("ERR003: " + e.getMessage());
            } catch (ThresholdsNotDefinedException var13) {
                ThresholdsNotDefinedException e = var13;
                System.err.println("ERR004: " + e.getMessage());
            }

            outputFilePath = "C:\\Users\\ShohebPathan\\IdeaProjects\\java-assessment-Shoheb\\src\\reportingmodule\\monthly_stats.csv";
            sensorDataList2 = ReadingOfDataFromCSV.extractSensorData(filePathSensorData);
            Map<String, Map<YearMonth, MonthlyStats>> monthlyStats = SensorStatistics.calculateMonthlyStats(sensorDataList2);
            SensorStatistics.writeMonthlyStats(outputFilePath, monthlyStats);
        }
    }


