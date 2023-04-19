package application.model;

import java.util.ArrayList;

public class Frivillig {

	private String navn;
	private String mobil;
	private int maksAntalTimer;
	private ArrayList<Vagt> vagter = new ArrayList<>();
	
	public Frivillig(String navn, String mobil, int maksAntalTimer) {
	this.navn = navn;
	this.mobil = mobil;
	this.maksAntalTimer = maksAntalTimer;
	}

	public String getNavn() {
		return navn;
	}

	public String getMobil() {
		return mobil;
	}

	public int getMaksAntalTimer() {
		return maksAntalTimer;
	}
	
	public ArrayList<Vagt> getVagter(){
		return new ArrayList<>(vagter);
	}
	
	public void addVagt(Vagt vagt) {
		if (vagter.contains(vagt)) {
			vagter.add(vagt);
		}
	}
	
	public void removeVagt(Vagt vagt) {
		if (vagter.contains(vagt)) {
			vagter.remove(vagt);
		}
	}
	
	public int  ledigeTimer() {
		int timer = maksAntalTimer;
		if (!vagter.isEmpty()) {
			for (Vagt v : vagter) {
				timer -= v.getTimer();
			}
		}
		
		return timer;
	}

}
