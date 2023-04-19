package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {

	private LocalDate ankomstDato;
	private LocalDate afrejseDato;
	private Deltager deltager;
	private Hotel hotel;
	private Ledsager ledsager;
	private Konference konference;
	private ArrayList<TillægsService> tillægsServices;

	/**
	 * 
	 * @param ankomstDato
	 * @param afrejseDato
	 * @param deltager
	 * @param konference
	 */
	public Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Konference konference) {
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
			for (Udflugt udflugt : ledsager.getUdlugter()) {
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
			System.out.println(tillægsServices);
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
		ledsager.setTilmelding(null);
		for (Udflugt udflugt : ledsager.getUdlugter()) {
			ledsager.removeUdflugt(udflugt);
		}
		ledsager = null;

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
}