public class Main {


    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addNewEmployee("Ivanov I.I.", 1, 5000);
        employeeBook.addNewEmployee("Petrov P.P.", 2, 3000);
        employeeBook.addNewEmployee("Sidorov S.S.", 3, 8000);
        employeeBook.addNewEmployee("Malen'kiy M.M.", 4, 4000);
        employeeBook.addNewEmployee("Novaya N.N.", 5, 12000);
        employeeBook.addNewEmployee("Abramova A.A.", 1, 7000);
        employeeBook.addNewEmployee("Bykov B.B.", 2, 2500);
        employeeBook.addNewEmployee("Soroka S.S.", 3, 6000);
        employeeBook.addNewEmployee("Kareev K.K.", 4, 7000);
        employeeBook.addNewEmployee("Zyuzya Z.Z.", 5, 9000);

        double indexationPercent = 10;
        int department = 1;
        double comparisonNumber = 3500;

        employeeBook.printFullInformation();
        System.out.println();
        System.out.println("Сумма затрат на зарплаты в месяц: " + employeeBook.salaryCosts() + " р.");
        System.out.println();
//        employeeBook.minSalaryEmployee();
        System.out.println("Минимальная зарплата у сотрудника: " + employeeBook.minSalaryEmployee().getFio() +
                " - " + employeeBook.minSalaryEmployee().getSalary() + " р.");
        System.out.println();
//        employeeBook.maxSalaryEmployee();
        System.out.println("Максимальная зарплата у сотрудника: " + employeeBook.maxSalaryEmployee().getFio() +
                " - " + employeeBook.maxSalaryEmployee().getSalary() + " р.");
        System.out.println();
//        employeeBook.averageSalaryCosts();
        System.out.println("Среднее значение зарплат: " + employeeBook.averageSalaryCosts() + " р.");
        System.out.println();
        employeeBook.allEmployeesFio();
        System.out.println();
        employeeBook.salaryIndexation(indexationPercent);
        System.out.println();
//        employeeBook.minSalaryEmployeeOfDep(department);
        System.out.println("Минимальная зарплата в отделе " + department + " у сотрудника "
                + employeeBook.minSalaryEmployeeOfDep(department).getFio() +
                " - " + employeeBook.minSalaryEmployeeOfDep(department).getSalary() + " р.");
        System.out.println();
//        employeeBook.maxSalaryEmployeeOfDep(department);
        System.out.println("Максимальная зарплата в отделе " + department + " у сотрудника "
                + employeeBook.maxSalaryEmployeeOfDep(department).getFio() +
                " - " + employeeBook.maxSalaryEmployeeOfDep(department).getSalary() + " р.");
        System.out.println();
        System.out.println("Сумма затрат на зарплаты по отделу " + department + " в месяц: "
                + employeeBook.salaryDepCosts(department));
        System.out.println();
//        employeeBook.averageDepSalaryCosts(department);
        System.out.println("Среднее значение зарплат по отделу " + department + ": "
                + employeeBook.averageDepSalaryCosts(department) + " р.");
        System.out.println();
        employeeBook.depSalaryIndexation(indexationPercent, department);
        System.out.println();
        employeeBook.depEmployeesFio(department);
        System.out.println();
        employeeBook.salaryLessThenNumber(comparisonNumber);
        System.out.println();
        employeeBook.salaryMoreThenNumber(comparisonNumber);
        System.out.println();

        int idForDel = 2;
//        employeeBook.deleteEmployeeById(2);
        System.out.println("Сотрудник с id " + idForDel + " " + employeeBook.deleteEmployeeById(idForDel) + " удалён");
        System.out.println();
        System.out.println(employeeBook.addNewEmployee("Kapustin K.K.", 2, 3800));
        System.out.println();

        int idForGet = 6;
        System.out.println(employeeBook.getById(idForGet));
    }
}