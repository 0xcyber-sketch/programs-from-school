package opgave02;

import java.util.ArrayList;

public class TestApp {
	public static void main(String[] args) {
		ArrayList<Mekaniker> list = new ArrayList<>();
		Mekaniker m1 = new Mekaniker("abe", "filer", 100, 1997);
		Mekaniker m2 = new Mekaniker("abe2", "filer", 100, 1997);
		Mekaniker m3 = new Mekaniker("abe3", "filer", 100, 1997);
		Værkfører v1 = new Værkfører("abe3", "filer", 100, 1997, 50, 2000);
		SynMand s1 = new SynMand("abe4", "filler", 100, 1998, 3);
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(v1);
		list.add(s1);
		
		System.out.println(TestApp.samletLøn(list));
		
		
		
	}
	
	/*** Beregner summen af ugelønnen for alle i listen **/
	public static double samletLøn(ArrayList<Mekaniker> list){
		double sum = 0;
		for (Mekaniker m : list) {
			sum += m.bergnUgeLøn();
		}
		return sum;
		
	};
}
