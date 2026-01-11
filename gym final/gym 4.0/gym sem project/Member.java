public class Member extends Person {
    private WorkoutPlan workoutPlan;
    private Goal goal;
    private Trainer assignedTrainer;
    private double currentWeight;
    private double goalWeight;
    private double joiningWeight;
    private Membership membership;
    private DietPlan dietPlan;

    public Member(int id, String name, String email, String phone, String address) {
        super(id, name, email, phone, address);
    }

    public Member(int id, String name, String email, String phone, String address, 
                   Trainer assignedTrainer, double currentWeight, double goalWeight) {
        super(id, name, email, phone, address);
        this.assignedTrainer = assignedTrainer;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.joiningWeight = currentWeight;
    }

    @Override
    public String getRole() {
        return "Member";
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void assignWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Trainer getAssignedTrainer() {
        return assignedTrainer;
    }

    public void setAssignedTrainer(Trainer assignedTrainer) {
        this.assignedTrainer = assignedTrainer;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public double getJoiningWeight() {
        return joiningWeight;
    }

    public void setJoiningWeight(double joiningWeight) {
        this.joiningWeight = joiningWeight;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void assignTrainer(Trainer trainer) {
        this.assignedTrainer = trainer;
        System.out.println("Member " + name + " assigned to trainer " + trainer.getName());
    }

    public void updateWeight(double newWeight) {
        double previousWeight = this.currentWeight;
        this.currentWeight = newWeight;
        double weightChange = newWeight - previousWeight;
        System.out.println("Member " + name + " weight updated from " + previousWeight + 
                         " to " + newWeight + " (change: " + weightChange + ")");
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", workoutPlan=" + workoutPlan +
                ", goal=" + goal +
                ", assignedTrainer=" + (assignedTrainer != null ? assignedTrainer.getName() : "None") +
                ", currentWeight=" + currentWeight +
                ", goalWeight=" + goalWeight +
                ", joiningWeight=" + joiningWeight +
                ", membership=" + membership +
                '}';
    }
}
