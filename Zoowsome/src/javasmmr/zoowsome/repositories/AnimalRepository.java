package javasmmr.zoowsome.repositories;

import org.w3c.dom.Element;

import javasmmr.zoowsome.models.animals.*;

public class AnimalRepository extends EntityRepository<Animal> {

	private static final String XML_FILENAME = "Animals.xml";

	public AnimalRepository() {
		super(XML_FILENAME, Constants.XML_TAGS.ANIMAL);

	}

	protected Animal getEntityFromXmlElement(Element element) {
		String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
		switch (discriminant) {
		case Constants.Animals.Insect.BUTTERFLY:
			Animal butterfly = new Butterfly();
			butterfly.decodeFromXml(element);
			return butterfly;
		case Constants.Animals.Insect.COCKROACH:
			Animal cockroach = new Cockroach();
			cockroach.decodeFromXml(element);
			return cockroach;
		case Constants.Animals.Insect.SPIDER:
			Animal spider = new Spider();
			spider.decodeFromXml(element);
			return spider;
		case Constants.Animals.Aquatic.DOLPHIN:
			Animal dolphin = new Dolphin();
			dolphin.decodeFromXml(element);
			return dolphin;
		case Constants.Animals.Aquatic.FISH:
			Animal fish = new Fish();
			fish.decodeFromXml(element);
			return fish;
		case Constants.Animals.Aquatic.SHARK:
			Animal shark = new Shark();
			shark.decodeFromXml(element);
			return shark;
		case Constants.Animals.Bird.PIGEON:
			Animal pigeon = new Pigeon();
			pigeon.decodeFromXml(element);
			return pigeon;
		case Constants.Animals.Bird.SPARROW:
			Animal sparrow = new Sparrow();
			sparrow.decodeFromXml(element);
			return sparrow;
		case Constants.Animals.Bird.STORK:
			Animal stork = new Stork();
			stork.decodeFromXml(element);
			return stork;
		case Constants.Animals.Mammal.COW:
			Animal cow = new Cow();
			cow.decodeFromXml(element);
			return cow;
		case Constants.Animals.Mammal.MONKEY:
			Animal monkey = new Monkey();
			monkey.decodeFromXml(element);
			return monkey;
		case Constants.Animals.Mammal.TIGER:
			Animal tiger = new Tiger();
			tiger.decodeFromXml(element);
			return tiger;
		case Constants.Animals.Reptile.CROCODILE:
			Animal crocodile = new Crocodile();
			crocodile.decodeFromXml(element);
			return crocodile;
		case Constants.Animals.Reptile.LIZARD:
			Animal lizard = new Lizard();
			lizard.decodeFromXml(element);
			return lizard;
		case Constants.Animals.Reptile.SNAKE:
			Animal snake = new Snake();
			snake.decodeFromXml(element);
			return snake;
		default:
			break;

		}
		return null;
	}

}
