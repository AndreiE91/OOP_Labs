package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.factories.animals.Constants;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
public class Spider extends Insect {

	public Spider() {
		super(0.1,0.1);
		this.setName("Spider");
		this.setNrOfLegs(8);
		this.setIsDangerous(true);
		this.setCanFly(false);
	}

	@Override

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Insects.Spider);
		}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	
}
