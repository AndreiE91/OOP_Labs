package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Eagle;
import javasmmr.zoowsome.models.animals.Parrot;
import javasmmr.zoowsome.models.animals.Swan;

public class BirdFactory extends SpeciesFactory {

	public Animal getAnimal(String type) { 
		
		if (Constants.Animals.Birds.Eagle.equals(type)) { 
			return new Eagle();
		}
		
		else if (Constants.Animals.Birds.Swan.equals(type)) { 
			return new Swan(); 
		} 
		
		else if (Constants.Animals.Birds.Parrot.equals(type)) { 
			return new Parrot(); 
		}
	
		else{ 
			throw new RuntimeException("Invalid animal exception!"); 
		} 
	}
}