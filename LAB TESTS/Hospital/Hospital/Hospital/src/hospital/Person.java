package hospital;

import java.util.InputMismatchException;

public class Person {

	private int ID;
	private String name;
	public static final int ID_LENGTH = 7;
	public static final int ID_NAME_LENGTH = 6;

	public Person(int ID, String name) throws InputMismatchException {

		if (name.length() < ID_NAME_LENGTH) {
			throw new InputMismatchException("The name is too short");
		}
		if ((ID < Math.pow(10, ID_LENGTH-1)) || (ID > Math.pow(10, ID_LENGTH))) {
			throw new InputMismatchException("The ID is too short");
		}
		this.ID = ID;
		this.name = name;
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
