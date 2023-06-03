
public class RangedCreep extends Creep {
	
	public RangedCreep() {
		super(20);
		System.out.println("This is a RangedCreep");
	}
	
	public void attack() {
		
		System.out.println("well rangedCreep is attacking , watch out");
		//to get the method from the super class
		super.attack();
	}
	
}	