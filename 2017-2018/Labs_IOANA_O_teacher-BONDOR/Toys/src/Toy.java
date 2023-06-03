
public class Toy {

	private int price;
	private toysType type;
	
	public Toy(int price, toysType type) {
		this.price = price;
		this.type = type;
	}
	
	public void setPrice( int price ) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	
	public toysType getType() {
		return type;
	}
	
	public void setType(toysType type) {
		this.type = type;
	}
	
	
}
