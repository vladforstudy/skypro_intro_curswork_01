public class EmployeeBook {

    private final int size = 10;
    private final Employee[] employees = new Employee[size];

    public void deleteEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                break;
            }
        }
    }

    public boolean addNewEmployee(String fio, int department, double salary) {

        for (int i = 0; i < size; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fio, department, salary);
                return true;
            }
        }

        return false;
    }

    public Employee getById(int id) {

        Employee empl = null;

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                empl = employee;
                break;
            }
        }
        return empl;
    }


    void addEmployee(String fio, int department, double salary) {

        if (Employee.getCount() > employees.length) {
            System.out.println("No more places");
        } else {
            employees[Employee.getCount() - 1] = new Employee(fio, department, salary);
        }
    }

    public void printFullInformation() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double salaryCosts() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public void minSalaryEmployee() {
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

    public void maxSalaryEmployee() {
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

    public void averageSalaryCosts() {

        System.out.println("Среднее значение зарплат: " + salaryCosts() / (Employee.getCount() - 1) + " р.");
    }

    public void allEmployeesFio() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFio());
            }
        }
    }

    public void salaryIndexation(double percent) {
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

    public void minSalaryEmployeeOfDep(int department) {

        double minDepSalary = Double.MAX_VALUE;
        Employee minDepSalaryEmployee = null;

        for (Employee employee : employees) {
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

    public void maxSalaryEmployeeOfDep(int department) {

        double maxDepSalary = Double.MIN_VALUE;
        Employee maxDepSalaryEmployee = null;

        for (Employee employee : employees) {
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

    public double salaryDepCosts(int department) {
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

    public void averageDepSalaryCosts(int department) {
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
            }
        }

        System.out.println("Среднее значение зарплат по отделу " + department + ": "
                + salaryDepCosts(department) / count + " р.");
    }

    public void depSalaryIndexation(double percent, int department) {
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

    public void depEmployeesFio(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.getId() + ", ФИО: " + employee.getFio() + ", ЗП: " + employee.getSalary());
            }
        }
    }

    public void salaryLessThenNumber(double number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < number) {
                System.out.println(employee);
            }
        }
    }

    public void salaryMoreThenNumber(double number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > number) {
                System.out.println(employee);
            }
        }
    }
}