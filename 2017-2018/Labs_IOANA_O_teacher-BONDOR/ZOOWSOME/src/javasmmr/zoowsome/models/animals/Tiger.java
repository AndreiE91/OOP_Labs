package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.factories.animals.Constants;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
public class Tiger extends Mammal {

	public Tiger() {
		super(5,0.8);
		this.setName("Tiger");
		this.setNrOfLegs(4);
		this.setNormalBodyTemp(32);
		this.setPercBodyHair(84);
	}

	@Override
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Mammals.Tiger);
		}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	
}
