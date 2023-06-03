package lab11;

public class Person {
	String name;
	int age;
	int id;

	// Getters and Setters
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Constructors
	public Person(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

}
