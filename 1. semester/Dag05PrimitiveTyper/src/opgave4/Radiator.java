package opgave4;

public class Radiator {
	
	private int temperatur;
	
	public Radiator() {
		this.temperatur = 20;
	}
	
	public Radiator(int temperatur) {
		this.temperatur = temperatur;
	}

	public int getTemperatur() {
		return temperatur;
	}

	public void turnUpTemperatur(int temperatur) {
		this.temperatur += temperatur;
	}
	
	public void turnDownTemperatur(int temperatur) {
		this.temperatur -= Math.abs(temperatur);
	}
	
	
	
	
	

}
