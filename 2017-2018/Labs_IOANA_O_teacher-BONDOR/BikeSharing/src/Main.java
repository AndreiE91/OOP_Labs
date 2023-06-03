
public class Main {

	public static void main(String[] args) {

		//create 7 bikes 
		Bike bike0 = new Bike(0);
		Bike bike1 = new Bike(1);
		Bike bike2 = new Bike(2);
		Bike bike3 = new Bike(3);
		Bike bike4 = new Bike(4);
		Bike bike5 = new Bike(5);
		Bike bike6 = new Bike(6);

		//create the station
		Station station = new Station();

		//add bikes to the station and check if it worked
		boolean test0 = station.addBike(bike0);
		System.out.println(test0);

		boolean test1 = station.addBike(bike1);
		System.out.println(test1);

		station.addBike(bike2);

		station.addBike(bike3);

		//remove bikes from the station and check if it worked
		station.removeBike(bike3);
		station.removeBike(bike2);
		station.removeBike(bike4);

		//add/remove again bikes to see if they will be put on the empty slots from the station
		//check if it worked
		station.addBike(bike4);

		boolean test5 = station.addBike(bike5);
		System.out.println(test5);

		boolean test6 = station.addBike(bike6);
		System.out.println(test6);

		Bike bike7 = new Bike(7);
		boolean test7 = station.addBike(bike7);
		System.out.println(test7);

		station.removeBike(bike4);

		boolean test8 = station.addBike(bike7);
		System.out.println(test8);

		//remove all bikes from the station
		station.removeAllBikes();

		//add new bikes
		Bike bike8 = new Bike(8);

		Bike bike9 = new Bike(9);

		Bike bike10 = new Bike(10);

		Bike bike11 = new Bike(11);

		Bike bike12 = new Bike(12);

		Bike bike13 = new Bike(13);

		boolean test9 = station.addBike(bike8);
		System.out.println(test9);

		boolean test10 = station.addBike(bike9);
		System.out.println(test10);

		boolean test11 = station.addBike(bike10);
		System.out.println(test11);

		boolean test12 = station.addBike(bike11);
		System.out.println(test12);

		boolean test13 = station.addBike(bike12);
		System.out.println(test13);

		boolean test14 = station.addBike(bike13);
		System.out.println(test14);

	}

}
