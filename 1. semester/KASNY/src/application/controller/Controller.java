package application.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import application.model.Deltager;
import application.model.Foredrag;
import application.model.Foredragsholder;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
import application.model.TillægsService;
import application.model.Tilmelding;
import application.model.Udflugt;
import javafx.scene.control.DatePicker;
import storage.Storage;

public class Controller {

	public static Konference createKonference(String navn, String beskrivelse, LocalDateTime startDato, String adresse,
			double pris, LocalDateTime slutDato) {

		Konference k1 = new Konference(navn, beskrivelse, startDato, adresse, pris, slutDato);
		Storage.addKonference(k1);
		return k1;
	}

	public static ArrayList<Konference> getKonference() {
		return Storage.getKonferencer();
	}

	public static void removeKonference(Konference konference) {
		if (Storage.getKonferencer().contains(konference)) {
			Storage.removeKonference(konference);
		}
	}

	public static void addTilmeldingToKonference(Tilmelding tilmelding, Konference konference) {
		konference.addTilmelding(tilmelding);
	}

	public static void removeTilmeldingFromKonference(Tilmelding tilmelding, Konference konference) {
		konference.removeTilmelding(tilmelding);
	}

	public static void addHotelToKonference(Hotel hotel, Konference konference) {
		konference.addHotel(hotel);
	}

	public static void removeHotelFromKonference(Hotel hotel, Konference konference) {
		konference.removeHotel(hotel);
	}

	public static void updateKonference(Konference konference, String navn, String beskrivelse, LocalDateTime startDato,
			String adresse, double pris, LocalDateTime slutDato) {
		konference.setNavn(navn);
		konference.setBeskrivelse(beskrivelse);
		konference.setStartDato(startDato);
		konference.setAdresse(adresse);
		konference.setPris(pris);
		konference.setSlutDato(slutDato);
	}

	// --------------------------------

	public static Hotel createHotel(double prisEnkeltVærelse, String navn, String adresse, double prisDobbeltVærelse) {
		Hotel h1 = new Hotel(prisEnkeltVærelse, navn, adresse, prisDobbeltVærelse);
		Storage.addHotel(h1);
		;
		return h1;
	}

	public static ArrayList<Hotel> getHoteller() {
		return Storage.getHoteller();
	}

	public static void removeHoteller(Hotel hotel) {
		if (Storage.getHoteller().contains(hotel)) {
			Storage.removeHotel(hotel);
		}
	}

	public static void updateHotel(Hotel hotel, double prisEnkeltVærelse, String navn, String adresse,
			double prisDobbeltVærelse) {
		hotel.setPrisEnkeltVærelse(prisEnkeltVærelse);
		hotel.setPrisDobbeltVærelse(prisDobbeltVærelse);
		hotel.setNavn(navn);
		hotel.setAdresse(adresse);
	}

	// ----------------

	public static Deltager createDeltager(String navn, String adresse, String by_Land, String tlfNr) {
		Deltager d1 = new Deltager(navn, adresse, by_Land, tlfNr);
		Storage.addDeltager(d1);
		return d1;
	}

	public static Deltager createDeltager(String navn, String adresse, String by_Land, String tlfNr, String firmaNavn,
			String firmaTlfNr) {

		Deltager d1 = new Deltager(navn, adresse, by_Land, tlfNr, firmaNavn, firmaTlfNr);
		Storage.addDeltager(d1);
		return d1;

	}

	public static Foredragsholder createForedragsholder(String navn, String adresse, String by_Land, String tlfNr,
			String speciale) {

		Foredragsholder f1 = new Foredragsholder(navn, adresse, by_Land, tlfNr, speciale);
		Storage.addDeltager(f1);
		return f1;

	}

	public static Foredragsholder createForedragsholder(String navn, String adresse, String by_Land, String tlfNr,
			String firmaNavn, String firmaTlfNr, String speciale) {

		Foredragsholder f1 = new Foredragsholder(navn, adresse, by_Land, tlfNr, firmaNavn, firmaTlfNr, speciale);
		Storage.addDeltager(f1);
		return f1;

	}

