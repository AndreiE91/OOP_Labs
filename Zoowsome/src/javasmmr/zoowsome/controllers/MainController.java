package javasmmr.zoowsome.controllers;

import java.util.ArrayList;

import javasmmr.zoowsome.models.animals.*;
//import javasmmr.zoowsome.models.employees.*;
import javasmmr.zoowsome.repositories.AnimalRepository;
import javasmmr.zoowsome.services.factories.animals.*;

public class MainController {

	public static void main(String[] args) throws Exception {
		AnimalFactory animalFactory = new AnimalFactory();
		// CaretakerFactory caretakerFactory = new CaretakerFactory();
		SpeciesFactory mammalFactory = animalFactory.getSpeciesFactory(Constants.Species.MAMMAL);
		SpeciesFactory birdFactory = animalFactory.getSpeciesFactory(Constants.Species.BIRD);
		SpeciesFactory aquaticFactory = animalFactory.getSpeciesFactory(Constants.Species.AQUATIC);
		Animal[] a = new Animal[5];
		a[0] = birdFactory.getAnimal(Constants.Animals.Bird.STORK);
		a[1] = mammalFactory.getAnimal(Constants.Animals.Mammal.COW);
		a[2] = aquaticFactory.getAnimal(Constants.Animals.Aquatic.FISH);
		a[3] = birdFactory.getAnimal(Constants.Animals.Bird.PIGEON);
		a[4] = mammalFactory.getAnimal(Constants.Animals.Mammal.COW);
		AnimalRepository animalRepository = new AnimalRepository();
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(a[0]);
		animals.add(a[1]);
		animals.add(a[2]);
		animals.add(a[3]);
		animals.add(a[4]);
		animalRepository.save(animals);
		/*
		 * Caretaker[] c = new Caretaker [3]; c[0] = new Caretaker(); c[1] = new
		 * Caretaker(); c[2] = new Caretaker(); //c[0] =
		 * caretakerFactory.getEmployee(Constants.Employees.Caretaker.
		 * TCO_SUCCESS); //c[1] =
		 * caretakerFactory.getEmployee(Constants.Employees.Caretaker.TCO_KILLED
		 * ); //c[2] =
		 * caretakerFactory.getEmployee(Constants.Employees.Caretaker.
		 * TCO_NO_TIME); //System.out.println("We have an animal with " +
		 * a1.getNrOfLegs()+ " legs!\n"); for (int i=0; i<3; i++){ for (int j=0;
		 * j<5; j++){ if((c[i].getIsDead()==false) &&
		 * (a[j].getTakenCareOf()==false)){ String result =
		 * c[i].takeCareOf(a[j]);
		 * if(result.equals(Constants.Employees.Caretaker.TCO_KILLED)){
		 * System.out.println("The caretaker is dead"); } else
		 * if(result.equals(Constants.Employees.Caretaker.TCO_SUCCESS)){
		 * a[j].setTakenCareOf(true); System.out.println(a[j].getName()+
		 * " is taken care of by "+ c[i].getName()); } } } }
		 */
	}
}
