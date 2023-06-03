public class ComparisonsOnObjects {
    public static void main(String[] args) {
        Book book1 = new Book("Pepsi", 4);
        Book book2 = new Book("Pepsi", 4);
        Book book3 = book1;

        if(book1.equals(book2))
        {
            System.out.println("Da bă, book1 îi egal cu book2");
        }
        else
        {
            System.out.println("Book1 nu îi egal cu book2");
        }
        if(book1 == book2)
        {
            System.out.println("Da bă, book1 îi egal cu book2");
        }
        else
        {
            System.out.println("Book1 nu îi egal cu book2");
        }
        if(book1.equals(book3))
        {
            System.out.println("Da bă, book1 îi egal cu book3");
        }
        else
        {
            System.out.println("Book1 nu îi egal cu book3");
        }
        if(book1 == book3)
        {
            System.out.println("Da bă, book1 îi egal cu book3");
        }
        else
        {
            System.out.println("Book1 nu îi egal cu book3");
        }
    }
}
