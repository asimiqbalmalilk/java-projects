import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteTrainerFrame extends JFrame {
   private int attempts = 0;
   public DeleteTrainerFrame(GymManagementSystem system) {
      this.setTitle("Delete Trainer");
      this.setSize(350, 200);
      this.setLocationRelativeTo((Component)null);
      JTextField textField = new JTextField();
      JButton b1 = new JButton("Delete");
      JPanel pannel = new JPanel(new GridLayout(2, 2, 10, 10));
      pannel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      pannel.add(new JLabel("Trainer ID:"));
      pannel.add(textField);
      pannel.add(b1);
      this.add(pannel);
      b1.addActionListener(e -> {
         try {
            int tempID = Integer.parseInt(textField.getText());
            boolean removed = system.removeTrainer(tempID);
            if (removed) {
               JOptionPane.showMessageDialog(this, "Trainer deleted");
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
