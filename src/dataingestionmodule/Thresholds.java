package dataingestionmodule;

public class Thresholds {
    private String sensor_type;
    private int min_threshold;
    private int max_threshold;

    public Thresholds(String sensor_type, int min_threshold, int max_threshold) {
        this.sensor_type = sensor_type;
        this.min_threshold = min_threshold;
        this.max_threshold = max_threshold;
    }

    public String getSensor_type() {
        return sensor_type;
    }

    public void setSensor_type(String sensor_type) {
        this.sensor_type = sensor_type;
    }

    public int getMin_threshold() {
        return min_threshold;
    }

    public void setMin_threshold(int min_threshold) {
        this.min_threshold = min_threshold;
    }

    public int getMax_threshold() {
        return max_threshold;
    }

    public void setMax_threshold(int max_threshold) {
        this.max_threshold = max_threshold;
    }

    @Override
    public String toString() {
        return "Thresholds{" +
                "sensor_type='" + sensor_type + '\'' +
                ", min_threshold=" + min_threshold +
                ", max_threshold=" + max_threshold +
                '}';
    }
}
