package opgave04;

import java.time.LocalDate;

public class LejeAftale {
	private LocalDate fraDato;
	private LocalDate tilDato;
	
	private Bollig bollig;
	
	private Lejer[] lejers= new Lejer[2];
	private int antalLejrer = 0;
	
	 LejeAftale(LocalDate fraDato, Bollig bollig) {
		 this.fraDato = fraDato;
		 this.tilDato = null;
		 this.bollig = bollig;
	}

	public LocalDate getFraDato() {
		return fraDato;
	}

	public void setFraDato(LocalDate fraDato) {
		this.fraDato = fraDato;
	}

	public LocalDate getTilDato() {
		return tilDato;
	}

	public void setTilDato(LocalDate tilDato) {
		this.tilDato = tilDato;
	}
	 
	public Bollig getBollig() {
		return bollig;
	}
	
	public void addLejer(Lejer lejer) {
		if (antalLejrer <= 2) {
			lejers[antalLejrer] = lejer;
			antalLejrer++;
		}
		
	}

	public Lejer[] getLejers() {
		Lejer[] tempArray = lejers;
		
		return tempArray;
	}
	
	public void removeLejer(Lejer lejer) {
		
		int i = 0;
		boolean forskelligt = false;
		
		while ( i < 2 || forskelligt) {
			if (lejers[i].equals(lejer)) {
				lejers[i] = null;
				antalLejrer--;
				forskelligt = true;
				
			}
			i++;
		}
	}
	
	
	
	
	
	
	 
	 
}
