package opgave02;

public class Rektangle extends Figur{
	private double side1;
	private double side2;
	
	public Rektangle(double x, double y, double side1, double side2) {
		super(x,y);
		this.side1 = side1;
		this.side2 = side2;
	}
	
	@Override
	public double beregnAreal() {
		return side1*side2;
		
	}


}
