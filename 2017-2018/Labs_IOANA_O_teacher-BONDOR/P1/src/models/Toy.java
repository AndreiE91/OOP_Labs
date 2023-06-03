package models;

import controllers.Constants;
import controllers.GUID;

public class Toy {

	private int price;
	private String type;
	private String guid;

	public Toy() {

	}

	public Toy(int price, String type) {
		this.price = price;
		this.type = type;
		this.guid = GUID.generateGUID();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return guid;
	}

	public void getDetails() {

		if (this.type.equals(Constants.Toy.CAR)) {
			System.out.println(this.guid);
		} else if (this.type.equals(Constants.Toy.DOLL)) {
			System.out.println("This is a doll");
		} else
			System.out.println(this.price);

	}

}
