package candies;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Gheorghe", 50);
        Candy candy1 = new Candy("Toffee", 20);
        Candy candy2 = new Candy("Chocolate", 40);
        //candy2.setDiscount(Discount.FIFTY_PERCENT);
        Candy candy3 = new Candy("Kinder", 5);
        Candy candy4 = new Candy("Lion", 6);
        Candy sweetCandy1 = new SweetCandy("Twix", 5, "caramel");
        SweetCandy sweetCandy2 = new SweetCandy("Twix", 5, "caramel");
        SweetCandy sweetCandy3 = (SweetCandy)new Candy("Twix", 5);

        Order order1 = new Order(1, client1, 10);
        order1.addCandy(candy1);
        order1.addCandy(candy2);
        order1.addCandy(candy3);
        order1.addCandy(candy4);
        order1.removeCandy(candy1);
    }
}
