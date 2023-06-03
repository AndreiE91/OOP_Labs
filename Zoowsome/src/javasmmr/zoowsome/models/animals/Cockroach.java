package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Cockroach extends Insect {

	public Cockroach(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, boolean canFly,
			boolean isDangerous, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setCanFly(canFly);
		setIsDangerous(isDangerous);
		setTakenCareOf(takenCareOf);
	}

	public Cockroach() {
		this(0.1, 0.05, 6, "Cockroach", false, false, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insect.COCKROACH);
	}

	public void decodeFromXml(Element element) {

	}

}
