import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MembersTableFrame extends JFrame {
   MembersTableFrame(GymManagementSystem system) {
      this.setTitle("Members List");
      this.setSize(600, 300);
      this.setLocationRelativeTo((Component)null);
      String[] str = new String[]{"ID", "Name", "Email", "Membership"};
      DefaultTableModel tableModel = new DefaultTableModel(str, 0);

      for (int i = 0; i < system.getMembers().size(); i++) {
         Person p = system.getMembers().get(i);
         if (p instanceof Member) {
            Member member = (Member) p;  // Downcasting
            tableModel.addRow(new Object[]{member.getId(), member.getName(), member.getEmail(), member.getMembership() != null ? member.getMembership().getMembershipType() : "None"});
         }
      }

      JTable table = new JTable(tableModel);
      this.add(new JScrollPane(table));
      this.setVisible(true);
   }
}
