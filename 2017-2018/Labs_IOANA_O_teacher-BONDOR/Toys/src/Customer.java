
public class Customer implements Comparable<Customer> {

	private String name;
	private int age;
	private int budget;
	
	//overloading the constructor of Customer
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Customer(String name, int age, int budget) {
		this.name = name;
		this.age = age;
		this.budget = budget;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getBudget() {
		return budget;
	}

	public void buyToys(Toy toy) {

		if (this.budget > toy.getPrice()) {
			this.budget -= toy.getPrice();
			System.out.println("You have bought a toy which costs " + toy.getPrice());
		} else {
			System.out.println("You don't have enough money to buy this toy. Sorry :(");
		}

	}

	
	//Method for sorting the array
	@Override
	public int compareTo(Customer customer) {
		if ( this.budget > customer.budget)
			return 1;
		else
			if ( this.budget < customer.budget) {
				return -1;
			}
			else {
				return 0;
			}
	}
	
	
	
	
}
