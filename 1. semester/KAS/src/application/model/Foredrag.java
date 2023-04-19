package application.model;

import java.time.LocalDateTime;

public class Foredrag {

	private String emne;
	private LocalDateTime startTid;
	private double varighed;
	private Konference konference;
	private Foredragsholder foredragsholder;

	/**
	 * 
	 * @param emne
	 * @param startTid
	 * @param varighed
	 * @param konference
	 */
	 Foredrag(String emne, LocalDateTime startTid, double varighed, Konference konference) {
		this.emne = emne;
		this.startTid = startTid;
		this.varighed = varighed;
		this.konference = konference;
	}

	public String getEmne() {
		return emne;
	}

	public void setEmne(String emne) {
		this.emne = emne;
	}

	public LocalDateTime getStartTid() {
		return startTid;
	}

	public void setStartTid(LocalDateTime startTid) {
		this.startTid = startTid;
	}

	public double getVarighed() {
		return varighed;
	}

	public void setVarighed(double varighed) {
		this.varighed = varighed;
	}

	public Foredragsholder getForedragsholder() {
		return foredragsholder;
	}

	public void setForedragsholder(Foredragsholder foredragsholder) {
		if (this.foredragsholder != foredragsholder) {
			if (this.foredragsholder != null) {
				this.foredragsholder.removeForedrag(this);
			}
			this.foredragsholder = foredragsholder;
			if (foredragsholder != null) {
				foredragsholder.addForedrag(this);
			}
		}
	}

	public Konference getKonference() {
		return konference;
	}
	
	void setKonference(Konference konference) {
		if (konference == null) {
			this.konference = null;
		}
	}
	
	@Override
	public String toString() {
		return emne;
	}
}