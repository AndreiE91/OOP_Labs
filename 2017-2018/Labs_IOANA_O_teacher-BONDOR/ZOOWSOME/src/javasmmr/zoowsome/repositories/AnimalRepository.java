package javasmmr.zoowsome.repositories;

import org.w3c.dom.Element;

import javasmmr.zoowsome.models.animals.*;
import javasmmr.zoowsome.services.factories.animals.Constants;

public class AnimalRepository extends EntityRepository<Animal> {
	private static final String XML_FILENAME = "Animals.xml";

	public AnimalRepository() {
		super(XML_FILENAME, Constants.XML_TAGS.ANIMAL);
	}

	protected Animal getEntityFromXmlElement(Element element) {
		String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
		switch (discriminant) {
		
		case Constants.Animals.Insects.Butterfly:
			Animal butterfly = new Butterfly();
			butterfly.decodeFromXml(element);
			return butterfly;
			
		case Constants.Animals.Insects.Spider:
			Animal spider = new Spider();
			spider.decodeFromXml(element);
			return spider;

		case Constants.Animals.Insects.Cockroach:
			Animal cockroach = new Cockroach();
			cockroach.decodeFromXml(element);
			return cockroach;

		// MAMMALS
		case Constants.Animals.Mammals.Monkey:
			Animal monkey = new Butterfly();
			monkey.decodeFromXml(element);
			return monkey;

		case Constants.Animals.Mammals.Tiger:
			Animal tiger = new Tiger();
			tiger.decodeFromXml(element);
			return tiger;

		case Constants.Animals.Mammals.Cow:
			Animal cow = new Cow();
			cow.decodeFromXml(element);
			return cow;

		// BIRDS
		case Constants.Animals.Birds.Parrot:
			Animal parrot = new Parrot();
			parrot.decodeFromXml(element);
			return parrot;

		case Constants.Animals.Birds.Eagle:
			Animal eagle = new Eagle();
			eagle.decodeFromXml(element);
			return eagle;

		case Constants.Animals.Birds.Swan:
			Animal swan = new Swan();
			swan.decodeFromXml(element);
			return swan;

		// REPTILES
		case Constants.Animals.Reptiles.Snake:
			Animal snake = new Snake();
			snake.decodeFromXml(element);
			return snake;
					
		case Constants.Animals.Reptiles.Crocodile:
			Animal crocodile = new Crocodile();
			crocodile.decodeFromXml(element);
			return crocodile;

		case Constants.Animals.Reptiles.Turtle:
			Animal turtle = new Turtle();
			turtle.decodeFromXml(element);
			return turtle;

		// AQUATICS
		case Constants.Animals.Aquatics.Penguin:
			Animal penguin = new Penguin();
			penguin.decodeFromXml(element);
			return penguin;

		case Constants.Animals.Aquatics.Dolphin:
			Animal dolphin = new Dolphin();
			dolphin.decodeFromXml(element);
			return dolphin;

		case Constants.Animals.Aquatics.Whale:
			Animal whale = new Whale();
			whale.decodeFromXml(element);
			return whale;
			
		default:
			break;
		}
		return null;
	}
}