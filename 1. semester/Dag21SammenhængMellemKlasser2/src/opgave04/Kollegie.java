package opgave04;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Kollegie {
	private String navn;
	private String adresse;
	private final ArrayList<Bollig> bolliger = new ArrayList<>();
	
	public Kollegie(String navn, String adresse) {
		this.navn = navn;
		this.adresse = adresse;
		
	}

	public String getNavn() {
		return navn;
	}

	public String getAdresse() {
		return adresse;
	}
	
	public ArrayList<Bollig> getBolliger(){
		return new ArrayList<>(bolliger);
	}
	
	public void addBollig(Bollig bollig) {
		if (!bolliger.contains(bollig)){
			bolliger.add(bollig);
			bollig.setKollegie(this);
			//
		}
	}
	
	public void removeBollig(Bollig bollig) {
		if (bolliger.contains(bollig)) {
			bolliger.remove(bollig);
			bollig.setKollegie(null);
		}
	}
	
	public Bollig createBollig(int kvm, String adresse, int pris) {
		Bollig b = new Bollig(kvm, adresse, pris);
		bolliger.add(b);
		b.setKollegie(this);
		return b;
	}
	
	public int getAntalLejeAftaler() {
		int sum = 0;
		
		
		for (Bollig b : bolliger) {
			for (LejeAftale l : b.getLejeAftaler()) {
				sum++;
			}
			
		}
		
		return sum;
	}
	
	public double gennemsnitligAntalDage() {
		double sum = 0;
		double amountOfLejeAftaler = getAntalLejeAftaler();
		
		for (Bollig b : bolliger) {
			for (LejeAftale l : b.getLejeAftaler()) {
				if (l.getTilDato() != null) {
				sum += ChronoUnit.DAYS.between(l.getFraDato(), l.getTilDato());}
				
			}
			
		}
		
		return sum / amountOfLejeAftaler;
	}

}
