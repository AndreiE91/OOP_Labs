package readFromFile;

import java.io.*;
import java.util.*;

public class readFile {
	
	private Scanner x;

	public void openTheFile() {
		try {
			x = new Scanner(new File("input.txt"));
		} catch (Exception e) {
			System.out.println("file not found");
		}
	}

	public void readTheFile() {

		//we use this to say that we have only one line at first
		int index = 0;
		// as along as there is a nextLine there goes the loop
		while (x.hasNextLine()) {
			// we put a line into a string str
			String str = x.nextLine();
			// splits the string based on whitespaces
			String[] splitted = str.split("\\s");
			int size = splitted.length;
			System.out.println(size);
		}

	}

	public void closeTheFile() {
		x.close();
	}

}
