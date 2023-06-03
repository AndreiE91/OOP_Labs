package criptare;

public enum CoinType {
	
	BITCOIN("bitcoin"),
	ETHEREUM("ethereum"),
	RIPPLE("ripple");
	
	private String name;
	
	private CoinType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
