public class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        Book that = (Book) obj;
        return(this.name.equals(that.name) && this.price == that.price);
    }
}
