package opgave03;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		IndkøbsKurv in = new IndkøbsKurv();
		
		Vare v1 = new Vare("Ero papir", "toitlet papir", 15);
		Vare v2 = new FødeVare("Hansens Ketchup", "Ketchup", 6, 30 );
		Vare v3 = new Elartikel("Elartikel", "billig", 9, 3);
		Vare v4 = new Elartikel("Elartikel", "dyr", 12, 2);
		Vare v5 = new Spiritus("Vodka", "billig", 70, 40);
		Vare v6 = new Spiritus("Morgan", "dyr", 100, 45);
		
		
		in.addVarer(v1);
		in.addVarer(v2);
		in.addVarer(v3);
		in.addVarer(v4);
		in.addVarer(v5);
		in.addVarer(v6);
		
		App.kassebon(in.getVarer(), in);
		

	}
	
	public static void kassebon(ArrayList<Vare> list, IndkøbsKurv indkøb) {
		for (Vare v : list) {
			System.out.println(v.toString() +".-");
			System.out.println("Moms: " + v.beregnMoms() + ".-");
			System.out.println("Vare: " + v.beregnIndkøbsPris() + ".-");
			
		}
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("Total: " + indkøb.beregnTotalPris());
	}
	


}
