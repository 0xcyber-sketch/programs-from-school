package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {

	private LocalDateTime start;
	private LocalDateTime stop;
	private ArrayList<Plads> pladser = new ArrayList<>();

	
	public Reservation (LocalDateTime start, LocalDateTime stop) {
		this.start = start;
		this.stop = stop;
	}


	public LocalDateTime getStart() {
		return start;
	}


	public void setStart(LocalDateTime start) {
		this.start = start;
	}


	public LocalDateTime getStop() {
		return stop;
	}


	public void setStop(LocalDateTime stop) {
		this.stop = stop;
	}
	
	public ArrayList<Plads> getPlads () {
		return new ArrayList<>(pladser);
	}
	
	public void addPlads(Plads plads) {
		if (!pladser.contains(plads)) {
			pladser.add(plads);
			plads.addReservation(this);
		}
	}
	
	public void removePlads(Plads plads) {
		if (pladser.contains(plads)) {
			pladser.remove(plads);
			plads.removeReservation(this);
		}
	}
}
