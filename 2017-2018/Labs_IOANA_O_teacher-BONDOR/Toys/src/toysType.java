
public enum toysType {
	
	CAR("car"),
	DOLL("doll"),
	EDUCATIONAL("educational");

	private String type;
	
	private toysType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
	
