public abstract class Employee {
    //Variables
    private String employeeName;
    private int salary;
    private Level level;

    //Constructors
    public Employee(String name, int salary, Level level) {
        this.employeeName = name;
        this.salary = salary;
        this.level = level;
    }

    //Getters and setters
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    //Methods
    public double computeChristmasBonus() {
        return this.salary;
    }

    ;
}
