package hotel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Room {

	private String ID;
	private int nrOfBeds;
	private Set<Person> persons;

	public Room(String ID, int nrOfBeds) {
		persons = new HashSet<Person>(6);
		this.ID = ID;
		this.nrOfBeds = nrOfBeds;

	}

	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public int getNrOfBeds() {
		return this.nrOfBeds;
	}

	public void setNrOfBeds(int nrOfBeds) {
		this.nrOfBeds = nrOfBeds;
	}

	public Set<Person> getPersons() {
		return this.persons;
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public void removePerson(Person person) {
		persons.remove(person);
	}

	public void listPersons() {

		Iterator<Person> it = persons.iterator();
		while (it.hasNext()) {
			System.out.print(it.next().getName() + " ");
		}
	}

}
