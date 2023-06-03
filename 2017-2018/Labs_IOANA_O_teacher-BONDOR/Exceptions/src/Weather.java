
public class Weather {

	private float degrees;
	
	public Weather(float degrees) {
		this.degrees = degrees;
	}
	
	public void setDegrees(float degrees) {
		this.degrees = degrees;
	}
	
	public float getDegrees() throws FreezingException{
		if(  degrees < 0 ) {
			throw new FreezingException("this weather is awful");
		}
		return degrees;
	}
	
	
	
}
