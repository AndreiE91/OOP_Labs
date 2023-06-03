public class Developer extends Employee {
    //Variables
    //Constructors
    public Developer(String name, int salary, Level level) {
        super(name, salary, level);
    }

    //Getters and setters
    //Methods
    @Override
    public double computeChristmasBonus() {
        switch (this.getLevel()) {
            case MID:
                return this.getSalary() * 1.2;
            case SENIOR:
                return this.getSalary() * 1.3;
            default:
                return this.getSalary();
        }
    }

    ;
}
