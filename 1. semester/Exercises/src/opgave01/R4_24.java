package opgave01;

public class R4_24 {

	public static void main(String[] args) {
		double c = 10;
		double d = 12;
		
		double r = d/2;
		
		double h = r - calcTriangle(r, c/2, 90);
	
		
		double area = ((2/3)*c*h) + ((h * h * h) / (2 * c) ) ;
		System.out.println(area);
	}
	
	public static  double calcTriangle(double a, double c, double A) {
		double C = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(A)) * c)/a));
		double B = 180.00 - A - C;
		double b = ((Math.sin(Math.toRadians(B))*a)/Math.sin(Math.toRadians(A)));
		return b;
		
	}

}
