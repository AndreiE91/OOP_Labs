package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Crocodile;
import javasmmr.zoowsome.models.animals.Snake;
import javasmmr.zoowsome.models.animals.Turtle;


public class ReptileFactory extends SpeciesFactory {

	public Animal getAnimal(String type) { 
		
		if (Constants.Animals.Reptiles.Crocodile.equals(type)) { 
			return new Crocodile();
		}
		
		else if (Constants.Animals.Reptiles.Turtle.equals(type)) { 
			return new Turtle(); 
		} 
		
		else if (Constants.Animals.Reptiles.Snake.equals(type)) { 
			return new Snake(); 
		}
	
		else{ 
			throw new RuntimeException("Invalid animal exception!"); 
		} 
	}
}