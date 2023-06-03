package candies;

public class Candy {
    private String name;
    private double price;

    private Discount discount;

    /*
    public Candy() {

    }
    */

    public Candy(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getDiscountedPrice() {
        if (this.discount != null) {
            if (this.discount.equals(Discount.CHRISTMAS)) {
                return this.price * 0.75;
            } else if (this.discount.equals(Discount.EASTER)) {
                return this.price * 0.8;
            } else {
                return this.price * 0.5;
            }
        }
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Discount getDiscount() {
        return this.discount;
    }

    @Override
    public boolean equals(Object o) {
        Candy that = (Candy) o;
        return this.name.equals(that.name) && this.price == that.price;
    }
}
