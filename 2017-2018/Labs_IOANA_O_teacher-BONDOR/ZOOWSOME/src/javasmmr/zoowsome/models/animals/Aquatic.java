package javasmmr.zoowsome.models.animals;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;
public abstract class Aquatic extends Animal {

	

	public Aquatic(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		// TODO Auto-generated constructor stub
	}

	//this is like a class
	public enum WaterType{
		saltWater,
		freshWater;
	}
	
	private WaterType waterType;
	private int avgSwimDept;

	public int getAvgSwimDept() {
		return avgSwimDept;
	}
	
	public void setAvgSwimDept(int avgSwimDept) {
		this.avgSwimDept = avgSwimDept;
	}
	
	public WaterType getWaterType() {
		return waterType;
	}
	
	public void setWaterType(WaterType waterType) {
		this.waterType = waterType;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "avgSwimDept", String.valueOf(getAvgSwimDept()));
		createNode(eventWriter, "waterType", String.valueOf(getWaterType()));
	}
	
	public void decodeFromXml(Element element) {
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("waterType").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("avgSwimDept").item(0).getTextContent()));
		}
	
}
