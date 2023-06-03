package javasmmr.zoowsome.models.employees;

import java.math.BigDecimal;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Constants;

public class Caretaker extends Employee implements Caretaker_I {

	private double workingHours;

	public Caretaker(String name, long id, BigDecimal salary, double workingHours) {
		super(name, id, salary);
		setWorkingHours(workingHours);
	}

	public Caretaker() {
		this("Caretaker", generateId(), new BigDecimal(100), 20);

	}

	public static long generateId() {
		long id = (long) (Math.random() * 10000000 * 1000000);
		return id;
	}

	public double getWorkingHours() {
		return this.workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	public String takeCareOf(Animal animal) {

		if (animal.kill()) {
			return Constants.Employees.Caretaker.TCO_KILLED;
		}
		if (this.workingHours < animal.maintenanceCost) {
			return Constants.Employees.Caretaker.TCO_NO_TIME;
		}
		animal.setTakenCareOf(true);
		this.workingHours -= animal.maintenanceCost;
		return Constants.Employees.Caretaker.TCO_SUCCESS;
	}

}
