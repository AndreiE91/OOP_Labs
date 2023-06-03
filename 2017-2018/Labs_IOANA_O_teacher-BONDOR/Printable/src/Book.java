
public class Book implements Printable, Comparable<Book>{

	private String name;
	private int price;
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void print() {
		System.out.println("this is a book");
		
	}

	@Override
	public int compareTo(Book book) {
		// TODO Auto-generated method stub
		//ascending >1<-1
		//descending <1>-1
		if( this.price < book.price)
			return 1;
		else
			if( this.price > book.price)
				return -1;
			else
				return 0;
	}

}
