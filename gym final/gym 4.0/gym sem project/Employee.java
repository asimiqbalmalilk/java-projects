public class Employee extends Person implements Payable {
    protected double salary;

    public Employee(int id, String name, String email, String phone, String address, double salary) {
        super(id, name, email, phone, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculatePayroll() {
        return salary;
    }

    @Override
    public String getRole() {
        return "Employee";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
