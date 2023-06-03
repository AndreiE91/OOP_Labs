
public class Station {

	// final is mandatory because this is a constant
	public final int SLOTS = 5;
	public Bike[] bikes = new Bike[SLOTS]; // array of 5 bikes
	private int emptySlotIndex = 0;

	public boolean addBike(Bike bike) {
		if (emptySlotIndex != SLOTS) {
			bikes[emptySlotIndex] = bike;
			emptySlotIndex++;
			return true;
		} else {
			return false;
		}
	}

	// @isFound will become true only if the bike we are looking for is in the
	// station
	// @index helps us to search in the loop
	// @emptySlotIndex represents the number of bikes from the station
	public void removeBike(Bike bike) {

		boolean isFound = false;
		int index = 0;
		while (index < emptySlotIndex) {
			if (bikes[index].equals(bike)) {
				bikes[index] = bikes[index + 1];
				System.out.println("The Bike" + bike.id + " has been removed from the station");
				emptySlotIndex--;
				isFound = true;
			}
			index++;
		}

		if (isFound == false) {
			System.out.println("The Bike" + bike.id + " could not be found in the station");
		}
	}

	
	//remove all the bikes from the station
	public void removeAllBikes() {

		int index = 0;

		while (index < emptySlotIndex) {
			bikes[index] = bikes[index + 1];
			emptySlotIndex--;
		}
		System.out.println("The station is empty");

	}

}
