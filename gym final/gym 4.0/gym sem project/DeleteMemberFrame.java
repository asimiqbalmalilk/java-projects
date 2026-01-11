import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteMemberFrame extends JFrame {
   private int attempts = 0;
   public DeleteMemberFrame(GymManagementSystem system) {
      this.setTitle("Delete Member");
      this.setSize(350, 200);
      this.setLocationRelativeTo((Component)null);
      JTextField textField = new JTextField();
      JButton b1 = new JButton("Delete");
      JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
      panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      panel.add(new JLabel("Member ID:"));
      panel.add(textField);
      panel.add(b1);
      this.add(panel);
      b1.addActionListener(e -> {
         try {
            int tempID = Integer.parseInt(textField.getText());
            boolean removed = system.removeMember(tempID);
            if (removed) {
               JOptionPane.showMessageDialog(this, "Member deleted");
               this.dispose();
            } else {
               handleError();
            }
         } catch (Exception var5) {
            handleError();
         }

      });
      this.setVisible(true);
   }

   private void handleError() {
      attempts++;
      if (attempts >= 3) {
         JOptionPane.showMessageDialog(this, "You are blocked.");
         System.exit(0);
      }
      JOptionPane.showMessageDialog(this, "Incorrect Data. Attempt " + attempts + "/3");
   }
}
