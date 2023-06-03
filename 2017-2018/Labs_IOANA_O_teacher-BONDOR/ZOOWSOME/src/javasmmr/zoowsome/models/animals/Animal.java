package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

public abstract class Animal implements Killer, XML_Parsable {

	private int nrOfLegs;
	private String name;
	public double maintenanceCost;
	public double dangerPerc;
	private boolean takenCareOf = false;

	public Animal(double maintenanceCost, double dangerPerc) {

		this.maintenanceCost = maintenanceCost;
		this.dangerPerc = dangerPerc;

	}

	public int getNrOfLegs() {
		return nrOfLegs;
	}

	public void setNrOfLegs(int nrOfLegs) {
		this.nrOfLegs = nrOfLegs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getTakenCareOf() {
		return takenCareOf;
	}

	public void setTakenCareOf(boolean takenCareOf) {
		this.takenCareOf = takenCareOf;
	}

	public double getDangerPerc() {
		return dangerPerc;
	}

	public double getMaintenanceCost() {
		return maintenanceCost;
	}
	
	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	public void setDangerPerc(double dangerPerc) {
		this.dangerPerc = dangerPerc;
	}

	public boolean kill() {

		double random = Math.random();
		if (random < this.dangerPerc)
			return true;
		else
			return false;

	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		createNode(eventWriter, "nrOfLegs", String.valueOf(this.nrOfLegs));
		createNode(eventWriter, "name", String.valueOf(this.name));
		createNode(eventWriter, "maintenanceCost", String.valueOf(this.maintenanceCost));
		createNode(eventWriter, "dangerPerc", String.valueOf(this.dangerPerc));
		createNode(eventWriter, "takenCareOf", String.valueOf(this.takenCareOf));
	}

	public void decodeFromXml(Element element) {
		setNrOfLegs(Integer.valueOf(element.getElementsByTagName("nrOfLegs").item(0).getTextContent()));
		setName(element.getElementsByTagName("name").item(0).getTextContent());
		setMaintenanceCost(Double.valueOf(element.getElementsByTagName("maintenanceCost").item(0).getTextContent()));
		setDangerPerc(Double.valueOf(element.getElementsByTagName("dangerPerc").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("takenCareOf").item(0).getTextContent()));
		}
	
}
