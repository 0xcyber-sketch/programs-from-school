package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
	private LocalDate dato;
	private LocalTime startTid;
	private String lokale;
	private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

	public Lektion(LocalDate dato, LocalTime startTid, String lokale) {
		this.dato = dato;
		this.startTid = startTid;
		this.lokale = lokale;
	}

	public LocalDate getDato() {
		return dato;
	}

	public LocalTime getStartTid() {
		return startTid;
	}

	public String getLokale() {
		return lokale;
	}
	
	public ArrayList<Deltagelse> getDeltagelser(){
		return new ArrayList<>(deltagelser);
	}
	
	public Deltagelse createDeltagelse(Studerende studerende) {
		Deltagelse d = new Deltagelse(this, studerende);
		deltagelser.add(d);
		return d;
	}

	@Override
	public String toString() {
		return "" + dato + " " + startTid + " " + lokale ;
	}
	
	

}
