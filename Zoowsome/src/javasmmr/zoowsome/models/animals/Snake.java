package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Snake extends Reptile {

	public Snake(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setLaysEggs(laysEggs);
		setTakenCareOf(takenCareOf);
	}

	public Snake() {
		this(7.0, 1.0, 0, "Snake", true, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptile.SNAKE);
	}

	public void decodeFromXml(Element element) {

	}

}