	public static ArrayList<Deltager> getDeltagere() {
		return Storage.getDeltagere();
	}

	public static void removeDeltager(Deltager deltager) {
		if (Storage.getDeltagere().contains(deltager)) {
			Storage.removeDeltager(deltager);
		}
	}

	public void addTilmeldingToDeltager(Tilmelding tilmelding, Deltager deltager) {
		deltager.addTilmelding(tilmelding);
	}

	public void removeTilmeldingFromDeltager(Tilmelding tilmelding, Deltager deltager) {
		deltager.removeTilmelding(tilmelding);
	}

	public static void addForedragToForedragsholder(Foredrag foredrag, Foredragsholder foredragsholder) {
		foredragsholder.addForedrag(foredrag);
	}

	public static void removeForedragFromForedragsholder(Foredrag foredrag, Foredragsholder foredragsholder) {
		foredragsholder.removeForedrag(foredrag);
	}

	public static void addForedragerToForedragsholder(ArrayList<Foredrag> foredrager, Foredragsholder foredragsholder) {
		for (Foredrag foredrag : foredrager) {
			Controller.addForedragToForedragsholder(foredrag, foredragsholder);
		}
	}
	
	public static void updateForedragerOnForedragsholder(ArrayList<Foredrag> foredrager, Foredragsholder foredragsholder) {
		for (Foredrag foredrag : foredragsholder.getForedrager()) {
			if (!foredrager.contains(foredrag)) {
				Controller.removeForedragFromForedragsholder(foredrag, foredragsholder);
			}
		}
		
		for (Foredrag foredrag : foredrager) {
			if (!foredragsholder.getForedrager().contains(foredrag)) {
				Controller.addForedragerToForedragsholder(foredrager, foredragsholder);
			}
		}
	}

	public static void updateDeltager(Deltager deltager, String navn, String adresse, String by_Land, String tlfNr) {
		deltager.setAdresse(adresse);
		deltager.setTlfNr(tlfNr);
		deltager.setNavn(navn);
		deltager.setBy_Land(by_Land);
	}

	public static void updateDeltager(Deltager deltager, String navn, String adresse, String by_Land, String tlfNr,
			String firmaNavn, String firmaTlfNr) {

		Controller.updateDeltager(deltager, navn, adresse, by_Land, tlfNr);
		deltager.setFirmaNavn(firmaNavn);
		deltager.setFirmaTlfNr(firmaTlfNr);
	}

	public static void updateForedragsholder(Foredragsholder foredragsholder, String navn, String adresse,
			String by_Land, String tlfNr, String speciale) {

		Controller.updateDeltager(foredragsholder, navn, adresse, by_Land, tlfNr);
		foredragsholder.setSpeciale(speciale);
	}

	public static void updateForedragsholder(Foredragsholder foredragsholder, String navn, String adresse,
			String by_Land, String tlfNr, String firmaNavn, String firmaTlfNr, String speciale) {

		Controller.updateDeltager(foredragsholder, navn, adresse, by_Land, tlfNr, firmaNavn, firmaTlfNr);
		foredragsholder.setSpeciale(speciale);
	}

	// ----------------

