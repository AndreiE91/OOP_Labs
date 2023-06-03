package shipbay;

public class Passanger implements Carriable {

	private final String NAME;

	public Passanger(String name) {
		NAME = name;
	}

	public String getName() {
		return NAME;
	}

}
