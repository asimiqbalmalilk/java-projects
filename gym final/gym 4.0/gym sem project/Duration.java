import java.io.Serializable;

public class Duration implements Serializable {
    private String durationName;

    public Duration(String durationName) {
        this.durationName = durationName;
    }

    public String getDurationName() {
        return durationName;
    }

    public void setDurationName(String durationName) {
        this.durationName = durationName;
    }

    public int getNumberOfMonths() {
        if (durationName == null) return 1;
        if (durationName.equalsIgnoreCase("Quarterly")) return 3;
        if (durationName.equalsIgnoreCase("Annual")) return 12;
        return 1;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "durationName='" + durationName + '\'' +
                '}';
    }
}