package opgave02;

public class Kvadrat extends Figur{

	private double side;
	
	public Kvadrat(double x, double y, double side) {
		super(x,y);
		this.side = side;
	}


	public double getSide() {
		return side;
	}


	public void setSide(double side) {
		this.side = side;
	}


	@Override
	public double beregnAreal() {
		return side*side;
		
	}
	
	
}
