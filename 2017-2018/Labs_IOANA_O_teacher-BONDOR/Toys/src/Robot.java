
public class Robot extends Toy implements IElectronicToy {

	private int power;
	
	public Robot(int price, toysType type,int power) {
		super(price, type);
		this.power = power;
		// TODO Auto-generated constructor stub
	}
	
	private void setPower(int power) {
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}
	
	@Override
	public void consumePower() {
		if( this.power < 25 ) {
			System.out.println("You are running out of power");
		}
		else {
			System.out.println("You have enough power");
		}
	}
	
	

}
