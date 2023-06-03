
public class Bike {

	public String color;
	public int id;
	private boolean available;

	// asta e accesibil doar pe clasa
	// public static int test;

	public Bike(int id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return this.available;
	}

}
