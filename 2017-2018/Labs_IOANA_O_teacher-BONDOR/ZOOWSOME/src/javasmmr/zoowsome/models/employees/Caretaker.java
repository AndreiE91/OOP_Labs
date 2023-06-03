package javasmmr.zoowsome.models.employees;

import java.math.BigDecimal;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import static javasmmr.zoowsome.repositories.EmployeeRepository.createNode;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.services.factories.animals.Constants;

public class Caretaker extends Employee implements Caretaker_I {

	private double workingHours;

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public Caretaker() {
		
	}
	
	public Caretaker(String name, long id, BigDecimal salary, boolean isDead) {
		super(name, id, salary, isDead);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String takeCareOf(Animal animal) {

		if (animal.kill()) {
			return Constants.Employees.Caretakers.TCO_KILLED;
		}

		if (this.workingHours < animal.getMaintenanceCost()) {
			return Constants.Employees.Caretakers.TCO_NO_TIME;
		}
		
		animal.setTakenCareOf(true);
		this.workingHours-=animal.getMaintenanceCost();
		
		return Constants.Employees.Caretakers.TCO_SUCCESS;
		
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "workingHours", String.valueOf(this.workingHours));
		createNode(eventWriter,Constants.XML_TAGS.DISCRIMINANT,Constants.Employee.Caretaker);
		}
	
	public void decodeFromXml(Element element) {
		setWorkingHours(Double.valueOf(element.getElementsByTagName("workingHours").item(0).getTextContent()));
	}
	
}
