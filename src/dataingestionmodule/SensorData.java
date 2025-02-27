package dataingestionmodule;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Date;

public class SensorData {
    private LocalDateTime date;
    private String sensorType;
    private double value;
    private String unit;
    private double locationId;
    private YearMonth month;

    public SensorData(LocalDateTime date, String sensorType, double value, String unit, double locationId, YearMonth month) {
        this.date = date;
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
        this.locationId = locationId;
        this.month = month;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getLocationId() {
        return locationId;
    }

    public void setLocationId(double locationId) {
        this.locationId = locationId;
    }

    public YearMonth getMonth() {
        return month;
    }

    public void setMonth(YearMonth month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "SensorData{" + "date=" + date + ", sensorType=" + sensorType + ", value=" + value + ", unit=" + unit + ", locationId=" + locationId + ", month=" + month + '}';
    }
}
