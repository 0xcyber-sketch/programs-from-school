package opgave02;

public class testApp {

	public static void main(String[] args) {
		
		Kvadrat k1 = new Kvadrat(0, 0, 5);
		Rektangle r1 = new Rektangle(0, 0, 5, 2);
		
		Cirkel c1 = new Cirkel(0, 0, 5);
		Ellipse e1 = new Ellipse (0,0, 2, 3);
		
		System.out.println(k1.getClass().getSimpleName() + " Areal: " + k1.beregnAreal());
		k1.move(2, 2);
		System.out.println(k1.getClass().getSimpleName() + " Forskudt: x:" + k1.getX() + " y: " + k1.getY());
		
		System.out.println(r1.getClass().getSimpleName() + " Areal: " + r1.beregnAreal());
		r1.move(2, 2);
		System.out.println(r1.getClass().getSimpleName() + " Forskudt: x:" + r1.getX() + " y: " + r1.getY());
		
		System.out.println(c1.getClass().getSimpleName() + " Areal: " + c1.beregnAreal());
		c1.move(2, 2);
		System.out.println(c1.getClass().getSimpleName() + " Forskudt: x:" + c1.getX() + " y: " + c1.getY());
		
		System.out.println(e1.getClass().getSimpleName() + " Areal: " + e1.beregnAreal());
		e1.move(2, 2);
		System.out.println(e1.getClass().getSimpleName() + " Forskudt: x:" + e1.getX() + " y: " + e1.getY());
		
	}

}
