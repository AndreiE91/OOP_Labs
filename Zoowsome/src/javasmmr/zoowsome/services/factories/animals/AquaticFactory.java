package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Constants;
import javasmmr.zoowsome.models.animals.Dolphin;
import javasmmr.zoowsome.models.animals.Fish;
import javasmmr.zoowsome.models.animals.Shark;

public class AquaticFactory extends SpeciesFactory {

	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Aquatic.FISH.equals(type)) {
			return new Fish();
		} else if (Constants.Animals.Aquatic.SHARK.equals(type)) {
			return new Shark();
		} else if (Constants.Animals.Aquatic.DOLPHIN.equals(type)) {
			return new Dolphin();
		} else {
			throw new Exception("Invalid animal exception");
		}
	}
}
