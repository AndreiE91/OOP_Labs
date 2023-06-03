package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.factories.animals.Constants;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
public class Crocodile extends Reptile {

	public Crocodile() {
		super(4,0.8);
		this.setName("Crocodile");
		this.setNrOfLegs(4);
		this.setLayEggs(true);
	}

	@Override
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Reptiles.Crocodile);
	}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	
}
