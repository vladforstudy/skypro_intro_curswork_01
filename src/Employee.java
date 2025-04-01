public class Employee {

    private final String fio;
    private int department;
    private double salary;
    private int id;

    public Employee(String fio, int department, double salary) {
        getId();
        this.fio = fio;
        this.department = department;
        this.salary = salary;
    }

    static int count;

    public static int getCount() {
        return count;
    }

    public String getFio() {
        return fio;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        this.id = count;
        count++;
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id: " + id +
                ", fio: " + fio +
                ", department: " + department +
                ", salary: " + salary + " р." +
                '}';
    }
}
