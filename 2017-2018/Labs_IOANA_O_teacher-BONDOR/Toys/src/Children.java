
public class Children extends Customer {

	public Children(String name, int age, int budget) {
		super(name, age, budget);
	}
	
	public void buyToys(Toy toy) {
		if ( this.getAge() < 14 ) {
			System.out.println("You are too small to buy a toy. I am sorry :(");
		}
		else {
			super.buyToys(toy);
		}
	}

}
