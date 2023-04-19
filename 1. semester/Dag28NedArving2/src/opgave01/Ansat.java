package opgave01;

public abstract class Ansat extends Person{

	private double timeLøn;
	public Ansat(String navn, String adresse, double timeLøn) {
		super(navn, adresse);
		this.timeLøn = timeLøn;
	}
	
	public abstract  double bergnUgeLøn();
	

	public double getTimeLøn() {
		return timeLøn;
	}

	public void setTimeLøn(double timeLøn) {
		this.timeLøn = timeLøn;
	}
	
	
}
