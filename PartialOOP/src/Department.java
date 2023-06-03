public class Department {
    //Variables
    private static int MAXEMPLOYEES = 20;
    private String departmentName;
    private int maxEmployees;
    private Employee[] employees;
    int employeesIndex;

    //Constructors
    public Department(String name, int maxEmployees, Employee[] employees) {
        this.departmentName = name;
        this.maxEmployees = maxEmployees;
        this.employees = employees;
    }

    public Department(String name, Employee[] employees) {
        this.departmentName = name;
        this.maxEmployees = MAXEMPLOYEES;
        this.employees = employees;
    }
    //Getters and setters


    public static int getMAXEMPLOYEES() {
        return MAXEMPLOYEES;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    //Methods
    public void hireEmployee(Employee employee) {
        if (employeesIndex < maxEmployees) {
            employees[employeesIndex] = employee;
            ++employeesIndex;
            System.out.println("Hired employee number " + employeesIndex + ", named \"" + employee.getEmployeeName() + "\"");
        } else {
            System.out.println("Could not hire employee \"" + employee.getEmployeeName() + "\", the employees list is already full.");
        }
    }

    public void fireEmployee(Employee employee) {
        int j = 0;
        while (j < employeesIndex) {
            if (employees[j].equals(employee)) {
                while (j + 1 < maxEmployees && employees[j + 1] != null) {
                    employees[j] = employees[j + 1];
                    ++j;
                }
                employees[j] = null;
                --employeesIndex;
                System.out.println("Fired \"" + employee.getEmployeeName() + "\"!");
                break;
            }
            ++j;
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < employeesIndex; ++i) {
            System.out.println("Employee \"" + employees[i].getEmployeeName() + "\", with salary = " + employees[i].getSalary() + " and level " + employees[i].getLevel());
        }
    }

    public int calculateTotalSalariesForDecember() {
        int totalSum = 0;
        for (int i = 0; i < employeesIndex; ++i) {
            totalSum += employees[i].computeChristmasBonus();
        }
        return totalSum;
    }

    public int countAutomationTesters() {
        int count = 0;
        for (int i = 0; i < employeesIndex; ++i) {
            if (employees[i] instanceof Tester) {
                if (((Tester) employees[i]).isKnowsAutomationTesting()) {
                    ++count;
                }
            }
        }
        return count;
    }

    public Architect findArchitectWithMostProjectsInPortfolio() {
        int max = 0;
        Architect temp = new Architect("Placeholder", 0, Level.JUNIOR);
        for (int i = 0; i < employeesIndex; ++i) {
            if (employees[i] instanceof Architect) {
                if (((Architect) employees[i]).getProjectsInPortfolio() > max) {
                    max = ((Architect) employees[i]).getProjectsInPortfolio();
                    temp = (Architect) employees[i];
                }
            }
        }
        if (temp.getEmployeeName() != "Placeholder") {
            System.out.println("Architect \"" + temp.getEmployeeName() + "\" has the most projects in their portfolio = " + temp.getProjectsInPortfolio());
            return temp;
        } else {
            System.out.println("No architect with greater than 0 projects in portfolio found");
            return null;
        }
    }
}
