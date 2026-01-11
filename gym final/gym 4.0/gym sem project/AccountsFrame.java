import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AccountsFrame extends JFrame {
   public AccountsFrame(GymManagementSystem system) {
      this.setTitle("Financial Report");
      this.setSize(500, 400);
      this.setLocationRelativeTo((Component)null);
      Accounts acc = new Accounts();
      double monthlyRevenue = acc.calculateTotalRevenue(system.getMemberships());
      
      // Downcast for polymorphism
      ArrayList<Trainer> trainers = new ArrayList<>();
      for (int i = 0; i < system.getTrainers().size(); i++) {
         Person p = system.getTrainers().get(i);
         if (p instanceof Trainer) {
            trainers.add((Trainer) p);
         }
      }
      GymManager manager = system.getGymManager() instanceof GymManager ? (GymManager) system.getGymManager() : null;
      
      double salaries = acc.calculateTotalSalaryExpense(trainers, manager);
      double mantainance = acc.calculateMaintenanceExpense();
      double totalMonthlyExpenses = salaries + mantainance;
      double netProfit = monthlyRevenue - totalMonthlyExpenses;
      JTextArea textArea = new JTextArea();
      textArea.setEditable(false);
      textArea.setFont(new Font("Monospaced", 0, 12));
      String str = String.format(" %-30s: %15.2f PKR %n", "Monthly Revenue (Memberships)", monthlyRevenue);
      String report = "============================================================\n"
                      + "                   FINANCIAL REPORT                         \n"
                      + "============================================================\n"
                      + str
                      + "------------------------------------------------------------\n MONTHLY EXPENSES\n"
                      + String.format(" %-30s: %15.2f PKR %n", " - Salaries", salaries)
                      + String.format(" %-30s: %15.2f PKR %n", " - Maintenance", mantainance)
                      + "------------------------------------------------------------\n"
                      + String.format(" %-30s: %15.2f PKR %n", netProfit >= 0.0 ? "NET PROFIT (MONTHLY)" : "NET LOSS (MONTHLY)", netProfit)
                      + "============================================================";
      textArea.setText(report);
      this.add(new JScrollPane(textArea));
      this.setVisible(true);
   }
}
