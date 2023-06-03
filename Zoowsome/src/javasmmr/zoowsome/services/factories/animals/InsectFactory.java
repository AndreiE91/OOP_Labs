package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Butterfly;
import javasmmr.zoowsome.models.animals.Cockroach;
import javasmmr.zoowsome.models.animals.Constants;
import javasmmr.zoowsome.models.animals.Spider;

public class InsectFactory extends SpeciesFactory {

	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Insect.BUTTERFLY.equals(type)) {
			return new Butterfly();
		} else if (Constants.Animals.Insect.COCKROACH.equals(type)) {
			return new Cockroach();
		} else if (Constants.Animals.Insect.SPIDER.equals(type)) {
			return new Spider();
		} else {
			throw new Exception("Invalid animal exception!");
		}
	}

}
