package hospital;

import java.util.Random;

public class Disease {

	private String name;

	private enum Severity {
		LOW, MEDIUM, HIGH
	};

	private Severity severity;

	public Disease(String name, Severity severity) {
		this.name = name;
		this.severity = severity;

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Severity getSeverity() {
		return this.severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public boolean cure() {
		Random random = new Random();
		int chance = random.nextInt(100);
		if (this.severity.equals(Severity.LOW)) {
			return chance < 75;
		} else if (this.severity.equals(Severity.MEDIUM)) {
			return chance < 50;
		} else if (this.severity.equals(Severity.HIGH)) {
			return chance < 25;
		} else
			return false;

	}

}
