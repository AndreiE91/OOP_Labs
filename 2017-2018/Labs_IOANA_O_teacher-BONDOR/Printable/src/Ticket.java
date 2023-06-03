
public class Ticket implements Printable{

	private String name;
	private int price;
	
	public Ticket(String name, int price) {
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
		System.out.println("this is a ticket");
		
	}
	

}
