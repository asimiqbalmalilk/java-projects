import java.awt.Component;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MemberDashboard extends JFrame {
   public MemberDashboard(GymManagementSystem system, Member member) {
      this.setTitle("Member Dashboard");
      this.setSize(800, 600);
      this.setLocationRelativeTo((Component)null);
      JTextArea textArea = new JTextArea();
      textArea.setEditable(false);
      textArea.setFont(new Font("Monospaced", 0, 12));
      StringBuilder str = new StringBuilder();
      str.append("============================================================").append("\n");
      str.append("                  MEMBER PROFILE DASHBOARD                  ").append("\n");
      str.append("============================================================").append("\n");
      str.append(String.format(" %-15s: %-30s %n", "Name", member.getName()));
      str.append(String.format(" %-15s: %-30s %n", "Member ID", member.getId()));
      str.append(String.format(" %-15s: %-30s %n", "Email", member.getEmail()));
      str.append(String.format(" %-15s: %-30s %n", "Phone", member.getPhone()));
      str.append(String.format(" %-15s: %-30s %n", "Address", member.getAddress()));
      str.append("------------------------------------------------------------").append("\n");
      str.append("                     MEMBERSHIP STATUS                      ").append("\n");
      str.append("------------------------------------------------------------").append("\n");
      Membership m = member.getMembership();
      String type;
      String dur;
      if (m != null) {
         type = m.getMembershipType() != null ? m.getMembershipType().getType() : "N/A";
         dur = m.getDuration() != null ? m.getDuration().getDurationName() : "N/A";
         str.append(String.format(" %-15s: %-30s %n", "Type", type));
         str.append(String.format(" %-15s: %-30s %n", "Duration", dur));
         str.append(String.format(" %-15s: %-30s %n", "Start Date", m.getStartDate()));
         str.append(String.format(" %-15s: %-30s %n", "End Date", m.getEndDate()));
         str.append(String.format(" %-15s: %-30.2f PKR %n", "Original Amount", m.calculateOriginalAmount()));
         str.append(String.format(" %-15s: %-30.0f %% %n", "Discount Applied", m.getDiscountPercentage()));
         str.append(String.format(" %-15s: %-30.2f PKR %n", "Payable Amount", m.calculateFinalAmount()));
      } else {
         str.append(" No active membership found.").append("\n");
      }

      str.append("------------------------------------------------------------").append("\n");
      str.append("                    TRAINING & PROGRESS                     ").append("\n");
      str.append("------------------------------------------------------------").append("\n");
      String trainer = member.getAssignedTrainer() != null ? member.getAssignedTrainer().getName() : "Not Assigned";
      String goal = member.getGoal() != null ? member.getGoal().getGoalName() : "Not Set";
      str.append(String.format(" %-15s: %-30s %n", "Trainer", trainer));
      str.append(String.format(" %-15s: %-30s %n", "Fitness Goal", goal));
      str.append(String.format(" %-15s: %-30.1f kg %n", "Starting Weight", member.getJoiningWeight()));
      str.append(String.format(" %-15s: %-30.1f kg %n", "Current Weight", member.getCurrentWeight()));
      str.append(String.format(" %-15s: %-30.1f kg %n", "Target Weight", member.getGoalWeight()));
      double weight = member.getCurrentWeight() - member.getJoiningWeight();
      String progress = String.format("%.1f kg (%s)", Math.abs(weight), weight < 0.0 ? "Lost" : "Gained");
      str.append(String.format(" %-15s: %-30s %n", "Overall Progress", progress));
      if (member.getWorkoutPlan() != null) {
         str.append("------------------------------------------------------------").append("\n");
         str.append("                        WORKOUT PLAN                        ").append("\n");
         str.append("------------------------------------------------------------").append("\n");
         str.append(String.format(" %-15s: %-30s %n", "Plan Name", member.getWorkoutPlan().getPlanName()));
         str.append(String.format(" %-15s: %-30s %n", "Routine", member.getWorkoutPlan().getExercisesDescription()));
      }

      if (member.getDietPlan() != null) {
         str.append("------------------------------------------------------------").append("\n");
         str.append("                         DIET PLAN                          ").append("\n");
         str.append("------------------------------------------------------------").append("\n");
         str.append(String.format(" %-15s: %-30s %n", "Plan Name", member.getDietPlan().getDietPlanName()));
         str.append(String.format(" %-15s: %-30.0f cal %n", "Daily Calories", member.getDietPlan().getCaloriesPerDay()));
         str.append(String.format(" %-15s: %-30.0f g %n", "Carbs", member.getDietPlan().getCarbs()));
         str.append(String.format(" %-15s: %-30.0f g %n", "Proteins", member.getDietPlan().getProteins()));
         str.append(String.format(" %-15s: %-30.0f g %n", "Fats", member.getDietPlan().getFats()));
         str.append(String.format(" %-15s: %-30s %n", "Meals", member.getDietPlan().getMealsDescription()));
      }

      str.append("============================================================");
      textArea.setText(str.toString());
      this.add(new JScrollPane(textArea));
      this.setVisible(true);
   }
}