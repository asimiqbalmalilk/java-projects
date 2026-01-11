import java.io.*;

public class GymDataManager {
    
   
    public static void saveGymData(String filename, GymManagementSystem system) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(system);
            oos.close();
            System.out.println("Gym data saved successfully to: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving gym data: " + e.getMessage());
        }
    }
    
    /**
     * Load all gym data from a file
     * @param filename - path to load file
     * @return GymManagementSystem with loaded data, or null if load fails
     */
    public static GymManagementSystem loadGymData(String filename) {
        if (!new File(filename).exists()) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            GymManagementSystem system = (GymManagementSystem) ois.readObject();
            ois.close();
            System.out.println("Gym data loaded successfully from: " + filename);
            return system;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading gym data: " + e.getMessage());
            return null;
        }
    }
}
