package controllers;

import java.util.Arrays;

import models.Adult;
import models.Children;
import models.Customer;
import models.Domino;
import models.Robot;
import models.Toy;

public class Shop {

	public static void main(String[] args) {

		Customer[] customers = { new Children("Patricia", 18, 125), new Children("Bianca", 20, 40),
				new Children("Vlad", 12, 300), new Adult("Vasile", 42, 250), new Adult("Andrei", 37, 500) };

		Toy[] toys = { new Toy(75, Constants.Toy.EDUCATIONAL), new Robot(75, Constants.Toy.EDUCATIONAL, 30),
				new Toy(40, Constants.Toy.CAR), new Domino(120, Constants.Toy.EDUCATIONAL,20),
				new Toy(100, Constants.Toy.DOLL) };

		// SORT THE CUSTOMER ARRAY
		/*
		 * Customer aux; 
		 * 
		 * for(int i = 0; i < customers.length ; i++) {
		 * 
		 * for( int j = i + 1 ; j < customers.length; j++) {
		 * 
		 * if ( customers[i].getBudget() > customers[j].getBudget()) {
		 * 
		 * aux = customers[i]; customers[i] = customers[j]; customers[j] = aux; } } }
		 */

		// Arrays.sort(customers);

		// PRINT THE CUSTOMER ARRAY AFTER SORTING IT
		System.out.println("The sorted array of customer's budget is:");
		for (int i = 0; i < customers.length; i++) {

			System.out.printf("%d ", customers[i].getBudget());
		}

		// PRINT THE CHILDREN'S NAME
		System.out.println("\n\nChildren's name are:");
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] instanceof Children) {
				System.out.println(customers[i].getName());
			}
		}

		customers[2].buyToys(toys[0]);

		System.out.println(toys[1].getClass());

		Robot r1 = (Robot) toys[1];
		r1.consumePower();

		Domino d1 = (Domino) toys[3];
		d1.countPieces();
		
	}
}
