package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Spider extends Insect {
	public Spider(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, boolean canFly,
			boolean isDangerous, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setCanFly(canFly);
		setIsDangerous(isDangerous);
		setTakenCareOf(takenCareOf);
	}

	public Spider() {
		this(0.4, 0.5, 8, "Spider", false, true, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insect.SPIDER);
	}

	public void decodeFromXml(Element element) {

	}

}
