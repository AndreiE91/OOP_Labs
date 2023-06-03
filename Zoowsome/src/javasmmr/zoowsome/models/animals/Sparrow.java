package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Sparrow extends Bird {

	public Sparrow(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, boolean migrates,
			int avgFlightAltitude, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setMigrates(migrates);
		setAvgFlightAltitude(avgFlightAltitude);
		setTakenCareOf(takenCareOf);
	}

	public Sparrow() {
		this(0.2, 0.0, 2, "Sparrow", false, 50, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Bird.SPARROW);
	}

	public void decodeFromXml(Element element) {

	}

}
