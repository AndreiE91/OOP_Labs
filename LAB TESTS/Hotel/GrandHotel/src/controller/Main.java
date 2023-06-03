package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import hotel.*;

public class Main {

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		Area area1 = new Area("A1");
		Area area2 = new Area("A2");
		Floor floor1 = new Floor("F1A1", 5);
		Floor floor2 = new Floor("F2A1", 6);
		Floor floor3 = new Floor("F3A1", 5);
		Floor floor4 = new Floor("F1A2", 8);
		Room room1 = new Room("R101", 2);
		Room room2 = new Room("R102", 3);
		Room room3 = new Room("R201", 1);
		Room room4 = new Room("R301", 2);
		Room room5 = new Room("R302", 2);
		Room room6 = new Room("R12", 1);
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(1234321234543L, "Anca", 28, 8, 1996, "R101"));
		persons.add(new Person(1234321230943L, "Adela", 11, 6, 1996, "R101"));
		persons.add(new Person(1234321211543L, "Alexandra", 23, 1, 1996, "R102"));
		persons.add(new Person(1255321234543L, "Dan", 10, 3, 1996, "R201"));
		persons.add(new Person(1234300234543L, "Marius", 28, 2, 1996, "R301"));
		persons.add(new Person(1034321234543L, "Vlad", 21, 6, 1986, "R302"));
		persons.add(new Person(1234320004543L, "Teia", 9, 6, 1986, "R302"));
		persons.add(new Person(1234321234543L, "Ionut", 11, 6, 1996, "R12"));
		hotel.addArea(area1);
		hotel.addArea(area2);
		area1.addFloor(floor1);
		area1.addFloor(floor2);
		area1.addFloor(floor3);
		area2.addFloor(floor4);
		floor1.addRoom(room1);
		floor1.addRoom(room2);
		floor2.addRoom(room3);
		floor3.addRoom(room4);
		floor3.addRoom(room5);
		floor4.addRoom(room6);
		room1.addPerson(persons.get(0));
		room1.addPerson(persons.get(1));
		room2.addPerson(persons.get(2));
		room3.addPerson(persons.get(3));
		room4.addPerson(persons.get(4));
		room5.addPerson(persons.get(5));
		room5.addPerson(persons.get(6));
		room6.addPerson(persons.get(7));

		/*
		 * compute the number of persons in the hotel int nrOfPersonsInHotel=0;
		 * Iterator<Area> ita = hotel.getAreas().iterator(); while
		 * (ita.hasNext()) { Iterator<Floor> itf
		 * =ita.next().getFloors().iterator(); while(itf.hasNext()){
		 * Iterator<Room> itr = itf.next().getRooms().iterator();
		 * while(itr.hasNext()){
		 * nrOfPersonsInHotel+=itr.next().getPersons().size(); } } }
		 */
		// a random number of persons leave for a walk
		int personsToLeave = new Random().nextInt(persons.size() + 1);
		for (int i = 0; i < personsToLeave; i++) {
			persons.get(i).setIn(false);
		}
		// a person of a certain SSN leaves the hotel
		int i = 0;
		while (i < persons.size()) {
			if (persons.get(i).getSSN() == 1255321234543L) {
				Iterator<Area> ita = hotel.getAreas().iterator();
				while (ita.hasNext()) {
					Iterator<Floor> itf = ita.next().getFloors().iterator();
					while (itf.hasNext()) {
						Iterator<Room> itr = itf.next().getRooms().iterator();
						while (itr.hasNext()) {
							Room room = itr.next();
							if (room.getID().equals(persons.get(i).getRoomID())) {
								room.removePerson(persons.get(i));
								persons.get(i).setRoomID("null");
							}

						}
					}
				}
			}
			i++;
		}
		// list all the persons born on the same date and their location
		for (i = 0; i < persons.size(); i++) {
			if ((persons.get(i).getDay() == 11) && (persons.get(i).getMonth() == 6)
					&& (persons.get(i).getYear() == 1996)) {
				Iterator<Area> ita = hotel.getAreas().iterator();
				while (ita.hasNext()) {
					Area area = ita.next();
					Iterator<Floor> itf = area.getFloors().iterator();
					while (itf.hasNext()) {
						Floor floor = itf.next();
						Iterator<Room> itr = floor.getRooms().iterator();
						while (itr.hasNext()) {
							Room room = itr.next();
							if (room.getID().equals(persons.get(i).getRoomID())) {
								System.out.println(persons.get(i).getName() + " " + room.getID() + " " + floor.getID()
										+ " " + area.getID());
							}
						}
					}
				}
			}
		}
		// list all the persons hosted at a given floor and a given room

		Iterator<Area> ita = hotel.getAreas().iterator();
		while (ita.hasNext()) {
			Area area = ita.next();
			Iterator<Floor> itf = area.getFloors().iterator();
			while (itf.hasNext()) {
				Floor floor = itf.next();
				Iterator<Room> itr = floor.getRooms().iterator();
				if (floor.getID().equals("F1A1"))
					while (itr.hasNext()) {
						Room room = itr.next();
						if (room.getID().equals("R101")) {
							room.listPersons();
						}
					}
			}
		}
		System.out.println();
		// list all the persons who went for a walk
		for (i = 0; i < persons.size(); i++) {
			if (persons.get(i).getIn() == false) {
				System.out.print(persons.get(i).getName() + " ");
			}
		}

		// place a person in the first available room
		boolean found = false;
		for (Area area : hotel.getAreas()) {
			for (Floor floor : area.getFloors()) {
				for (Room room : floor.getRooms()) {
					if ((room.getNrOfBeds() > room.getPersons().size()) && (found == false)) {
						room.addPerson(new Person(1973027380912L, "Laura", 10, 3, 1990, room.getID()));
						found = true;

					}
				}
			}
		}

		System.out.println();
		// find a guest indicating the floor and the room
		Person guest = persons.get(7);
		for (Area area : hotel.getAreas()) {
			for (Floor floor : area.getFloors()) {
				for (Room room : floor.getRooms()) {
					if (room.getPersons().contains(guest)) {
						System.out.println(room.getID() + " " + floor.getID());
					}
				}
			}
		}

	}
}