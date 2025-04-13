public class Main {


    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Ivanov I.I.", 1, 5000);
        employeeBook.addEmployee("Petrov P.P.", 2, 3000);
        employeeBook.addEmployee("Sidorov S.S.", 3, 8000);
        employeeBook.addEmployee("Malen'kiy M.M.", 4, 4000);
        employeeBook.addEmployee("Novaya N.N.", 5, 12000);
        employeeBook.addEmployee("Abramova A.A.", 1, 7000);
        employeeBook.addEmployee("Bykov B.B.", 2, 2500);
        employeeBook.addEmployee("Soroka S.S.", 3, 6000);
        employeeBook.addEmployee("Kareev K.K.", 4, 7000);
        employeeBook.addEmployee("Zyuzya Z.Z.", 5, 9000);

        double indexationPercent = 10;
        int department = 1;
        double comparisonNumber = 3500;

        employeeBook.printFullInformation();
        System.out.println("Сумма затрат на зарплаты в месяц: " + employeeBook.salaryCosts() + " р.");
        employeeBook.minSalaryEmployee();
        employeeBook.maxSalaryEmployee();
        employeeBook.averageSalaryCosts();
        employeeBook.allEmployeesFio();

        employeeBook.salaryIndexation(indexationPercent);
        employeeBook.minSalaryEmployeeOfDep(department);
        employeeBook.maxSalaryEmployeeOfDep(department);
        System.out.println("Сумма затрат на зарплаты по отделу " + department + " в месяц: "
                + employeeBook.salaryDepCosts(department));
        employeeBook.averageDepSalaryCosts(department);
        employeeBook.depSalaryIndexation(indexationPercent, department);
        employeeBook.depEmployeesFio(department);
        employeeBook.salaryLessThenNumber(comparisonNumber);
        employeeBook.salaryMoreThenNumber(comparisonNumber);
        employeeBook.deleteEmployeeById(2);

        if (employeeBook.addNewEmployee("Kapustin K.K.", 2, 3800)) {
            System.out.println("New employee added");
        } else {
            System.out.println("No more places");
        }

        System.out.println(employeeBook.getById(6));
    }
}