
public class Main {

	public static void main(String[] args) {
		
		RangedCreep rangedCreep1 = new RangedCreep();
		MeleeCreep meleeCreep1 = new MeleeCreep();

		//other way of doing an object
		Creep melleCreep2 = new MeleeCreep();
		Creep rangedCreep2 = new RangedCreep();
		
		System.out.println(rangedCreep2 instanceof RangedCreep);
		System.out.println(melleCreep2 instanceof Creep);
		
		rangedCreep2.attack();
		melleCreep2.attack();
		
		
	}

}
