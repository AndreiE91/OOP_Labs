public class Architect extends Employee {
    //Variables
    private int projectsInPortfolio;

    //Constructors
    public Architect(String name, int salary, Level level) {
        super(name, salary, level);
    }

    public Architect(String name, int salary, Level level, int projectsInPortfolio) {
        super(name, salary, level);
        this.projectsInPortfolio = projectsInPortfolio;
    }

    //Getters and setters

    public int getProjectsInPortfolio() {
        return projectsInPortfolio;
    }

    public void setProjectsInPortfolio(int projectsInPortfolio) {
        this.projectsInPortfolio = projectsInPortfolio;
    }

    //Methods
    @Override
    public double computeChristmasBonus() {
        if (projectsInPortfolio > 5 && this.getLevel() == Level.SENIOR) {
            return this.getSalary() * 1.7;
        } else {
            return this.getSalary() * 1.5;
        }
    }
}