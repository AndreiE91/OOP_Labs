package javasmmr.zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.factories.animals.Constants;

public class Whale extends Aquatic{

	public Whale() {
		super(2.4,0.3);
		this.setName("Whale");
		this.setNrOfLegs(0);
		this.setWaterType(WaterType.saltWater);
		this.setAvgSwimDept(2000);
	}

	@Override
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Aquatics.Whale);
		}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	
}
