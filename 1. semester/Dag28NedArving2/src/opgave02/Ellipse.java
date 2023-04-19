package opgave02;

public class Ellipse extends Figur{

		private double r1;
		private double r2;
		public Ellipse(double x, double y, double r1, double r2) {
			super(x,y);
			this.r1 = r1;
			this.r2 = r2;
		}
		
		public double beregnAreal() {
			return r1*r2 * Math.PI;
			
		}
	

}
