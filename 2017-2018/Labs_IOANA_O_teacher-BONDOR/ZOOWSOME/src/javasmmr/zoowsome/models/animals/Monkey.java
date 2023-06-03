package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.factories.animals.Constants;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
public class Monkey extends Mammal {

	public Monkey() {
		super(2,0.2);
		this.setName("Monkey");
		this.setNrOfLegs(4);
		this.setNormalBodyTemp(30);
		this.setPercBodyHair(56);
	}

	@Override
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Mammals.Monkey);
		}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	
}