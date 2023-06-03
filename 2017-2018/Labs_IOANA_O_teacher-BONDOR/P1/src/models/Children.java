package models;

public class Children extends Customer {

	public Children(String name, int age, int budget) {
		super(name, age, budget);
	}

	@Override
	public void buyToys(Toy toy) {
		if (this.getAge() < 14) {
			System.out.println("You are too small to buy a toy. Sorry! :(");
		} else
			super.buyToys(toy);

	}

}
