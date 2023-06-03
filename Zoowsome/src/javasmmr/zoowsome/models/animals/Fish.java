package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public class Fish extends Aquatic {

	public Fish(double maintenanceCost, double dangerPerc, int nrOfLegs, String name, int avgSwimDepth,
			WaterType typeOfWater, boolean takenCareOf) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setAvgSwimDepth(avgSwimDepth);
		setTypeOfWater(typeOfWater);
		setTakenCareOf(takenCareOf);
	}

	public Fish() {

		this(0.1, 0.0, 0, "Fish", 100, WaterType.freshwater, false);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatic.FISH);
	}

	public void decodeFromXml(Element element) {

	}

}
