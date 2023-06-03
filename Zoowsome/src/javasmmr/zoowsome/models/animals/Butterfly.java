package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Butterfly extends Insect {
	public Butterfly(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, boolean canFly,
			boolean isDangerous, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setCanFly(canFly);
		setIsDangerous(isDangerous);
		setTakenCareOf(takenCareOf);
	}

	public Butterfly() {
		this(0.1, 0.0, 6, "Butterfly", true, false, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insect.BUTTERFLY);
	}

	public void decodeFromXml(Element element) {

	}

}
