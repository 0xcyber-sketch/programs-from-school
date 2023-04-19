package opgave01;

import java.util.ArrayList;

public class HundApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hund h1 = new Hund("Buller", 5000, false, Race.BOKSER);
		Hund h2 = new Hund("Kai", 2000, false, Race.PUDDEL);
		Hund h3 = new Hund("Tove", 17000, true, Race.BOKSER);
		Hund h4 = new Hund("snout", 10000, true, Race.TERRIER);
		Hund h5 = new Hund("Kim", 3000, false, Race.BOKSER);
		
		ArrayList<Hund> hundeListe = new ArrayList<>();
		
		hundeListe.add(h1);
		hundeListe.add(h2);
		hundeListe.add(h3);
		hundeListe.add(h4);
		hundeListe.add(h5);
		
		System.out.println(samletPris(hundeListe, Race.BOKSER));
		

	}
	
	public static int samletPris (ArrayList<Hund> hunde, Race race) {
		int sum = 0;
		for (Hund h : hunde) {
			if (h.getRace() == race) {
				sum += h.getPris();
			}
		}
		
		return sum;
		
	}

}
