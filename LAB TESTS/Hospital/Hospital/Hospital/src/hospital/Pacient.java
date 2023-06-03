package hospital;

import java.util.HashSet;
import java.util.Set;

public class Pacient extends Person {

	private Set<Disease> diseases;

	public Pacient(int ID, String name) {
		super(ID, name);
	}

	public void addDisease(Disease disease) {
		diseases = new HashSet<Disease>();
		diseases.add(disease);

	}

	public boolean care(Disease disease) {
		if (diseases.contains(disease)) {
			if (disease.cure()) {
				diseases.remove(disease);
				return true;
			}
		}
		return false;

	}

	public int getNumberDisease() {
		return diseases.size();
	}

	public Set<Disease> getDiseases() {
		return this.diseases;
	}

	public String toString() {
		return this.getName();
	}
}
