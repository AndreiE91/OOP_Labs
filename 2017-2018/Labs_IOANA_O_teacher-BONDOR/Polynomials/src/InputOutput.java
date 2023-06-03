import java.io.*;
import java.util.*;

public class InputOutput extends Polynomial {

	private Scanner x;
	Polynomial[] poly = new Polynomial[2];

	public void openTheFile() {
		try {
			x = new Scanner(new File("input.txt"));
		} catch (Exception e) {
			System.out.println("file not found");
		}
	}

	// huge thankieeees to Raul
	public void readTheFile() {

		int j = 0;
		// as along as there is a nextLine there goes the loop
		while (x.hasNextLine()) {
			// we put a line into a string str
			String str = x.nextLine();

			if (!(str.startsWith("A") || str.startsWith("M") || str.startsWith("E") || str.startsWith("S"))) {
				// splits the string based on whitespaces
				String[] splitted = str.split("\\s");
				poly[j] = new Polynomial();
				poly[j].orderOfPolynomial = splitted.length;

				for (int i = poly[j].orderOfPolynomial - 1; i >= 0; i--) {
					poly[j].coefficientsOfPolynomial[i] = Integer.parseInt(splitted[i]);
				}
			} else {
				// TODO
				// apel pe metoda computeOperations cu parametrul str
				// ce returneaza un polinom
				// apelam o metoda de scriere in fisier a rezultatului
				
				// do a main class
			}
			j++;
		}
	}

	public void closeTheFile() {
		x.close();
	}

}
