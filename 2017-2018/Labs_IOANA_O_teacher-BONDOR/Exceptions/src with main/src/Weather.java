import java.io.IOException;

public class Weather {
	private float degrees;

	public Weather(float degrees) {
		this.degrees = degrees;
	}

	public float getDegrees() throws FreezingException, IOException {
		if (this.degrees < 0)
			throw new FreezingException("The temperature is below 0 degrees.");
		else throw new IOException();
	}

	public void setDegrees(float degrees) {
		this.degrees = degrees;
	}

}
