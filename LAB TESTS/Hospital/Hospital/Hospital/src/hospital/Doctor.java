package hospital;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Set;

public class Doctor extends Person {

	private int diseaseCured;

	public Doctor(int ID, String name) throws InputMismatchException {
		super(ID, name);
	}

	public int getDiseaseCured() {
		return this.diseaseCured;
	}

	public void setDiseaseCured(int diseaseCured) {
		this.diseaseCured = diseaseCured;
	}

	public void curePacient(Pacient pacient) {
		Set<Disease> diseases = pacient.getDiseases();
		int numberOfDiseasesToCure = new Random().nextInt(diseases.size() + 1);
		for (int i = 0; i < numberOfDiseasesToCure; i++) {
			if (pacient.care(diseases.iterator().next())) {
				diseaseCured++;
			}

		}
	}
	public String toString(){
		return this.getName();
	}

}
