package models;

public class Robot extends Toy implements ElectronicToy {

	private int power;

	public Robot(int price, String type, int power) {
		super(price, type);
		this.power = power;
		// TODO Auto-generated constructor stub
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	@Override
	public void consumePower() {

		if (this.power < 20) {
			System.out.println("This toy is running out of power");
		} else {
			System.out.println("This toy has enough power");
		}
	}

}
