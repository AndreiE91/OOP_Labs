package javasmmr.zoowsome.models.animals;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;
public abstract class Mammal extends Animal{

	public Mammal(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		// TODO Auto-generated constructor stub
	}

	private float normalBodyTemp;
	private float percBodyHair;
	
	public float getNormalBodyTemp () {
		return normalBodyTemp;
	}
	
	public void setNormalBodyTemp(int normalBodyTemp) {
		this.normalBodyTemp = normalBodyTemp;
	}
	
	public float getPercBodyHair () {
		return percBodyHair;
	}
	
	public void setPercBodyHair(int percBodyHair) {
		this.percBodyHair = percBodyHair;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "normalBodyTemp", String.valueOf(getNormalBodyTemp()));
		createNode(eventWriter, "percBodyHair", String.valueOf(getPercBodyHair()));
	}
	
	public void decodeFromXml(Element element) {
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("normalBodyTemp").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("percBodyHair").item(0).getTextContent()));
		}
	
}
