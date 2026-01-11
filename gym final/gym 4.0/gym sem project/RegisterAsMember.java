import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class RegisterAsMember {
    public RegisterAsMember(GymManagementSystem system) {
            String name = getValidString("Enter Name:", "^[a-zA-Z\\s]+$", "Name must contain only letters.");
            if (name == null) return;
            String email = getValidString("Enter Email:", "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "Invalid Email format.");
            if (email == null) return;
            String phone = getValidString("Enter Phone:", "^[0-9\\-]+$", "Phone must contain only numbers and dashes.");
            if (phone == null) return;
            String address = getValidString("Enter Address:", null, null);
            if (address == null) return;
            Double currentWeight = getValidDouble("Enter Current Weight (kg):");
            if (currentWeight == null) return;
            
            Object[] goals = {"Weight Loss", "Weight Gain"};
            int goalChoice = JOptionPane.showOptionDialog(null, "Select Goal:", "Goal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, goals, goals[0]);
            if (goalChoice == JOptionPane.CLOSED_OPTION) return;
            String goalName = (String) goals[goalChoice];
            double goalWeight = (goalChoice == 0) ? currentWeight - 5 : currentWeight + 5;
            Object[] types = {"Basic", "Premium", "Elite"};
            int typeChoice = JOptionPane.showOptionDialog(null, "Select Membership Type:", "Type", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
            if (typeChoice == JOptionPane.CLOSED_OPTION) return;
            MembershipType type = MembershipType.BASIC;
            if (typeChoice == 1) type = MembershipType.PREMIUM;
            if (typeChoice == 2) type = MembershipType.ELITE;
            Object[] durations = {"Monthly", "Quarterly", "Annual"};
            int durChoice = JOptionPane.showOptionDialog(null, "Select Duration:", "Duration", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, durations, durations[0]);
            if (durChoice == JOptionPane.CLOSED_OPTION) return;
            Duration duration = new Duration((String) durations[durChoice]);
            Trainer assignedTrainer = null;
            ArrayList<Trainer> available = new ArrayList<>();
            for (int i = 0; i < system.getTrainers().size(); i++) {
                Person p = system.getTrainers().get(i);
                if (p instanceof Trainer) {
                    Trainer t = (Trainer) p;  // Downcasting
                    if (system.getTrainerMemberCount(t) < 10) {
                        available.add(t);
                    }
                }
            }
            if (!available.isEmpty()) {
                assignedTrainer = available.get(new Random().nextInt(available.size()));
            }
            int newId = 201;
            for (int i = 0; i < system.getMembers().size(); i++) {
                Person p = system.getMembers().get(i);
                if (p.getId() >= newId) newId = p.getId() + 1;
            }
            Member member = new Member(newId, name, email, phone, address, assignedTrainer, currentWeight, goalWeight);
            Goal goal = new Goal(goalName);
            WorkoutPlan wp = new WorkoutPlan(goalName + " Plan");
            DietPlan dp = new DietPlan(goalName + " Diet", 2000);
            if (goalName.equals("Weight Loss")) {
                dp.setCaloriesPerDay(1800);
                dp.setCarbs(100);
                dp.setProteins(140);
                dp.setFats(45);
            } else {
                dp.setCaloriesPerDay(3000);
                dp.setCarbs(300);
                dp.setProteins(180);
                dp.setFats(90);
            }
            member.setGoal(goal);
            member.assignWorkoutPlan(wp);
            member.setDietPlan(dp);
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusMonths(duration.getNumberOfMonths());
            Membership ms = new Membership("MB" + member.getId(), startDate.toString(), endDate.toString(), type, duration);
            member.setMembership(ms);
            system.addMembership(ms);
            system.addMember(member);
            JOptionPane.showMessageDialog(null, "Member registered successfully");
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

    private Double getValidDouble(String prompt) {
        int attempts = 0;
        while (attempts < 3) {
            String input = JOptionPane.showInputDialog(null, prompt);
            if (input == null) return null;
            try {
                double val = Double.parseDouble(input);
                if (val <= 0) {
                    attempts++;
                    if (attempts < 3) JOptionPane.showMessageDialog(null, "Value must be positive. Attempt " + attempts + "/3");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                attempts++;
                if (attempts < 3) JOptionPane.showMessageDialog(null, "Invalid number. Attempt " + attempts + "/3");
            }
        }
        JOptionPane.showMessageDialog(null, "You are blocked.");
        System.exit(0);
        return null;
    }
}
