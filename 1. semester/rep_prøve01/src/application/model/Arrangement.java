package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
	private LocalTime startTid;
	private LocalTime slutTid;
	private LocalDate date;
	private String titel;
	private double pris;
	public Arrangement(LocalTime startTid, LocalTime slutTid, LocalDate date, String titel, double pris) {
		this.startTid = startTid;
		this.slutTid = slutTid;
		this.date = date;
		this.titel = titel;
		this.pris = pris;
	}
	public LocalTime getStartTid() {
		return startTid;
	}
	public LocalTime getSlutTid() {
		return slutTid;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getTitel() {
		return titel;
	}
	public double getPris() {
		return pris;
	}
	
	
	
	

}
