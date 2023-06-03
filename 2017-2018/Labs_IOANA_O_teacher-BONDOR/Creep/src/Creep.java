
public class Creep extends Unit{

	private int damage;
	
	public Creep() {
		System.out.println("This is a creep");
	}
	
	public Creep(int damage) {
		this.damage = damage;
		System.out.println("This is the other constructor with arguments");
	}
	
	public int getDamage() {
		return damage; 
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void attack() {
		System.out.println("just attack that thing");
	}
	
}

