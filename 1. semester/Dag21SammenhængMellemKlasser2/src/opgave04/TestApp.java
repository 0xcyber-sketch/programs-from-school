package opgave04;

import java.time.LocalDate;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kollegie k1 = new Kollegie("Kooollige", "Apavej 95");
		
		Bollig b1 = k1.createBollig(63, "1.a", 52552);
		Bollig b2 = k1.createBollig(63, "1.b", 20000);
		Bollig b3 = k1.createBollig(63, "1.c", 73728);
		
		LejeAftale l1 = b1.createLejeAftale(LocalDate.of(2020, 11, 10));
		LejeAftale l2 = b2.createLejeAftale(LocalDate.of(2020, 1, 6));
		LejeAftale l3 = b3.createLejeAftale(LocalDate.of(2020, 3, 28));
		LejeAftale l4 = b3.createLejeAftale(LocalDate.of(2021, 3, 28));
		
		System.out.println(k1.getAntalLejeAftaler());		
		
		l1.setTilDato(l1.getFraDato().plusDays(2));
		l2.setTilDato(l2.getFraDato().plusDays(3));
		l3.setTilDato(l3.getFraDato().plusDays(2));
		l4.setTilDato(l4.getFraDato().plusDays(5));
		
		System.out.println(k1.gennemsnitligAntalDage());
		
		
		
	}

}
