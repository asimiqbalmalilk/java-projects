public class Trainer extends Employee {
    private String certification;

    public Trainer(int id, String name, String email, String phone, String address, double salary, String certification) {
        super(id, name, email, phone, address, salary);
        this.certification = certification;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    @Override
    public double calculatePayroll() {
        return getSalary();
    }

    @Override
    public String getRole() {
        return "Trainer";
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", certification='" + certification + '\'' +
                '}';
    }
}
