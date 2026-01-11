import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RunnerGUI {
    private static GymManagementSystem system;
    public static void main (String args []){
        GymManagementSystem loadedSystem = GymDataManager.loadGymData("gym_data.dat");
        if (loadedSystem != null) system = loadedSystem;
        else initializeSystem();

        BaseFrame menu = new BaseFrame();
        menu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        menu.setLayout(null);

        Buttons b1 = new Buttons("Login Manager", e -> {
            int attempts = 0;
            while (true) {
                String email = JOptionPane.showInputDialog(menu, "Enter Manager Email:");
                if (email == null) return;
                String password = JOptionPane.showInputDialog(null, "Enter Password:");
                if (password == null) return;

                if (system.getGymManager() != null && 
                    system.getGymManager().getEmail().equalsIgnoreCase(email) && 
                    password.equals("admin123")) {
                    new ManagerDashboard(system);
                    break;
                } else {
                    attempts++;
                    if (attempts >= 3) {
                        JOptionPane.showMessageDialog(null, "You are blocked.");
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Attempt " + attempts + "/3");
                }
            }
        });
        Buttons b2 = new Buttons("Login Trainer", e -> {
            int attempts = 0;
            while (true) {
                String email = JOptionPane.showInputDialog(null, "Enter Trainer Email:");
                if (email == null) return;
                Trainer trainer = null;
                for (int i = 0; i < system.getTrainers().size(); i++) {
                    Person p = system.getTrainers().get(i);
                    if (p instanceof Trainer && ((Trainer) p).getEmail().equalsIgnoreCase(email)) {
                        trainer = (Trainer) p;
                        break;
                    }
                }
                if (trainer != null) {
                    new TrainerDashboard(system, trainer);
                    break;
                } else {
                    attempts++;
                    if (attempts >= 3) {
                        JOptionPane.showMessageDialog(null, "You are blocked.");
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Trainer not found. Attempt " + attempts + "/3");
                }
            }
        });
        Buttons b3 = new Buttons("Login Member", e -> {
            int attempts = 0;
            while (true) {
                String email = JOptionPane.showInputDialog(null, "Enter Member Email:");
                if (email == null) return;
                Member member = null;
                for (int i = 0; i < system.getMembers().size(); i++) {
                    Person p = system.getMembers().get(i);
                    if (p instanceof Member && ((Member) p).getEmail().equalsIgnoreCase(email)) {
                        member = (Member) p;
                        break;
                    }
                }
                if (member != null) {
                    new MemberDashboard(system, member);
                    break;
                } else {
                    attempts++;
                    if (attempts >= 3) {
                        JOptionPane.showMessageDialog(null, "You are blocked.");
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Member not found. Attempt " + attempts + "/3");
                }
            }
        });
        Buttons b4 = new Buttons("Register as Trainer", e -> new RegisterAsTrainer(system));
        Buttons b5 = new Buttons("Register as Member", e -> new RegisterAsMember(system));
        b1.setBounds(140,80,220,45);
        b2.setBounds(140,140,220,45);
        b3.setBounds(140,200,220,45);
        b4.setBounds(140,260,220,45);
        b5.setBounds(140,320,220,45);
        menu.add(b1);
        menu.add(b2);
        menu.add(b3);
        menu.add(b4);
        menu.add(b5);


        menu.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {

        int choice = JOptionPane.showConfirmDialog(
            e.getWindow(),   // parent component
            "Do you want to save all data before exiting?",
            "Confirm Exit",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            GymDataManager.saveGymData("gym_data.dat", system);
            e.getWindow().dispose();   // close this window
        }
        else if (choice == JOptionPane.NO_OPTION) {
            e.getWindow().dispose();   // close without saving
        }
        // CANCEL → do nothing
    }
});


    }

    private static void initializeSystem() {
        system = new GymManagementSystem();
        // Pre-populate a manager
        GymManager manager = new GymManager(1, "Muhammad Ali", "ali@gym.com", "0300-1234567", "Gulberg III, Lahore", 100000);
        system.setGymManager(manager);

        // Add 2 Trainers
        Trainer t1 = new Trainer(101, "Ahmed Khan", "ahmed@gym.com", "0321-9876543", "DHA Phase 6, Lahore", 50000, "NASM");
        Trainer t2 = new Trainer(102, "Fatima Sheikh", "fatima@gym.com", "0333-4567890", "F-10 Markaz, Islamabad", 45000, "ACE");
        system.addTrainer(t1);
        system.addTrainer(t2);

        // Add 5 Members
        createTestMember(201, "Bilal Raza", "bilal@gym.com", "0301-1122334", "Johar Town, Lahore", t1, 70, 65, "Weight Loss", MembershipType.BASIC, "Monthly");
        createTestMember(202, "Zainab Malik", "zainab@gym.com", "0302-2233445", "Clifton Block 4, Karachi", t2, 80, 85, "Weight Gain", MembershipType.PREMIUM, "Quarterly");
        createTestMember(203, "Usman Gondal", "usman@gym.com", "0303-3344556", "Satellite Town, Rawalpindi", t1, 90, 80, "Weight Loss", MembershipType.ELITE, "Annual");
        createTestMember(204, "Ayesha Siddiqui", "ayesha@gym.com", "0304-4455667", "Gulshan-e-Iqbal, Karachi", t2, 75, 80, "Weight Gain", MembershipType.BASIC, "Monthly");
        createTestMember(205, "Hamza Yousaf", "hamza@gym.com", "0305-5566778", "Wapda Town, Lahore", t1, 65, 60, "Weight Loss", MembershipType.PREMIUM, "Annual");
    }

    private static void createTestMember(int id, String name, String email, String phone, String address, Trainer trainer, double currentW, double goalW, String goalType, MembershipType mType, String durationStr) {
        Member m = new Member(id, name, email, phone, address, trainer, currentW, goalW);
        
        Goal goal = new Goal(goalType);
        WorkoutPlan wp = new WorkoutPlan(goalType + " Plan");
        DietPlan dp = new DietPlan(goalType + " Diet", 2000);
        
        if (goalType.equals("Weight Loss")) {
             dp.setCaloriesPerDay(1800); dp.setCarbs(100); dp.setProteins(140); dp.setFats(45);
        } else {
             dp.setCaloriesPerDay(3000); dp.setCarbs(300); dp.setProteins(180); dp.setFats(90);
        }
        
        m.setGoal(goal);
        m.assignWorkoutPlan(wp);
        m.setDietPlan(dp);
        
        Duration duration = new Duration(durationStr);
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(duration.getNumberOfMonths());
        Membership ms = new Membership("MB" + id, startDate.toString(), endDate.toString(), mType, duration);
        m.setMembership(ms);
        
        system.addMembership(ms);
        system.addMember(m);
    }
}
