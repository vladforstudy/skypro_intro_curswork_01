public class Main {

    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        addEmployee("Ivanov I.I.", 1, 5000);
        addEmployee("Petrov P.P.", 2, 3000);
        addEmployee("Sidorov S.S.", 3, 8000);
        addEmployee("Malen'kiy M.M.", 4, 4000);
        addEmployee("Novaya N.N.", 5, 12000);

        printFullInformation();
        System.out.println("Сумма затрат на зарплаты в месяц: " + salaryCosts() + " р.");
        minSalaryEmployee();
        maxSalaryEmployee();
        averageSalaryCosts();
        allEmployeesFio();
    }

    public static void addEmployee(String fio, int department, double salary) {

        if (Employee.getCount() > employees.length) {
            System.out.println("No more places");
        } else {
            employees[Employee.getCount() - 1] = new Employee(fio, department, salary);
        }
    }

    public static void printFullInformation() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static double salaryCosts() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
         return sum;
    }

    public static void minSalaryEmployee() {
        Employee minSalaryEmployee = employees[0];

        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employees[i];
                }
            }
        }
        System.out.println("Минимальная зарплата: " + minSalaryEmployee.getFio() + " р.");
    }

    public static void maxSalaryEmployee() {
        Employee maxSalaryEmployee = employees[0];

        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employees[i];
                }
            }
        }
        System.out.println("Максимальная зарплата: " + maxSalaryEmployee.getFio() + " р.");
    }

    public static void averageSalaryCosts() {

        System.out.println("Среднее значение зарплат: " + salaryCosts() / (Employee.getCount() - 1) + " р.");
    }

    public static void allEmployeesFio() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFio());
            }
        }
    }
}