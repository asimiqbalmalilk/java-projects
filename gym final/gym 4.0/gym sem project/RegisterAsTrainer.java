import javax.swing.JOptionPane;

public class RegisterAsTrainer {
    public RegisterAsTrainer(GymManagementSystem system) {
            if (system.getTrainers().size() >= 3) {
                JOptionPane.showMessageDialog(null, "Maximum trainers reached");
                return;
            }
            String name = getValidString("Enter Name:", "^[a-zA-Z\\s]+$", "Name must contain only letters.");
            if (name == null) return;
            String email = getValidString("Enter Email:", "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "Invalid Email format.");
            if (email == null) return;
            String phone = getValidString("Enter Phone:", "^[0-9\\-]+$", "Phone must contain only numbers and dashes.");
            if (phone == null) return;
            String address = getValidString("Enter Address:", null, null);
            if (address == null) return;
            String certification = getValidString("Enter Certification:", "^[a-zA-Z\\s]+$", "Certification must contain only letters.");
            if (certification == null) return;
            double salary = 30000;
            if (certification.equalsIgnoreCase("NASM")) salary += 20000;
            else if (certification.equalsIgnoreCase("ACE")) salary += 15000;
            else if (certification.equalsIgnoreCase("ISSA")) salary += 10000;
            else salary += 5000;
            int newId = 101;
            for (int i = 0; i < system.getTrainers().size(); i++) {
                Person p = system.getTrainers().get(i);
                if (p.getId() >= newId) newId = p.getId() + 1;
            }
            Trainer trainer = new Trainer(newId, name, email, phone, address, salary, certification);
            system.addTrainer(trainer);
            JOptionPane.showMessageDialog(null, "Trainer registered successfully");
        }

    private String getValidString(String prompt, String regex, String errorMsg) {
        int attempts = 0;
        while (attempts < 3) {
            String input = JOptionPane.showInputDialog(null, prompt);
            if (input == null) return null;
            if (!input.trim().isEmpty()) {
                if (regex == null || input.matches(regex)) {
                    return input;
                }
                JOptionPane.showMessageDialog(null, errorMsg);
            } else {
                JOptionPane.showMessageDialog(null, "Input cannot be empty.");
            }
            attempts++;
            if (attempts < 3) JOptionPane.showMessageDialog(null, "Attempt " + attempts + "/3");
        }
        JOptionPane.showMessageDialog(null, "You are blocked.");
        System.exit(0);
        return null;
    }
}
