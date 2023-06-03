package shipbay;

import java.util.LinkedHashSet;
import java.util.Set;

import shipbay.Compartment.Type;

public class Ship {

	private String name;
	private Type typeOfCopartments;
	private int profit;
	private Set<Compartment> compartments;

	public Ship(String name, Type typeOfCompartments) {
		compartments = new LinkedHashSet<Compartment>();
		this.name = name;
		this.typeOfCopartments = typeOfCompartments;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getTypeOfCompartments() {
		return this.typeOfCopartments;
	}

	public void setTypeOfCompartments(Type typeOfCompartments) {
		this.typeOfCopartments = typeOfCompartments;
	}

	public Set<Compartment> getCompartments() {
		return this.compartments;
	}

	public void addCompartment(Compartment compartment) {
		if (((this.typeOfCopartments == Type.passanger) && (compartment.getType() == Type.cargo))
				|| ((this.typeOfCopartments == Type.cargo) && (compartment.getType() == Type.passanger))) {

			System.out.println("You cannot add this type of compartment");
		} else {
			compartments.add(compartment);
		}
	}

	public void removeCompartment(Compartment compartment) {
		compartments.remove(compartment);
	}

	public int getProfit() {
		int profit = 0;
		for (Compartment compartment : compartments) {
			profit += compartment.getProfit();
		}
		this.profit = profit;
		return this.profit;
	}

	public String toString() {
		return String.format(getName() + " " + compartments.size() + " " + getProfit());

	}

}
