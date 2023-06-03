import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Book[] books = {
				new Book("A",120),
				new Book("B",150),
				new Book("C",826),
				new Book("D",105),
				new Book("E",45),
				new Book("F",320),
				new Book("G",12),
				new Book("H",19)
		};
		
		Ticket ticket1 = new Ticket("Bus",4);
		ticket1.print();
		
		Arrays.sort(books);
	
		for( int i=0; i < books.length; i++) {
			System.out.println(books[i].getName());
		}
		
		

	}

}
