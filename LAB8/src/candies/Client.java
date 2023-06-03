package candies;

public class Client {
    private String name;
    private double budget;

    public Client(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }
}
