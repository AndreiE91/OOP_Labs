package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.factories.animals.Constants;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
public class Cockroach extends Insect {

	public Cockroach() {
		super(0.1,0);
		this.setName("Cockroach");
		this.setNrOfLegs(6);
		this.setIsDangerous(true);
		this.setCanFly(true);
	}

	@Override

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Insects.Cockroach);
		}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	
}
