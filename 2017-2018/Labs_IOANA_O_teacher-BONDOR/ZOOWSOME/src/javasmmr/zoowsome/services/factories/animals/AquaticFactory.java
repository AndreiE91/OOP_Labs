package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Dolphin;
import javasmmr.zoowsome.models.animals.Penguin;
import javasmmr.zoowsome.models.animals.Whale;


public class AquaticFactory extends SpeciesFactory {

	public Animal getAnimal(String type) { 
		
		if (Constants.Animals.Aquatics.Dolphin.equals(type)) { 
			return new Dolphin();
		}
		
		else if (Constants.Animals.Aquatics.Whale.equals(type)) { 
			return new Whale(); 
		} 
		
		else if (Constants.Animals.Aquatics.Penguin.equals(type)) { 
			return new Penguin(); 
		}
	
		else{ 
			throw new RuntimeException("Invalid animal exception!"); 
		} 
	}
}