	public static Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager,
			Konference konference) {

		Tilmelding t1 = new Tilmelding(ankomstDato, afrejseDato, deltager, konference);
		Storage.addTilmelding(t1);
		return t1;
	}

	public static void addTillægsServiceToTilmelding(TillægsService tillægsService, Tilmelding tilmelding) {
		tilmelding.addTilllægService(tillægsService);
	}

	public static void addTillægsServicesToTilmelding(ArrayList<TillægsService> tillægsServices,
			Tilmelding tilmelding) {
		for (TillægsService tillægsService : tillægsServices) {
			Controller.addTillægsServiceToTilmelding(tillægsService, tilmelding);
		}
	}
	
	public static void updateTillægsServicesOnTilmelding(ArrayList<TillægsService> tillægsServices,
			Tilmelding tilmelding) {
		for (TillægsService tillægsService : tilmelding.getTillægsServices()) {
			if (!tillægsServices.contains(tillægsService)) {
				Controller.removeTillægsServiceFromTilmelding(tillægsService, tilmelding);
			}
		}
		
		for (TillægsService tillægsService : tillægsServices) {
			if (!tilmelding.getTillægsServices().contains(tillægsService)) {
				Controller.addTillægsServicesToTilmelding(tillægsServices, tilmelding);
			}
		}
	}

	public static void removeTillægsServiceFromTilmelding(TillægsService tillægsService, Tilmelding tilmelding) {
		tilmelding.removeTilllægService(tillægsService);
	}

	public static void addHotelToTilmelding(Hotel hotel, Tilmelding tilmelding) {
		tilmelding.setHotel(hotel);
	}

	public static void removeHotelFromTilmelding(Tilmelding tilmelding) {
		tilmelding.setHotel(null);
	}

	public static void updateTilmelding(Tilmelding tilmelding, Konference konference, LocalDate ankomstDato,
			LocalDate afrejseDato) {
		tilmelding.setKonference(konference);
		tilmelding.setAnkomstDato(ankomstDato);
		tilmelding.setAfrejseDato(afrejseDato);
	}

	// --------------------------

	public static Ledsager createLedsager(String navn, Tilmelding tilmelding) {
		Ledsager l1 = tilmelding.createLedsager(navn);
		return l1;
	}

	public static void deleteLedsager(Tilmelding tilmelding) {
		tilmelding.deleteLedsager();
	}

	public static void addUdflugtToLedsager(Udflugt udflugt, Ledsager ledsager) {
		ledsager.addUdflugt(udflugt);
	}

	public static void addUdflugterToLedsager(ArrayList<Udflugt> udflugter, Ledsager ledsager) {
		for (Udflugt udflugt : udflugter) {
			Controller.addUdflugtToLedsager(udflugt, ledsager);
		}
	}
	
	public static void updateUdflugterOnLedsager(ArrayList<Udflugt> udflugter, Ledsager ledsager) {
		for (Udflugt udflugt : ledsager.getUdlugter()) {
			if (!udflugter.contains(udflugt)) {
				Controller.removeUdflugtFromLedsager(udflugt, ledsager);
			}
		}
		
		for (Udflugt udflugt : udflugter) {
			if (!ledsager.getUdlugter().contains(udflugt)) {
				Controller.addUdflugterToLedsager(udflugter, ledsager);
			}
		}
	}

	public static void removeUdflugtFromLedsager(Udflugt udflugt, Ledsager ledsager) {
		ledsager.removeUdflugt(udflugt);
	}

	public static void updateLedsager(Ledsager ledsager, String navn) {
		ledsager.setNavn(navn);
	}

	// --------------------------

	public static Udflugt createUdflugt(Konference konference, String sted, LocalDateTime startTid, double pris,
			String beskrivelse) {
		Udflugt u1 = konference.createUdflugt(sted, startTid, pris, beskrivelse);
		return u1;
	}

	public static void deleteUdflugt(Konference konference, Udflugt udflugt) {
		konference.deleteUdflugt(udflugt);
	}

	public static void addLedsagerToUdflugt(Ledsager ledsager, Udflugt udflugt) {
		udflugt.addLedsager(ledsager);
	}

	public static void removeLedsagerToUdflugt(Ledsager ledsager, Udflugt udflugt) {
		udflugt.removeLedsager(ledsager);
	}

	public static void updateUdflug(Udflugt udflugt, String sted, LocalDateTime startTid, double pris,
			String beskrivelse) {
		udflugt.setSted(sted);
		udflugt.setStartTid(startTid);
		udflugt.setPris(pris);
		udflugt.setBeskrivelse(beskrivelse);
	}

	// --------------------------

	public static Foredrag createForedrag(Konference konference, String emne, LocalDateTime startTid, double varighed) {
		Foredrag f1 = konference.createForedrag(emne, startTid, varighed);
		return f1;
	}

	public static void deleteForedrag(Konference konference, Foredrag foredrag) {
		konference.deleteForedrag(foredrag);
	}

	public static void addForedragsholderToForedrag(Foredragsholder foredragsholder, Foredrag foredrag) {
		foredrag.setForedragsholder(foredragsholder);
	}

	public static void removeForedragsholderFromForedrag(Foredrag foredrag) {
		foredrag.setForedragsholder(null);
	}

	public static void updateForedrag(Foredrag foredrag, String emne, LocalDateTime startTid, double varighed,
			Foredragsholder foredragsholder) {
		foredrag.setEmne(emne);
		foredrag.setForedragsholder(foredragsholder);
		foredrag.setStartTid(startTid);
		foredrag.setVarighed(varighed);
	}

	// --------------------------

	public static TillægsService createTillægsService(Hotel hotel, String beskrivelse, double pris) {
		TillægsService t1 = hotel.createTillægsService(beskrivelse, pris);
		return t1;
	}

	public static void deleteTillægsService(TillægsService tillægsService, Hotel hotel) {
		hotel.deleteTillægsService(tillægsService);
	}

	public static void addTilmeldingToTillægsService(Tilmelding tilmelding, TillægsService tillægsService) {
		tillægsService.addTilmelding(tilmelding);
	}

	public static void removeTilmeldingFromTillægsService(Tilmelding tilmelding, TillægsService tillægsService) {
		tillægsService.removeTilmelding(tilmelding);
	}

	public static void updateTllægsService(TillægsService tillægsService, String beskrivelse, double pris) {
		tillægsService.setBeskrivelse(beskrivelse);
		tillægsService.setPris(pris);
	}

	// --------------------------

	public static double beregnSamletPris(Tilmelding tilmelding) {
		return tilmelding.beregnPris();
	}

	public static double beregnSamletPris(Konference konference, long dage, boolean foredragsholder, boolean ledsager,
			ArrayList<Udflugt> udflugter, Hotel hotel, ArrayList<TillægsService> tillægsServices) {
		double totalPris = 0;
		if (!foredragsholder) {
			totalPris += konference.getPris() * (1 + dage);
		}
		if (hotel != null) {
			if (!ledsager) {
				totalPris += hotel.getPrisDobbeltVærelse() * dage;
			} else {
				totalPris += hotel.getPrisEnkeltVærelse() * dage;
			}
			for (TillægsService tillægsService : tillægsServices) {
				totalPris += tillægsService.getPris() * dage;
			}
		}
		if (ledsager) {
			for (Udflugt udflugt : udflugter) {
				totalPris += udflugt.getPris();
			}
		}
		return totalPris;
	}

	public static String deltagerOversigt(Konference konference) {
		StringBuilder sb1 = new StringBuilder();
		for (Tilmelding t : konference.getTilmeldinger()) {
			sb1.append(t.getDeltager().getNavn() + " " + t.getDeltager().getAdresse() + " " + t.getDeltager().getTlfNr()
					+ " " + "(" + t.getDeltager().getClass().getSimpleName() + ")" + "\n");
		}
		return sb1.toString();
	}
	public static String udflugtOversigt(Konference konference) {
		StringBuilder sb2 = new StringBuilder();
		for (Udflugt u : konference.getUdflugter()) {
			sb2.append(u.getSted() + "\n");
			
			for (Ledsager l : u.getLedsagere()) {
				Deltager d = l.getTilmelding().getDeltager();
				sb2.append(" " + l.getNavn() + " (" + d.getNavn() + " tlf: " + d.getTlfNr() + ")\n");
			}
			sb2.append("\n");
		}
		return sb2.toString();
	}
	
	public static String hotelOversigt(Konference konference) {
		StringBuilder sb3 = new StringBuilder();
		for (Hotel h : konference.getHoteller()) {
			sb3.append(h.getNavn() + "\n");
			for (Tilmelding t : konference.getTilmeldinger()) {
				if (t.getHotel() == h) {
					sb3.append(" " + t.getDeltager().getNavn());
					if (t.getLedsager() != null) {
						sb3.append(" & " + t.getLedsager().getNavn());
					}
					sb3.append(
							"\n  Adresse: " + t.getDeltager().getAdresse() + " tlf: " + t.getDeltager().getTlfNr());
					if (!t.getTillægsServices().isEmpty()) {
						sb3.append("\n ");
					}
					for (TillægsService ts : t.getTillægsServices()) {
						sb3.append(" " + ts.getBeskrivelse());
					}
					sb3.append("\n");
				}
			}
			sb3.append("\n");
		}
		return sb3.toString();
	}
	
	public static LocalDateTime calcDateTime(int time, int minut, DatePicker dato) {
		LocalDateTime tid = null;
		int år = dato.getValue().getYear();
		int månede = dato.getValue().getMonthValue();
		int dag = dato.getValue().getDayOfMonth();

		tid = LocalDateTime.of(år, månede, dag, time, minut);

		return tid;
	}
	
	
	// -------------------------

	public static void initStorage() {
		Konference k1 = Controller.createKonference("Hav og Himmel", "Miljø konference omkring havet og himlen",
				LocalDateTime.of(2020, 11, 18, 6, 0), "Odense Universitet", 1500,
				LocalDateTime.of(2020, 11, 20, 23, 0));
		Controller.createKonference("Hav og Himmel2", "Miljø konference omkring havet og himlen",
				LocalDateTime.of(2020, 12, 21, 6, 0), "Odense Universitet", 1500,
				LocalDateTime.of(2020, 12, 23, 23, 0));

		Udflugt u1 = Controller.createUdflugt(k1, "Egeskov", LocalDateTime.of(2020, 11, 19, 8, 0), 75,
				"Vi skal se på dyr i Egeskov");
		Udflugt u2 = Controller.createUdflugt(k1, "Trapholt Museum,Kolding", LocalDateTime.of(2020, 11, 20, 10, 0), 200,
				"Der er trapper");
		Udflugt u3 = Controller.createUdflugt(k1, "Byrundtur, Odense", LocalDateTime.of(2020, 11, 18, 10, 0), 125,
				"Pub crawl");

		Hotel h1 = Controller.createHotel(1050, "Den Hvide Svane", "Det er hvidt som en svane", 1250);
		TillægsService ts1 = Controller.createTillægsService(h1, "WIFI", 50);
		Controller.addHotelToKonference(h1, k1);

		Deltager d1 = Controller.createDeltager("Finn Madsen", "Filler", "62", "637272");
		Controller.createTilmelding(LocalDate.of(2020, 11, 18), LocalDate.of(2020, 11, 20), d1, k1);

		Deltager d2 = Controller.createDeltager("Niels Petersen", "Filler", "62", "637272");
		Tilmelding t2 = Controller.createTilmelding(LocalDate.of(2020, 11, 18), LocalDate.of(2020, 11, 20), d2, k1);
		Controller.addHotelToTilmelding(h1, t2);
		Controller.addTilmeldingToKonference(t2, k1);

		Deltager d3 = Controller.createDeltager("Peter Sommer", "Filler", "62", "637272");
		Tilmelding t3 = Controller.createTilmelding(LocalDate.of(2020, 11, 18), LocalDate.of(2020, 11, 20), d3, k1);
		Ledsager l1 = Controller.createLedsager("Hanne Sommer", t3);
		Controller.addUdflugtToLedsager(u1, l1);
		Controller.addUdflugtToLedsager(u2, l1);
		Controller.addHotelToTilmelding(h1, t3);
		Controller.addTillægsServiceToTilmelding(ts1, t3);
		Controller.addTilmeldingToKonference(t3, k1);

		Deltager d4 = Controller.createForedragsholder("Lone Jensen", "Filler", "62", "637272", "Hav");
		Tilmelding t4 = Controller.createTilmelding(LocalDate.of(2020, 11, 18), LocalDate.of(2020, 11, 20), d4, k1);
		Ledsager l2 = Controller.createLedsager("Jan Madsen", t4);
		Controller.addUdflugtToLedsager(u3, l2);
		Controller.addUdflugtToLedsager(u1, l2);
		Controller.addHotelToTilmelding(h1, t4);
		Controller.addTillægsServiceToTilmelding(ts1, t4);
		Controller.addTilmeldingToKonference(t4, k1);
	}

	public static void init() {
		initStorage();
	}
}
