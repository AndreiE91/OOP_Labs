package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

import javasmmr.zoowsome.services.factories.animals.Constants;
public class Parrot extends Bird {

	public Parrot() {
		super(2,0);
		this.setName("Parrot");
		this.setNrOfLegs(2);
		this.setMigrates(false);
		this.setAvgFlightAltitude(2000);
	}

	@Override
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Birds.Parrot);
		}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	
}
