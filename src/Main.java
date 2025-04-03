import java.util.Arrays;

public class Main {

    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        addEmployee("Ivanov I.I.", 1, 5000);
        addEmployee("Petrov P.P.", 2, 3000);
        addEmployee("Sidorov S.S.", 3, 8000);
        addEmployee("Malen'kiy M.M.", 4, 4000);
        addEmployee("Novaya N.N.", 5, 12000);
        addEmployee("Abramova A.A.", 1, 7000);
        addEmployee("Bykov B.B.", 2, 2500);
        addEmployee("Soroka S.S.", 3, 6000);
        addEmployee("Kareev K.K.", 4, 7000);
        addEmployee("Zyuzya Z.Z.", 5, 9000);

        double indexationPercent = 10;
        int department = 1;
        double comparisonNumber = 3500;

        printFullInformation();
        System.out.println("Сумма затрат на зарплаты в месяц: " + salaryCosts() + " р.");
        minSalaryEmployee();
        maxSalaryEmployee();
        averageSalaryCosts();
        allEmployeesFio();

        salaryIndexation(indexationPercent);
        minSalaryEmployeeOfDep(department);
        maxSalaryEmployeeOfDep(department);
        System.out.println("Сумма затрат на зарплаты по отделу " + department + " в месяц: "
                + salaryDepCosts(department));
        averageDepSalaryCosts(department);
        depSalaryIndexation(indexationPercent, department);
        depEmployeesFio(department);
        salaryLessThenNumber(comparisonNumber);
        salaryMoreThenNumber(comparisonNumber);
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

    public static void salaryIndexation(double percent) {
        percent /= 100;

        for (Employee employee : employees) {
            if (employee != null) {
                double salary = employee.getSalary();
                salary += salary * percent;
                employee.setSalary(salary);
                System.out.println("Проиндексированная ЗП " + employee.getFio() + ": " + employee.getSalary());
            }
        }
    }

    public static void minSalaryEmployeeOfDep(int department) {

        double minDepSalary = Double.MAX_VALUE;
        Employee minDepSalaryEmployee = null;

        for (Employee employee:employees) {
            if (employee != null) {
                if (employee.getDepartment() == department && employee.getSalary() < minDepSalary) {
                    minDepSalaryEmployee = employee;
                    minDepSalary = employee.getSalary();
                }
            }
        }
        System.out.println("Минимальная зарплата в отделе " + department + " у сотрудника "
                + minDepSalaryEmployee.getFio() + " р.");
    }

    public static void maxSalaryEmployeeOfDep(int department) {

        double maxDepSalary = Double.MIN_VALUE;
        Employee maxDepSalaryEmployee = null;

        for (Employee employee:employees) {
            if (employee != null) {
                if (employee.getDepartment() == department && employee.getSalary() > maxDepSalary) {
                    maxDepSalaryEmployee = employee;
                    maxDepSalary = employee.getSalary();
                }
            }
        }
        System.out.println("Максимальная зарплата в отделе " + department + " у сотрудника "
                + maxDepSalaryEmployee.getFio() + " р.");
    }

    public static double salaryDepCosts(int department) {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    sum += employee.getSalary();
                }
            }
        }

        return sum;
    }

    public static void averageDepSalaryCosts(int department) {
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
            }
        }

        System.out.println("Среднее значение зарплат по отделу " + department + ": "
                + salaryDepCosts(department) / count + " р.");
    }

    public static void depSalaryIndexation(double percent, int department) {
        percent /= 100;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double salary = employee.getSalary();
                salary += salary * percent;
                employee.setSalary(salary);
                System.out.println("Проиндексированная ЗП сотрудника отдела " + department + " " + employee.getFio()
                        + ": " + employee.getSalary());
            }
        }
    }

    public static void depEmployeesFio(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.getId() + ", ФИО: " + employee.getFio() + ", ЗП: " + employee.getSalary());
            }
        }
    }

    public static void salaryLessThenNumber(double number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < number) {
                System.out.println(employee);
            }
        }
    }

    public static void salaryMoreThenNumber(double number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > number) {
                System.out.println(employee);
            }
        }
    }
}