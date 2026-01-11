import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ManagerDashboard extends JFrame {
   GymManagementSystem system;

   public ManagerDashboard(GymManagementSystem system) {
      this.system = system;
      this.setTitle("Manager Dashboard");
      this.setSize(600, 400);
      this.setLocationRelativeTo((Component)null);
      this.setDefaultCloseOperation(3);
      JPanel pannel = new JPanel(new GridLayout(3, 3, 15, 15));
      pannel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      pannel.setBackground(new Color(245, 245, 245));

      Buttons b1 = new Buttons("View Members",e -> new MembersTableFrame(system) );
      Buttons b2 = new Buttons("View Trainers",e -> new TrainersTableFrame(system));
      Buttons b3 = new Buttons("Delete Member", e -> new DeleteMemberFrame(system));
      Buttons b4 = new Buttons("Delete Trainer", e -> new DeleteTrainerFrame(system));
      Buttons b5 = new Buttons("Add Member", e -> new RegisterAsMember(system));
      Buttons b6 = new Buttons("Add Trainer", e -> new RegisterAsTrainer(system));
      Buttons b7 = new Buttons("View Financial Report", e -> new AccountsFrame(system));
      Buttons b8 = new Buttons("Save Data", e -> GymDataManager.saveGymData("gym_data.dat", system));
      Buttons b9 = new Buttons("Logout", e -> this.dispose());

      pannel.add(b1);
      pannel.add(b2);
      pannel.add(b3);
      pannel.add(b4);
      pannel.add(b5);
      pannel.add(b6);
      pannel.add(b7);
      pannel.add(b8);
      pannel.add(b9);

      this.add(pannel);
      this.setVisible(true);
   }
}