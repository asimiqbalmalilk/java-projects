import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TrainersTableFrame extends JFrame {
   TrainersTableFrame(GymManagementSystem system) {
      this.setTitle("Trainers List");
      this.setSize(600, 300);
      this.setLocationRelativeTo((Component)null);
      String[] str = new String[]{"ID", "Name", "Email", "Certification", "Salary"};
      DefaultTableModel tableModel = new DefaultTableModel(str, 0);

      for (int i = 0; i < system.getTrainers().size(); i++) {
         Person p = system.getTrainers().get(i);
         if (p instanceof Trainer) {
            Trainer trainer = (Trainer) p;  // Downcasting
            tableModel.addRow(new Object[]{trainer.getId(), trainer.getName(), trainer.getEmail(), trainer.getCertification(), trainer.getSalary()});
         }
      }

      JTable table = new JTable(tableModel);
      this.add(new JScrollPane(table));
      this.setVisible(true);
   }
}
