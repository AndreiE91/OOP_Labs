public class Tester extends Employee {
    //Variables
    private boolean knowsAutomationTesting;

    //Constructors
    public Tester(String name, int salary, Level level) {
        super(name, salary, level);
    }

    public Tester(String name, int salary, Level level, boolean knowsAutomationTesting) {
        super(name, salary, level);
        this.knowsAutomationTesting = knowsAutomationTesting;
    }

    //Getters and setters
    public boolean isKnowsAutomationTestingnowsAutomationTesting() {
        return knowsAutomationTesting;
    }

    public void setKnowsAutomationTesting(boolean knowsAutomationTesting) {
        this.knowsAutomationTesting = knowsAutomationTesting;
    }

    //Methods
    @Override
    public double computeChristmasBonus() {
        if (knowsAutomationTesting && this.getLevel() != Level.JUNIOR) {
            return this.getSalary() * 1.3;
        } else {
            return this.getSalary();
        }
    }
}
