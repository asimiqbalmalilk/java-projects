import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class TrainerDashboard extends JFrame {
   TrainerDashboard(GymManagementSystem system, Trainer trainer) {
      this.setTitle("Trainer Dashboard");
      this.setSize(800, 500);
      this.setLocationRelativeTo((Component)null);
      this.setLayout(new BorderLayout());
      JTextArea textArea = new JTextArea();
      textArea.setEditable(false);
      textArea.setFont(new Font("Monospaced", 0, 12));
      String name = String.format(" %-15s: %-30s %n", "Name", trainer.getName());

      textArea.setText("============================================================\n                  TRAINER DASHBOARD                         \n============================================================\n" 
                        + name 
                        + String.format(" %-15s: %-30s %n", "Trainer ID", trainer.getId()) 
                        + String.format(" %-15s: %-30s %n", "Email", trainer.getEmail()) 
                        + String.format(" %-15s: %-30s %n", "Phone", trainer.getPhone()) 
                        + String.format(" %-15s: %-30s %n", "Certification", trainer.getCertification()) 
                        + String.format(" %-15s: %-30.2f PKR %n", "Salary", trainer.getSalary()) 
                        + "------------------------------------------------------------\n                  ASSIGNED MEMBERS                          \n------------------------------------------------------------");

      String[] assignedMembers = new String[]{"Member Name", "Goal", "Current Weight"};
      DefaultTableModel tableModel = new DefaultTableModel(assignedMembers, 0);

      for (int i = 0; i < system.getMembers().size(); i++) {
         Person p = system.getMembers().get(i);
         if (p instanceof Member) {
            Member member = (Member) p;  // Downcasting
            if (member.getAssignedTrainer() != null && member.getAssignedTrainer().getId() == trainer.getId()) {
               tableModel.addRow(new Object[]{member.getName(), member.getGoal().getGoalName(), member.getCurrentWeight()});
            }
         }
      }

      JTable table = new JTable(tableModel);
      this.add(textArea, "North");
      this.add(new JScrollPane(table), "Center");
      this.setVisible(true);
   }
}
