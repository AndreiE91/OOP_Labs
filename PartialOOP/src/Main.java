public class Main {
    public static void main(String[] args) {
        Employee angajat1 = new Developer("Joel", 3500, Level.SENIOR);
        Employee angajat2 = new Developer("Changpeng", 3000, Level.MID);
        Employee[] angajati = new Employee[Department.getMAXEMPLOYEES()];
        Department dep1 = new Department("Andromeda Headquarters", angajati);
        dep1.hireEmployee(angajat1);
        dep1.hireEmployee(angajat2);
        dep1.displayAllEmployees();
        dep1.fireEmployee(angajat2);
        dep1.displayAllEmployees();
        System.out.println("Company \"" + dep1.getDepartmentName() + "\" has to pay all of its employes the sum of " + dep1.calculateTotalSalariesForDecember());
        System.out.println("There is a total of " + dep1.countAutomationTesters() + " automation testers in company \"" + dep1.getDepartmentName() + "\"");
        Employee angajat3 = new Tester("John", 4000, Level.MID, true);
        Employee angajat4 = new Tester("Cooper", 4300, Level.JUNIOR, false);
        Employee angajat5 = new Tester("Brad", 4400, Level.SENIOR, true);
        dep1.hireEmployee(angajat3);
        dep1.hireEmployee(angajat4);
        dep1.hireEmployee(angajat5);
        dep1.displayAllEmployees();
        System.out.println("Company \"" + dep1.getDepartmentName() + "\" has to pay all of its employes the sum of " + dep1.calculateTotalSalariesForDecember());
        System.out.println("There is a total of " + dep1.countAutomationTesters() + " automation testers in company \"" + dep1.getDepartmentName() + "\"");
        Employee angajat6 = new Architect("Catalin", 5000, Level.MID, 17);
        Employee angajat7 = new Architect("Mihai", 4000, Level.SENIOR);
        Employee angajat8 = new Architect("Catalin", 3000, Level.JUNIOR, 3);
        dep1.hireEmployee(angajat6);
        dep1.hireEmployee(angajat7);
        dep1.hireEmployee(angajat8);
        dep1.displayAllEmployees();
        dep1.fireEmployee(dep1.findArchitectWithMostProjectsInPortfolio());
        System.out.println("Company \"" + dep1.getDepartmentName() + "\" has to pay all of its employes the sum of " + dep1.calculateTotalSalariesForDecember());
    }

}
