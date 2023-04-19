package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

public class Controller {

	public static Forestilling createForestilling(String navn, LocalDate startDate, LocalDate slutDate) {
		Forestilling f = new Forestilling(navn, startDate, slutDate);
		Storage.addForestillinger(f);
		return f;
	}

	public static Kunde createKunde(String navn, String mobil) {
		Kunde k = new Kunde(navn, mobil);
		Storage.addKunder(k);
		return k;
	}
	
	public static Plads createPlads(int række, int nr, int pris){
		Plads p = new Plads(række, nr, pris);
		return p;
		
	}

	public static void init() {
		initStorage();
	}

	public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato,
			ArrayList<Plads> pladser) {
		
		int i = 0; 
		boolean check = false; 
		while (i < pladser.size() && !check) {
			Plads p = pladser.get(i);
			if (forestilling.erPladsLedig(p.getRække(), p.getRække(), dato)) {
				i++;
			}
			else {
				check = true;
			}
		}
		Bestilling b = null;
		if (!check) {
			 b = forestilling.createBestilling(dato, kunde);
			 b.setKunde(kunde);
			 for (int e = 0; e < pladser.size(); e++) {
				 b.addPlads(pladser.get(e));
			 }
			 
		}
	
		else {
			throw new RuntimeException( "FEJL");
		}
		

		return b;
	}
	
	public static void oversigtOverForestillinger(String filnavn) {
		try {
			PrintWriter print = new PrintWriter(filnavn);
			
			for (Forestilling f : Storage.getForstilllinger()) {
				print.println(f.getNavn());
			}
			print.flush();
			print.close();
			
		}
		catch (IOException e) {
			e.getMessage();
		}
	}
	
	//Lavet efter de fire timer
	public static ArrayList<Plads> getKundesPladser(Kunde kunde){
		ArrayList<Plads> pladser = new ArrayList<>();
		try {
		for (Bestilling b : kunde.getBestillinger()) {
			for (Plads p : b.getPladser()) {
				if (b.getKunde().equals(kunde)) {
					pladser.add(p);
				}
			}
		}}
		catch (NullPointerException e) {
			System.out.println("null");
		}
		return pladser;
	}

	public static void initStorage() {
		Forestilling f1 = createForestilling("Evita", LocalDate.of(2019, 1, 10), LocalDate.of(2019, 1, 20));
		Forestilling f2 = createForestilling("Lykke Per", LocalDate.of(2019, 2, 1), LocalDate.of(2019, 2, 10));
		Forestilling f3 = createForestilling("Chess", LocalDate.of(2019, 1, 21), LocalDate.of(2019, 1, 30));

		Kunde k1 = createKunde("Ander Hansen", "11223344");
		Kunde k2 = createKunde("Peter Jensen", "12345678");
		Kunde k3 = createKunde("Niels Madsen", "12341234");
		
		int pris = 100;
		Plads p1 = createPlads(10, 10, pris);
		Plads p2 = createPlads(10, 11, pris);
		
		ArrayList<Plads> pladser = new ArrayList<>();
		pladser.add(p1);
		pladser.add(p2); 
		
		
		Bestilling b1 = opretBestillingMedPladser(f1, k1, LocalDate.of(2019, 1, 15), pladser);
		System.out.println(b1.getPladser());
		

	}

}
