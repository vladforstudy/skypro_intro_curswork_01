public class EmployeeBook {

    private final int size = 10;
    private final Employee[] employees = new Employee[size];

    // удаление сотрудника по id
    public String deleteEmployeeById(int id) {
        String deletedEmployee = null;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                deletedEmployee = employees[i].getFio();
                employees[i] = null;
                break;
            }
        }

        return deletedEmployee;
    }

    // ниже переделанный вариант
//    public boolean addNewEmployee(String fio, int department, double salary) {
//
//        for (int i = 0; i < size; i++) {
//            if (employees[i] == null) {
//                employees[i] = new Employee(fio, department, salary);
//                return true;
//            }
//        }
//
//        return false;
//    }

    // добавление нового сотрудника
    public Employee addNewEmployee(String fio, int department, double salary) {

        for (int i = 0; i < size; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fio, department, salary);
                return employees[i];
            }
        }

        return null;
    }

    // получение сотрудника по id
    public Employee getById(int id) {

        Employee empl = null;

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // по идее с появлением addNewEmployee() становится не реликтом
//    public void addEmployee(String fio, int department, double salary) {
//
//        if (Employee.getCount() > employees.length) {
//            return null;
//        } else {
//            employees[Employee.getCount() - 1] = new Employee(fio, department, salary);
//
//        }
//    }

    // печать всей информации по всем сотрудникам
    public void printFullInformation() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // затраты на ЗП
    public double salaryCosts() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    // сотрудник с минимальной ЗП
    public Employee minSalaryEmployee() {
        Employee minSalaryEmployee = employees[0];

        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employees[i];
                }
            }
        }
        return minSalaryEmployee;
    }

    // сотрудник с максимальной ЗП
    public Employee maxSalaryEmployee() {
        Employee maxSalaryEmployee = employees[0];

        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employees[i];
                }
            }
        }
        return maxSalaryEmployee;
    }

    // среднее значение ЗП по компании
    public double averageSalaryCosts() {

        int count = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }

        return (salaryCosts() / count);
    }

    // список ФИО всех сотрудников
    public void allEmployeesFio() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFio());
            }
        }
    }

    // индексация ЗП всех сотрудников
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

    // сотрудник с минимальной ЗП в отделе
    public Employee minSalaryEmployeeOfDep(int department) {

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
        return minDepSalaryEmployee;
    }

    // сотрудник с максимальной ЗП в отделе
    public Employee maxSalaryEmployeeOfDep(int department) {

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
        return maxDepSalaryEmployee;
    }

    // затраты на ЗП по отделу
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

    // среднее значение ЗП по отделу
    public double averageDepSalaryCosts(int department) {
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
            }
        }

        return (salaryDepCosts(department) / count);
    }

    // индексация ЗП по отделу
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

    // список сотрудников отдела
    public void depEmployeesFio(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.getId() + ", ФИО: " + employee.getFio() + ", ЗП: " + employee.getSalary());
            }
        }
    }

    // список сотрудников с ЗП < полученного числа
    public void salaryLessThenNumber(double number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < number) {
                System.out.println(employee);
            }
        }
    }

    // список сотрудников с ЗП > полученного числа
    public void salaryMoreThenNumber(double number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > number) {
                System.out.println(employee);
            }
        }
    }
}