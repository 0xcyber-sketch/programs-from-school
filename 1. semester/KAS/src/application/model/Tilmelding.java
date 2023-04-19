package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {

	private Deltager deltager;
	private Konference konference;
	private LocalDate ankomstDato;
	private LocalDate afrejseDato;
	private Ledsager ledsager;
	private Hotel hotel;
	private ArrayList<TillægsService> tillægsServices;

	/**
	 * 
	 * @param deltager
	 * @param konference
	 * @param ankomstDato
	 * @param afrejseDato
	 */
	public Tilmelding(Deltager deltager, Konference konference, LocalDate ankomstDato, LocalDate afrejseDato) {
		this.ankomstDato = ankomstDato;
		this.afrejseDato = afrejseDato;
		this.deltager = deltager;
		this.tillægsServices = new ArrayList<>();
		this.setKonference(konference);
	}

	public double beregnPris() {
		double totalPris = 0;
		long days = ChronoUnit.DAYS.between(getAnkomstDato(), getAfrejseDato());
		if (deltager.getClass() != Foredragsholder.class) {
			totalPris += konference.getPris() * (1 + days);
		}
		if (hotel != null) {
			if (ledsager != null) {
				totalPris += hotel.getPrisDobbeltVærelse() * days;
			} else {
				totalPris += hotel.getPrisEnkeltVærelse() * days;
			}
			for (TillægsService tillægsService : tillægsServices) {
				totalPris += tillægsService.getPris() * days;
			}
		}
		if (ledsager != null) {
			for (Udflugt udflugt : ledsager.getUdflugter()) {
				totalPris += udflugt.getPris();
			}
		}
		return totalPris;
	}

	public LocalDate getAnkomstDato() {
		return ankomstDato;
	}

	public void setAnkomstDato(LocalDate ankomstDato) {
		this.ankomstDato = ankomstDato;
	}

	public LocalDate getAfrejseDato() {
		return afrejseDato;
	}

	public void setAfrejseDato(LocalDate afrejseDato) {
		this.afrejseDato = afrejseDato;
	}

	public Deltager getDeltager() {
		return deltager;
	}

	public void setDeltager(Deltager deltager) {
		if (this.deltager != deltager) {
			if (this.deltager != null) {
				this.deltager.removeTilmelding(this);
			}
			this.deltager = deltager;
			if (deltager != null) {
				deltager.addTilmelding(this);
			}
		}
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		if (this.hotel != hotel) {
			this.hotel = hotel;
			for (TillægsService tillægsService : getTillægsServices()) {
				removeTilllægService(tillægsService);
			}
		}
	}

	public Ledsager getLedsager() {
		return ledsager;
	}

	public Ledsager createLedsager(String navn) {
		ledsager = new Ledsager(navn, this);
		return ledsager;
	}

	public void deleteLedsager() {
		if (ledsager != null) {
			ledsager.setTilmelding(null);
			for (Udflugt udflugt : ledsager.getUdflugter()) {
				ledsager.removeUdflugt(udflugt);
			}
			ledsager = null;
		}
	}

	public Konference getKonference() {
		return konference;
	}

	public void setKonference(Konference konference) {
		if (konference != this.konference) {
			if (this.konference != null) {
				this.konference.removeTilmelding(this);
			}
			this.konference = konference;
			if (this.konference != null) {
				this.konference.addTilmelding(this);
			}
		}
	}

	public ArrayList<TillægsService> getTillægsServices() {
		return new ArrayList<>(tillægsServices);
	}

	public void addTilllægService(TillægsService tillægService) {
		if (!tillægsServices.contains(tillægService)) {
			tillægsServices.add(tillægService);
			tillægService.addTilmelding(this);
		}
	}

	public void removeTilllægService(TillægsService tillægService) {
		if (tillægsServices.contains(tillægService)) {
			tillægsServices.remove(tillægService);
			tillægService.removeTilmelding(this);
		}
	}
	
	@Override
	public String toString() {
		return konference + " : " + deltager.getNavn();
	}
}