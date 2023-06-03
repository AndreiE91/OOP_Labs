package shipbay;

public class CargoItem implements Carriable {

	private final String NAME;
	private final int PROFIT;

	public CargoItem(String name) {
		NAME = name;
		PROFIT = 100;
	}

	public String getName() {
		return NAME;
	}

	public int getProfit() {
		return PROFIT;
	}

}
