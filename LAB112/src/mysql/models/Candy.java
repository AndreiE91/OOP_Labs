package mysql.models;

public class Candy {
    //step 4
    //adaugam o proprietate pt id
    private int id;
    private String name;
    private double price;

    public Candy(String name, double price, int id) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Candy() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}' + '\n';
    }
}
