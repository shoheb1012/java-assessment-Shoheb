package processingmodule;

public class MonthlyStats {

    double avgValue;
    double maxValue;
    double minValue;

    public MonthlyStats(double avgValue, double maxValue, double minValue) {
        this.avgValue = avgValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public double getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(double avgValue) {
        this.avgValue = avgValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    @Override
    public String toString() {
        return "MonthlyStats{" +
                "avgValue=" + avgValue +
                ", maxValue=" + maxValue +
                ", minValue=" + minValue +
                '}';
    }
}

