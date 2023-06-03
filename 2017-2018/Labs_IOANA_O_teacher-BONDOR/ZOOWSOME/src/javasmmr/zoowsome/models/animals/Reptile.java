package javasmmr.zoowsome.models.animals;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;
public abstract class Reptile extends Animal {

	public Reptile(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		// TODO Auto-generated constructor stub
	}

	private boolean layEggs;
	
	public boolean getLayEggs () {
		return layEggs;
	}
	
	public void setLayEggs(boolean layEggs) {
		this.layEggs = layEggs;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "layEggs", String.valueOf(getLayEggs()));
	}
	
	public void decodeFromXml(Element element) {
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("layEggs").item(0).getTextContent()));
		}
	
}
