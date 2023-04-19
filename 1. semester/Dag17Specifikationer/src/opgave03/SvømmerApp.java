package opgave03;

import java.time.LocalDate;
import java.util.ArrayList;
 

public class SvømmerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Double> tider = new ArrayList<Double>();
		tider.add(28.1);
		tider.add(23.2);
		tider.add(17.2);
		tider.add(30.8);
		
		
		Svømmer s1 = new Svømmer("Rasmus", "Horsens", LocalDate.of(2000, 4, 13), tider);
		
		System.out.println("Bedste tid: " + s1.bedsteTid());
		
		System.out.println();
		
		System.out.println("Gennemsnits tiden: " + s1.gennemsnitAfTid());
		
		System.out.println();
		
		System.out.println("Gennemsnits tiden uden dårligste: " + s1.snitUdenDårligste());
		
		

		

	}

}
