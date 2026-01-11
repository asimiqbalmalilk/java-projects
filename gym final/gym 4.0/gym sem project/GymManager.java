public class GymManager extends Employee {

    public GymManager(int id, String name, String email, String phone, String address, double salary) {
        super(id, name, email, phone, address, salary);
    }

    @Override
    public double calculatePayroll() {
        return getSalary();
    }

    @Override
    public String getRole() {
        return "GymManager";
    }

    @Override
    public String toString() {
        return "GymManager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
