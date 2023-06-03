package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Cow extends Mammal {

	public Cow(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, float normalBodyTemp,
			float percBodyHair, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setNormalBodyTemp(normalBodyTemp);
		setPercBodyHair(percBodyHair);
		setTakenCareOf(takenCareOf);
	}

	public Cow() {
		this(3.0, 0.05, 4, "Cow", 38, 90, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammal.COW);
	}

	public void decodeFromXml(Element element) {

	}

}
