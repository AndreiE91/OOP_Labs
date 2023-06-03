package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shipbay.*;
import shipbay.Compartment.Type;

public class Main {

	public static void main(String[] args) {

		ShipBay shipbay = new ShipBay();
		Ship ship1 = new Ship("Ship1", Type.passanger);
		Ship ship2 = new Ship("Ship2", Type.cargo);
		Compartment compartment11 = new Compartment(Type.passanger);
		Compartment compartment12 = new Compartment(Type.passanger);
		Compartment compartment13 = new Compartment(Type.passanger);
		Compartment compartment21 = new Compartment(Type.cargo);
		Passanger passanger1 = new Passanger("Ale");
		Passanger passanger2 = new Passanger("Adela");
		Passanger passanger3 = new Passanger("Anca");
		Passanger passanger4 = new Passanger("Dan");
		Passanger passanger5 = new Passanger("Marius");
		Passanger passanger6 = new Passanger("Vlad");
		Passanger passanger7 = new Passanger("Ionut");
		CargoItem cargo1 = new CargoItem("item1");
		CargoItem cargo2 = new CargoItem("item2");

		shipbay.receiveShip(ship1);
		shipbay.receiveShip(ship2);
		ship1.addCompartment(compartment11);
		ship1.addCompartment(compartment12);
		ship1.addCompartment(compartment13);
		ship2.addCompartment(compartment21);
		compartment11.addPassanger(passanger1);
		compartment11.addPassanger(passanger2);
		compartment11.addPassanger(passanger3);
		compartment12.addPassanger(passanger4);
		compartment12.addPassanger(passanger5);
		compartment13.addPassanger(passanger6);
		compartment13.addPassanger(passanger7);
		compartment21.addCargoItem(cargo1);
		compartment21.addCargoItem(cargo2);

		for (Ship ship : shipbay.getShips()) {
			System.out.println(ship.toString());
		}

		List<Ship> sortedShips = new ArrayList<Ship>(shipbay.getShips());
		

	}

}
