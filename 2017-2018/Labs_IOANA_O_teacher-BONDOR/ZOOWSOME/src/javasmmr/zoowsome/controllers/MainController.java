package javasmmr.zoowsome.controllers;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import javasmmr.zoowsome.models.animals.*;
import javasmmr.zoowsome.models.employees.Caretaker;

import javasmmr.zoowsome.repositories.AnimalRepository;
import javasmmr.zoowsome.services.factories.animals.AnimalFactory;
import javasmmr.zoowsome.services.factories.animals.Constants;
import javasmmr.zoowsome.services.factories.animals.SpeciesFactory;

public class MainController {

	public static void main(String[] args) throws XMLStreamException, ParserConfigurationException, IOException, SAXException {
		AnimalFactory abstractFactory = new AnimalFactory();

		SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
		Animal a1 = speciesFactory1.getAnimal(Constants.Animals.Mammals.Tiger);
		System.out.printf("We have an animal with %d legs!\n", a1.getNrOfLegs());

		SpeciesFactory speciesFactory2 = abstractFactory.getSpeciesFactory(Constants.Species.Insects);
		Animal a2 = (Cockroach) speciesFactory2.getAnimal(Constants.Animals.Insects.Cockroach);
		System.out.printf("I have a new animl made by me, wohoo! But, can it fly? ->  %s \n",
				((Cockroach) a2).getCanFly());

		SpeciesFactory speciesFactory3 = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
		Animal a3 = (Penguin) speciesFactory3.getAnimal(Constants.Animals.Aquatics.Penguin);
		System.out.printf("This awesome animal who lives in %s \n", ((Penguin) a3).getWaterType());

		SpeciesFactory speciesFactory4 = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
		Animal a4 = (Penguin) speciesFactory4.getAnimal(Constants.Animals.Aquatics.Penguin);
		System.out.printf("This awesome animal who lives in %s \n", ((Penguin) a4).getWaterType());
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(a1);
		animalList.add(a2);
		animalList.add(a3);
		animalList.add(a4);

		Caretaker[] caretakers = new Caretaker[3];
		Caretaker c1 = new Caretaker("Alex", 1, new BigDecimal(10), false);
		Caretaker c2 = new Caretaker("Vlad", 2, new BigDecimal(10), false);
		Caretaker c3 = new Caretaker("Mihai", 3, new BigDecimal(10), false);

		caretakers[0] = c1;
		caretakers[1] = c2;
		caretakers[2] = c3;

		// for(int i=0;i<caretakers.length;i++)
		// System.out.println(caretakers[i].getName());

		// cu for each
		// google ArrayList
		List<Caretaker> caretakerList = new ArrayList<Caretaker>();
		caretakerList.add(c1);
		caretakerList.add(c2);
		caretakerList.add(c3);
		
		for (Caretaker caretaker : caretakerList) {
			for (Animal animal : animalList) {
				if (!caretaker.getIsDead() && !animal.getTakenCareOf()) {

					String result = caretaker.takeCareOf(animal);
					if (result.equals(Constants.Employees.Caretakers.TCO_KILLED)) {
						caretaker.setIsDead(true);
						System.out.println(caretaker.getName() + " died while taking care of "+animal.getName());
					} else if (result.equals(Constants.Employees.Caretakers.TCO_NO_TIME)) {
						System.out.println(caretaker.getName()+" has no time to take care of "+animal.getName());
						continue;
					} else {
						animal.setTakenCareOf(true);
						System.out.println(caretaker.getName()+" took care of "+animal.getName());
					}
				}
			}
		}

		
		
	AnimalRepository animalRepositoryMain = new AnimalRepository();
	
	System.out.println(animalList.size());
	
	animalRepositoryMain.save(animalList);
	
	ArrayList<Animal> animalRepositoryMain2 = animalRepositoryMain.load();
	
	//howwwww ca in animalRepositoryMain am numa 3 animale :(((
	System.out.println(animalList.size() +"\nTesting how load works:" + animalRepositoryMain2.size());
	for(  Animal animal: animalRepositoryMain2) {
		//de ce imi da asa numele la animale??
		System.out.println(animal.getName());
	}
	
	}

	
	
}
