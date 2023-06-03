import java.util.Arrays;

public class Shop {

	public static void main(String[] args) {
	
	Customer[] customers = {
			new Adult("Mihai", 26, 120),
			new Adult("Andrei",29,240),
			new Adult("Vlad",24,90),
			new Children("Vasile",12,100),
			new Children("Liana",9,50),
			new Customer("Gigel",18),
	};

	Toy[] toys = {
			new Toy(30,toysType.DOLL),
			new Toy(70,toysType.CAR),
			new Toy(120,toysType.EDUCATIONAL),
			new Toy(150,toysType.CAR),
			new Robot(200, toysType.EDUCATIONAL,50),
			new Domino(90,toysType.EDUCATIONAL,15),
	};
	
	//See if we can buy toys from our shop
	customers[1].buyToys(toys[1]);
	customers[4].buyToys(toys[0]);
	customers[2].buyToys(toys[2]);
	
	//sorting the array
	Arrays.sort(customers);
	
	//printing the sorted array
	for ( int i=0; i < customers.length; i++) {
		System.out.println(customers[i].getName());
	}
	
	//printing only the children from the array
	System.out.println("\nThe children from our array of customers are: ");
	for ( int i=0; i < customers.length; i++) {
		if( customers[i] instanceof Children) {
			System.out.println(customers[i].getName());
		}
	}
	
	
	//check if our enum works how it has to
	System.out.println("\nThe second toy is of type "+toys[2].getType());
	
	Robot robot = (Robot) toys[4];
	robot.consumePower();
	
	Domino domino = (Domino) toys[5];
	domino.countPieces();
	
	System.out.println(toys[0].getType());
	
	}
}
