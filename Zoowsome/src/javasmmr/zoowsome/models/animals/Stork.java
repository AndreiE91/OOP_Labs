package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Stork extends Bird {

	public Stork(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, boolean migrates,
			int avgFlightAltitude, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setMigrates(migrates);
		setAvgFlightAltitude(avgFlightAltitude);
		setTakenCareOf(takenCareOf);
	}

	public Stork() {
		this(1.5, 0.1, 2, "Stork", true, 100, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Bird.STORK);
	}

	public void decodeFromXml(Element element) {

	}

}
