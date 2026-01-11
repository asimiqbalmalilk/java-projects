import java.io.Serializable;

public class WorkoutPlan implements Serializable {
    private String planName;

    public WorkoutPlan(String planName) {
        this.planName = planName;
    }

    public String getPlanName() {
        return planName;
    }

    public String getExercisesDescription() {
        if (planName.contains("Weight Loss")) {
            return "Cardio 30min, HIIT, Circuit Training";
        } else if (planName.contains("Weight Gain")) {
            return "Heavy Lifting, Compound Lifts, Strength Training";
        } else if (planName.contains("Beginner")) {
            return "Push-ups, Squats, Plank";
        } else if (planName.contains("Advanced")) {
            return "Bench Press, Barbell Rows, Pull-ups";
        } else if (planName.contains("Lower Body")) {
            return "Squats, Leg Press, Lunges";
        }
        return "General Workout";
    }

    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "planName='" + planName + '\'' +
                '}';
    }
}
