import java.io.Serializable;

public class Goal implements Serializable {
    private String goalName;

    public Goal(String goalName) {
        this.goalName = goalName;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getExercisesDescription() {
        if (goalName.equalsIgnoreCase("Weight Loss")) {
            return "Running, Cycling, Swimming";
        } else if (goalName.equalsIgnoreCase("Weight Gain") || goalName.equalsIgnoreCase("Muscle Gain")) {
            return "Squats, Deadlifts, Bench Press";
        } else if (goalName.equalsIgnoreCase("Endurance Building")) {
            return "Long Distance Running, Cardio Training";
        }
        return "General Fitness Exercises";
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalName='" + goalName + '\'' +
                '}';
    }
}
