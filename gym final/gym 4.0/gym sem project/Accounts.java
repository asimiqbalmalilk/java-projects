import java.util.ArrayList;
import java.io.Serializable;

public class Accounts implements Serializable {

    public Accounts() {
    }

    public double calculateTotalPayroll(ArrayList<Payable> employees){
        double total = 0;
        for (int i = 0; i < employees.size(); i++) {
            Payable emp = employees.get(i);
            total += emp.calculatePayroll();
        }
        return total;
    }

    public double calculateTotalRevenue(ArrayList<Membership> memberships) {
        double revenue = 0;
        for (int i = 0; i < memberships.size(); i++) {
            Membership m = memberships.get(i);
            revenue += m.calculateFinalAmount() / m.getDuration().getNumberOfMonths();
        }
        return revenue;
    }

    public double calculateTotalSalaryExpense(ArrayList<Trainer> trainers, GymManager manager) {
        ArrayList<Payable> payables = new ArrayList<>();
        if (manager != null) {
            payables.add(manager);
        }
        payables.addAll(trainers);
        return calculateTotalPayroll(payables);
    }

    public double calculateMaintenanceExpense() {
        // Fixed monthly maintenance cost for the gym facility
        return 50000.0;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                '}';
    }
}
