package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Dolphin extends Aquatic {

	public Dolphin(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, int avgSwimDepth,
			WaterType typeOfWater, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setAvgSwimDepth(avgSwimDepth);
		setTypeOfWater(typeOfWater);
		setTakenCareOf(takenCareOf);
	}

	public Dolphin() {

		this(7.5, 0.1, 0, "Dolphin", 100, WaterType.freshwater, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatic.DOLPHIN);
	}

	public void decodeFromXml(Element element) {

	}

}
