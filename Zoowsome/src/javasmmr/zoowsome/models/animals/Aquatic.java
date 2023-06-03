package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Aquatic extends Animal {

	private int avgSwimDepth;

	public enum WaterType {
		saltwater, freshwater
	};

	private WaterType typeOfWater;

	public Aquatic(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
	}

	public int getAvgSwimDepth() {
		return this.avgSwimDepth;
	}

	public void setAvgSwimDepth(int avgSwimDepth) {
		this.avgSwimDepth = avgSwimDepth;
	}

	public WaterType getTypeOfWater() {
		return this.typeOfWater;
	}

	public void setTypeOfWater(WaterType typeOfWater) {
		this.typeOfWater = typeOfWater;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "avgSwimDepth", String.valueOf(getAvgSwimDepth()));
		createNode(eventWriter, "typeOfWater", String.valueOf(getTypeOfWater()));
	}

	public void decodeFromXml(Element element) {
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("avgSwimDepth").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("typeOfWater").item(0).getTextContent()));
	}

}
