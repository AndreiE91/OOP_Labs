package candies;

import java.sql.SQLOutput;

public class Order {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Candy[] getCandies() {
        return candies;
    }

    public void setCandies(Candy[] candies) {
        this.candies = candies;
    }

    private Client client;
    private Candy[] candies;
    int indexForCandies;

    public Order(int id, Client client, int candiesNumber) {
        this.id = id;
        this.client = client;
        this.candies = new Candy[candiesNumber];
    }

    public void addCandy(Candy candy) {
        if (indexForCandies < this.candies.length) {
            if (this.getTotalPrice() + candy.getDiscountedPrice() <= this.client.getBudget()) {
                this.candies[indexForCandies] = candy;
                ++indexForCandies;
                System.out.println("This Candy was added to the order");
            } else {
                System.out.println("This candy is too expensive!");
            }
        } else {
            System.out.println("No space for this Candy");
        }
    }

    public void removeCandy(Candy candy) {
        for(int i = 0; i < indexForCandies; ++i) {
            if(this.candies[i].equals(candy)) {
                for(int j = i; j < indexForCandies - 1; ++j) {
                    this.candies[j] = this.candies[j + 1];
                }
                this.candies[indexForCandies - 1] = null;
                --indexForCandies;
                System.out.println("The candy was deleted");
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Candy candy : this.candies) {
            if(candy != null) {
                totalPrice += candy.getDiscountedPrice();
            }
        }
        return totalPrice;
    }
}
