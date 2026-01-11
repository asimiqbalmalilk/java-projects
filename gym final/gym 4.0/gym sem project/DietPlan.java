import java.io.Serializable;

public class DietPlan implements Serializable {
    private String dietPlanName;
    private double caloriesPerDay;
    private double carbs;
    private double proteins;
    private double fats;

    public DietPlan(String dietPlanName, double caloriesPerDay) {
        this.dietPlanName = dietPlanName;
        this.caloriesPerDay = caloriesPerDay;
        this.carbs = 0;
        this.proteins = 0;
        this.fats = 0;
    }

    public String getDietPlanName() {
        return dietPlanName;
    }

    public double getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(double caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public String getMealsDescription() {
        if (dietPlanName.toLowerCase().contains("weight loss")) {
            return "Oatmeal with berries, Grilled Chicken Salad, Steamed Vegetables with Fish";
        } else if (dietPlanName.toLowerCase().contains("weight gain") || dietPlanName.toLowerCase().contains("muscle")) {
            return "Eggs and Toast with Avocado, Steak and Potatoes, Protein Shake with Banana, Rice and Chicken Breast";
        } else {
            return "Mixed Fruit Bowl, Quinoa Salad, Grilled Salmon";
        }
    }

    @Override
    public String toString() {
        return "DietPlan{" +
                "dietPlanName='" + dietPlanName + '\'' +
                ", caloriesPerDay=" + caloriesPerDay +
                ", carbs=" + carbs +
                ", proteins=" + proteins +
                ", fats=" + fats +
                '}';
    }
}
