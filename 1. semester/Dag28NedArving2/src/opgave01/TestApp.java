package opgave01;

import java.util.ArrayList;

public class TestApp {
	public static void main(String[] args) {
		ArrayList<Ansat> list = new ArrayList<>();
		Mekaniker m1 = new Mekaniker("abe", "filer", 100, 1997);
		Mekaniker m2 = new Mekaniker("abe2", "filer", 100, 1997);
		Mekaniker m3 = new Mekaniker("abe3", "filer", 100, 1997);
		Værkfører v1 = new Værkfører("abe3", "filer", 100, 50, 1997);
		SynMand s1 = new SynMand("abe4", "filler", 100, 1998, 3);
		Ansat a1 = new ArbejdsDreng("abe5", "filler", 100);
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(v1);
		list.add(s1);
		list.add(a1);
		
		System.out.println(TestApp.samletLøn(list));
		
		
		
	}
	
	/*** Beregner summen af ugelønnen for alle i listen **/
	public static double samletLøn(ArrayList<Ansat> list){
		double sum = 0;
		for (Ansat a : list) {
			sum += a.bergnUgeLøn();
		}
		return sum;
		
	};
}
