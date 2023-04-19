package application.model;

import java.util.ArrayList;


public class Studerende {
	private String navn;
	private String email;
	private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

	public Studerende(String navn, String email) {
		this.navn = navn;
		this.email = email;
	}

	public String getNavn() {
		return navn;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Deltagelse> getDeltagelser(){
		return new ArrayList<>(deltagelser);
	}
	
	public void addDeltagelser(Deltagelse d) {
		if (!deltagelser.contains(d)) {
			deltagelser.add(d);
			d.setStuderende(this);
		}
		
	}
	
	public void removeDeltagelser(Deltagelse d) {
		if (!deltagelser.contains(d)) {
			deltagelser.add(d);
			d.setStuderende(null);
		}
	}
	
	public int antalFraværsLektioner() {
		int fraværsLektioner = 0;
		for (Deltagelse d : getDeltagelser()) {
			if (d.erRegistreretFraværende()) {
				fraværsLektioner++;
			}
		}
		return fraværsLektioner;
	}
	
	
    public int compareTo(Studerende stud) {
		int comp = navn.compareTo(stud.getNavn());
		return comp;
	}
	

}
