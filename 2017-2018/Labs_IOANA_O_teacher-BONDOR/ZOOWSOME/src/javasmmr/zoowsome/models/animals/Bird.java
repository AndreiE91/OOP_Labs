package javasmmr.zoowsome.models.animals;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Bird extends Animal {

	public Bird(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		// TODO Auto-generated constructor stub
	}

	private boolean migrates;
	private int avgFlightAltitude;
	
	public boolean getMigrates() {
		return migrates;
	}
	
	public void setMigrates(boolean migrates) {
		this.migrates = migrates;
	}
	
	public int getAvgFlightAltitude () {
		return avgFlightAltitude;
	}
	
	public void setAvgFlightAltitude(int avgFlightAltitude) {
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "migrates", String.valueOf(getMigrates()));
		createNode(eventWriter, "avgFlightAltitude", String.valueOf(getAvgFlightAltitude()));
	}
	
	public void decodeFromXml(Element element) {
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("avgFlightAltitude").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("migrates").item(0).getTextContent()));
		}		
	
}
