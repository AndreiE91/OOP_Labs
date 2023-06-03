package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Lizard extends Reptile {

	public Lizard(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setLaysEggs(laysEggs);
		setTakenCareOf(takenCareOf);
	}

	public Lizard() {
		this(4.0, 0.2, 4, "Lizard", true, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptile.LIZARD);
	}

	public void decodeFromXml(Element element) {

	}

}
