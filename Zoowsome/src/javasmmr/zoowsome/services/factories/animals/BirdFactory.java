package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Constants;
import javasmmr.zoowsome.models.animals.Pigeon;
import javasmmr.zoowsome.models.animals.Sparrow;
import javasmmr.zoowsome.models.animals.Stork;

public class BirdFactory extends SpeciesFactory {

	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Bird.PIGEON.equals(type)) {
			return new Pigeon();
		} else if (Constants.Animals.Bird.STORK.equals(type)) {
			return new Stork();
		} else if (Constants.Animals.Bird.SPARROW.equals(type)) {
			return new Sparrow();
		} else {
			throw new Exception("Invalid animal exception!");
		}
	}

}
