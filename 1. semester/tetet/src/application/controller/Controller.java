package application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import application.model.Deltagelse;
import application.model.DeltagerStatus;
import application.model.Fag;
import application.model.Lektion;
import application.model.Studerende;
import storage.Storage;

public class Controller {

	public static Studerende createStuderende(String navn, String email) {
		Studerende s = new Studerende(navn, email);
		Storage.addStuderende(s);
		return s;
	}

	public static ArrayList<Studerende> getStuderende() {
		return Storage.getStuderende();

	}

	public static Fag createFag(String navn, String klasse) {
		Fag f = new Fag(navn, klasse);
		Storage.addFag(f);
		return f;
	}

	public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale) {
		Lektion l = new Lektion(dato, startTid, lokale);
		return l;
	}

	public static void addLektionToFag(Lektion l, Fag f) {
		f.addLektion(l);
	}

	public static void opretDeltagelser(Fag f, Studerende s) {
		ArrayList<Lektion> lektioner = f.getLektioner();
		for (int i = 0; i < lektioner.size(); i++) {
			lektioner.get(i).createDeltagelse(s);
		}

	}
	
	public static void updateDeltagelse(Deltagelse d, DeltagerStatus status, boolean registret ) {
		d.setStatus(status);
		d.setRegistreret(registret);
	}
	


	public static ArrayList<Studerende> studerendeTilObservation(int grænse) {
		ArrayList<Studerende> fraværsElver = new ArrayList<>();
		for (Studerende s : getStuderende()) {
			if (s.antalFraværsLektioner() > grænse) {
				fraværsElver.add(s);
			}
		}
		
		insertioneSort(fraværsElver);
		
		return fraværsElver;
		

	}
	
	private static void insertioneSort(ArrayList<Studerende> list) {
		for (int i = 1; i < list.size(); i++) {
			Studerende next = list.get(i);
			int j = i;
			boolean found = false;
			while (!found && j > 0) {
				if (next.compareTo(list.get(j - 1)) > 0) {
					found = true;
				} else {
					list.set(j, list.get(j - 1));
					j--;
				}
			}
			list.set(j, next);

		}
	}
	
	public static void fraværOmgængere(String[] omgængere, ArrayList<Studerende> megetFravær, String filnavn) {
		
		int i1 = 0;
		int i2 = 0;
		String outputString = "";
		
		try {
			PrintWriter printWriter = new PrintWriter(filnavn);
		while (i1 < omgængere.length && i2 < megetFravær.size()) {
			if (omgængere[i1].compareTo(megetFravær.get(i2).getNavn()) <= 0) {
				outputString = omgængere[i1] + " " + "omgænger";
				printWriter.println(outputString);
				i1++;
			} else {
				outputString = megetFravær.get(i2) + " " + "fravær: " + megetFravær.get(i2).antalFraværsLektioner();
				printWriter.println(outputString);
				i2++;
			}
		}
		while (i1 < omgængere.length) {
			outputString = omgængere[i1] + " " + "omgænger";
			printWriter.println(outputString);
			i1++;
		}
		while (i2 < megetFravær.size()) {
			outputString = megetFravær.get(i2) + " " + "fravær: " + megetFravær.get(i2).antalFraværsLektioner();
			printWriter.println(outputString);
			i2++;
		}
		
		printWriter.flush();
		printWriter.close();
		
	}
	
	catch (IOException e) {
		System.out.println(e.getMessage());
	}
	}

	public static void init() {
		initStorage();
	}

	public static void initStorage() {
		Studerende s1 = createStuderende("Peter Hansen", "ph@stud.dk");
		Studerende s2 = createStuderende("Tina Jensen", "tj@stud.dk");
		Studerende s3 = createStuderende("Sascha Petersen", "sp@stud.dk");

		Fag f1 = createFag("PRO1", "20S");
		Fag f2 = createFag("PRO1", "20T");
		Fag f3 = createFag("SU1", "20S");

		Lektion l1 = createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30), "A1.32");
		Lektion l2 = createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30), "A1.32");
		Lektion l3 = createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30), "A1.32");
		Lektion l4 = createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(10, 30), "A1.32");

		addLektionToFag(l1, f1);
		addLektionToFag(l2, f1);
		addLektionToFag(l3, f1);
		addLektionToFag(l4, f1);

		opretDeltagelser(f1, s1);
		opretDeltagelser(f1, s2);
		opretDeltagelser(f1, s3);
		
		
		
		
	}

}
