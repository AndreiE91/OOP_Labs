package shipbay;

import java.util.ArrayList;
import java.util.List;

import utils.Constants;
import utils.GuidGenerator;

public class Compartment {

	private final String UUID;

	public enum Type {
		passanger, cargo
	}

	private Type type;
	List<Carriable> carriables;
	private int profit;

	public Compartment(Type type) {

		carriables = new ArrayList<Carriable>();
		UUID = GuidGenerator.generate();
		this.type = type;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Carriable> getCarriables() {
		return this.carriables;
	}

	public String getUUID() {
		return this.UUID;
	}

	public void addPassanger(Passanger passanger) {
		if ((this.type == Type.passanger) && (carriables.size() < Constants.MAX_NUMBER_OF_PASSANGERS)) {
			carriables.add(passanger);
		} else {
			System.out.println("You cannot add a passanger");
		}
	}

	public void addCargoItem(CargoItem cargoItem) {
		if (this.type == Type.cargo) {
			carriables.add(cargoItem);
		} else {
			System.out.println("You cannot add a cargo item");
		}
	}

	public int getProfit() {
		if (this.type == Type.passanger) {
			this.profit = Constants.TICKET_PRICE * carriables.size();
		}
		if (this.type == Type.cargo) {
			CargoItem cargoItem = new CargoItem("cargo1");
			this.profit = cargoItem.getProfit() * carriables.size();
		}
		return this.profit;
	}

}
