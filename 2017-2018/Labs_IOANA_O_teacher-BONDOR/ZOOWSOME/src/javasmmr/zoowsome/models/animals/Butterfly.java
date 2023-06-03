package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.factories.animals.Constants;

public class Butterfly extends Insect {

	public Butterfly() {
		super(1,0);
		this.setName("Butterfly");
		this.setNrOfLegs(6);
		this.setIsDangerous(false);
		this.setCanFly(true);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Insects.Butterfly);
		}


	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	
}
