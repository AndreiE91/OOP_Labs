package hotel;

import java.util.HashSet;
import java.util.Set;

public class Area {

	private String ID;
	private Set<Floor> floors;

	public Area(String ID) {
		floors = new HashSet<Floor>(50);
		this.ID = ID;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public Set<Floor> getFloors() {
		return this.floors;
	}

	public void addFloor(Floor floor) {
		floors.add(floor);
	}

}
