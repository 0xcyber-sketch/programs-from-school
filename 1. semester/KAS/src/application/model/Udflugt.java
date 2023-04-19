package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Udflugt {

	private String sted;
	private String beskrivelse;
	private double pris;
	private LocalDateTime startTid;
	private ArrayList<Ledsager> ledsagere;

	public Udflugt(String sted, String beskrivelse, double pris, LocalDateTime startTid) {
		this.sted = sted;
		this.startTid = startTid;
		this.pris = pris;
		this.beskrivelse = beskrivelse;
		this.ledsagere = new ArrayList<>();
	}
	
	public ArrayList<Ledsager> getLedsagere() {
		return new ArrayList<>(ledsagere);
	}

	/**
	 * 
	 * @param ledsager
	 */
	public void addLedsager(Ledsager ledsager) {
		if (!ledsagere.contains(ledsager)) {
			ledsagere.add(ledsager);
			ledsager.addUdflugt(this);
		}
	}

	/**
	 * 
	 * @param ledsager
	 */
	public void removeLedsager(Ledsager ledsager) {
		if (ledsagere.contains(ledsager)) {
			ledsagere.remove(ledsager);
			ledsager.removeUdflugt(this);
		}
	}

	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}

	public LocalDateTime getStartTid() {
		return startTid;
	}

	public void setStartTid(LocalDateTime startTid) {
		this.startTid = startTid;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	@Override
	public String toString() {
		return sted;
	}
}