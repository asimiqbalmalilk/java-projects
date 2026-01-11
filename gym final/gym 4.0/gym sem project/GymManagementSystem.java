import java.util.*;
import java.io.Serializable;

public class GymManagementSystem implements Serializable {
    private Person manager;
    private Accounts accounts;
    private ArrayList<Person> members;
    private ArrayList<Person> trainers;
    private ArrayList<Membership> memberships;

    public GymManagementSystem() {
        this.members = new ArrayList<>();
        this.trainers = new ArrayList<>();
        this.memberships = new ArrayList<>();
        this.accounts = new Accounts();
    }

    public void setGymManager(Person manager) {
        if (manager instanceof GymManager) {
            this.manager = manager;
        } else {
            throw new IllegalArgumentException("Manager must be a GymManager");
        }
    }

    public Person getGymManager() {
        return manager;
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public ArrayList<Person> getTrainers() {
        return trainers;
    }

    public ArrayList<Membership> getMemberships() {
        return memberships;
    }

    public void addMember(Person person) {
        if (person instanceof Member) {
            members.add(person);
        } else {
            throw new IllegalArgumentException("Person must be a Member");
        }
    }

    public void addTrainer(Person person) {
        if (person instanceof Trainer) {
            trainers.add(person);
        } else {
            throw new IllegalArgumentException("Person must be a Trainer");
        }
    }

    public boolean removeMember(int memberId) {
        Member member = findMemberById(memberId);
        if (member != null) {
            // Remove associated membership automatically
            memberships.removeIf(m -> m.getMembershipId().equals("MB" + memberId));
            members.remove(member);
            return true;
        }
        return false;
    }

    public boolean removeTrainer(int trainerId) {
        Trainer trainer = findTrainerById(trainerId);
        if (trainer != null) {
            // Unassign this trainer from all members automatically
            for (int i = 0; i < members.size(); i++) {
                Person p = members.get(i);
                if (p instanceof Member) {
                    Member m = (Member) p;
                    if (m.getAssignedTrainer() != null && m.getAssignedTrainer().getId() == trainerId) {
                        m.setAssignedTrainer(null);
                    }
                }
            }
            trainers.remove(trainer);
            return true;
        }
        return false;
    }

    public void addMembership(Membership membership) {
        memberships.add(membership);
    }

    public Member findMemberById(int memberId) {
        for (int i = 0; i < members.size(); i++) {
            Person person = members.get(i);
            if (person instanceof Member && person.getId() == memberId) {
                return (Member) person;
            }
        }
        return null;
    }

    public Trainer findTrainerById(int trainerId) {
        for (int i = 0; i < trainers.size(); i++) {
            Person person = trainers.get(i);
            if (person instanceof Trainer && person.getId() == trainerId) {
                return (Trainer) person;
            }
        }
        return null;
    }

    public void assignTrainerToMember(Member member, Trainer trainer) {
        member.assignTrainer(trainer);
    }

    public int getTrainerMemberCount(Trainer trainer) {
        int count = 0;
        for (int i = 0; i < members.size(); i++) {
            Person p = members.get(i);
            if (p instanceof Member) {
                Member m = (Member) p;
                if (m.getAssignedTrainer() != null && m.getAssignedTrainer().getId() == trainer.getId()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void displayAllMembers() {
        System.out.println("\n=== All Members Registry ===");
        System.out.printf("%-6s | %-20s | %-15s | %-15s | %-30s%n", "ID", "Name", "Membership", "Phone", "Address");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < members.size(); i++) {
            Person p = members.get(i);
            if (p instanceof Member) {
                Member member = (Member) p;
                String mType = (member.getMembership() != null && member.getMembership().getMembershipType() != null) 
                               ? member.getMembership().getMembershipType().getType() 
                               : "No Membership";
                
                System.out.printf("%-6d | %-20s | %-15s | %-15s | %-30s%n", 
                        member.getId(), member.getName(), mType, member.getPhone(), member.getAddress());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    public void displayAllTrainers() {
        System.out.println("\n=== All Trainers Registry ===");
        System.out.printf("%-6s | %-20s | %-25s | %-15s | %-15s | %-15s%n", "ID", "Name", "Email", "Phone", "Certification", "Salary");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < trainers.size(); i++) {
            Person p = trainers.get(i);
            if (p instanceof Trainer) {
                Trainer trainer = (Trainer) p;
                System.out.printf("%-6d | %-20s | %-25s | %-15s | %-15s | %-15.2f%n", 
                        trainer.getId(), trainer.getName(), trainer.getEmail(), trainer.getPhone(), trainer.getCertification(), trainer.getSalary());
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }

    public void displayAccountsSummary() {
        System.out.println("\n=== Accounts Summary ===");
        System.out.println(accounts);
    }

    // Polymorphism example: Display roles using Person references
    public void displayAllRoles() {
        System.out.println("\n=== All Roles in System ===");
        if (manager != null) {
            System.out.println("Manager: " + manager.getRole());
        }
        for (int i = 0; i < members.size(); i++) {
            Person p = members.get(i);
            System.out.println("Member: " + p.getRole());
        }
        for (int i = 0; i < trainers.size(); i++) {
            Person p = trainers.get(i);
            System.out.println("Trainer: " + p.getRole());
        }
    }
}
