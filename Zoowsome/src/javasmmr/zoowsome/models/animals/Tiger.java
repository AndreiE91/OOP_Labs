package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Tiger extends Mammal {

	public Tiger(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, float normalBodyTemp,
			float percBodyHair, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setNormalBodyTemp(normalBodyTemp);
		setPercBodyHair(percBodyHair);
		setTakenCareOf(takenCareOf);
	}

	public Tiger() {
		this(6.5, 1.0, 4, "Tiger", 40, 85, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammal.TIGER);
	}

	public void decodeFromXml(Element element) {

	}

}
