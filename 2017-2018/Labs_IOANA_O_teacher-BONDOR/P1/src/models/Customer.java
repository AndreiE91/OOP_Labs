package models;

public class Customer implements Comparable<Customer> {

	private String name;
	private int age;
	private int budget;
	
	public Customer(String name, int age, int budget) {
		this.name = name;
		this.age = age;
		this.budget = budget;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void buyToys(Toy toy) {
		
		if ( this.budget > toy.getPrice() ) {
			
			this.budget-=toy.getPrice();
			System.out.println("I bought a toy which costs "+toy.getPrice());
		}
		else
			System.out.println("I can not buy this toy which costs "+toy.getPrice());
	}
	
	@Override
	public int compareTo(Customer customer) {
		if( this.budget > customer.budget)
			return 1;
		else
			if( this.budget < customer.budget)
				return -1;
			else
				return 0;
	}

}
