package opgave02;

public class Cirkel extends Figur{

	private double r;
	
	public Cirkel(double x, double y, double r) {
		super(x,y);
		this.r = r;
	}
	
	public double beregnAreal() {
		return (r*r) * Math.PI;
		
	}
	
}
