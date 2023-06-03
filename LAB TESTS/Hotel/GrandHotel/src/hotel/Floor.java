package hotel;

import java.util.HashSet;
import java.util.Set;

public class Floor {

	private String ID;
	private int nrOfRooms;
	private Set<Room> rooms;

	public Floor(String ID, int nrOfRooms) {
		rooms = new HashSet<Room>(30);
		this.ID = ID;
		this.nrOfRooms = nrOfRooms;
	}

	public String getID() {
		return this.ID;

	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public int getNrOfRooms() {
		return this.nrOfRooms;
	}

	public void setNrOfRooms(int nrOfRooms) {
		this.nrOfRooms = nrOfRooms;
	}

	public Set<Room> getRooms() {
		return this.rooms;
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

}
