package shipbay;

import java.util.HashSet;
import java.util.Set;

public class ShipBay {

	private Set<Ship> ships;

	public ShipBay() {
		ships = new HashSet<Ship>();
	}

	public Set<Ship> getShips() {
		return this.ships;
	}

	public void receiveShip(Ship ship) {
		ships.add(ship);
	}

	public void departShip(Ship ship) {
		ships.remove(ship);
	}

	public boolean check(Ship ship) {
		if (ships.contains(ship)) {
			return true;
		} else {
			return false;
		}
	}

}
