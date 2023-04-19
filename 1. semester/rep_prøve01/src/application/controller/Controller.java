package application.controller;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import application.model.Arrangement;
import application.model.Hold;
import application.model.Tutor;
import application.model.Uddannelse;
import storage.Storage;
import java.util.ArrayList;

public class Controller {

	public static Uddannelse createUddannelse(String navn) {
		Uddannelse u = new Uddannelse(navn);
		Storage.addUddannelse(u);
		return u;

	}

	public static void addHoldToUddannelse(Hold h, Uddannelse u) {
		u.addHold(h);

	}

	public static Tutor createTutor(String navn, String email) {
		Tutor t = new Tutor(navn, email);
		Storage.addTutor(t);
		return t;
	}

	public static void addArrangementToTutor(Arrangement a, Tutor t) {
		boolean temp = t.getHold().harTidsoverlap(a);

		if (temp) {
			throw new RuntimeException ("Kan ikke tilføje arrangement til tutor");
		
	}
		else {
			t.addArrangement(a);
		}
	}
			
		

	public static Hold createHold(String betegnelse, String holdLeder, Uddannelse uddannelse) {
		Hold h = new Hold(betegnelse, holdLeder, uddannelse);
		return h;
	}

	public static void addTutorToHold(Tutor t, Hold h) {
		h.addTutor(t);
	}

	public static Arrangement createArrangement(LocalTime startTid, LocalTime slutTid, LocalDate date, String titel,
			double pris) {
		Arrangement a = new Arrangement(startTid, slutTid, date, titel, pris);
		Storage.addArrangementer(a);
		return a;
	}
	
	public static ArrayList<Hold> holdUdenTutorer(){
		ArrayList<Hold> list = new ArrayList<>();
		for (Uddannelse u : Storage.getUddannelser())
		{
			for (Hold h : u.getHold()) {
				if (h.getTutor().isEmpty()) {
					list.add(h);
				}
			}
		}
		return list;
	}

	public static void init() {
		Controller.initStorage();
	}
	public static void tutorOversigtTilFil(String filnavn) {
		ArrayList<String> list = new ArrayList<>();
		
		for (Uddannelse u : Storage.getUddannelser()) {
			for ( String s : u.tutorOversigt()) {
				if (!list.contains(s)) {
				list.add(s);
			}}
			
		}
		try {
			PrintWriter printWriter = new PrintWriter(filnavn);
			for (int i= 0; i < list.size(); i++ ) {
				System.out.println(list.get(i));
				printWriter.println(list.get(i));
			}
			printWriter.flush();
			printWriter.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Line 97");
		}
	}

	public static void initStorage() {
		Uddannelse u1 = Controller.createUddannelse("DMU");
		Uddannelse u2 = Controller.createUddannelse("FINØ");

		Hold h1 = u1.createHold("1dmE17S", "Margrethe Dybdahl");
		Hold h2 = u1.createHold("1dmE17T", "Kristian Dorland");
		Hold h3 = u1.createHold("1dmE17U", "Kell Ørhøj");
		Hold h4 = u2.createHold("1fiE17B", "Karen Jensen");
		
//		Hold h1 = Controller.createHold("1dmE17S", "Margrethe Dybdahl", u1);
//		Hold h2 = Controller.createHold("1dmE17T", "Kristian Dorland", u1);
//		Hold h3 = Controller.createHold("1dmE17U", "Kell Ørhøj", u1);
//		Hold h4 = Controller.createHold("1fiE17B", "Karen Jensen", u2);

		Tutor t1 = Controller.createTutor("Anders Hansen", "aaa@students.eaaa.dk");
		Tutor t2 = Controller.createTutor("Peter Jensen", "ppp@students.eaaa.dk");
		Tutor t3 = Controller.createTutor("Niels Madsen", "nnn@students.eaaa.dk");
		Tutor t4 = Controller.createTutor("Lone Andersen", "lll@students.eaaa.dk");
		Tutor t5 = Controller.createTutor("Mads Miller", "mmm@students.eaaa.dk");

		Arrangement a1 = Controller.createArrangement(LocalTime.of(18, 0), LocalTime.of(23, 30),
				LocalDate.of(2017, 8, 31), "Rusfest", 250);
		Arrangement a2 = Controller.createArrangement(LocalTime.of(14, 0), LocalTime.of(17, 30),
				LocalDate.of(2017, 8, 30), "Fodbold", 100);
		Arrangement a3 = Controller.createArrangement(LocalTime.of(12, 0), LocalTime.of(16, 30),
				LocalDate.of(2017, 8, 29), "Brætspil", 25);
		Arrangement a4 = Controller.createArrangement(LocalTime.of(18, 0), LocalTime.of(22, 0),
				LocalDate.of(2017, 8, 30), "Mindeparken", 25);

		Controller.addTutorToHold(t1, h1);
		Controller.addTutorToHold(t1, h1);
		Controller.addTutorToHold(t4, h1);
		Controller.addTutorToHold(t2, h3);
		Controller.addTutorToHold(t3, h3);
		Controller.addTutorToHold(t5, h4);

		Controller.addArrangementToTutor(a1, t1);
		Controller.addArrangementToTutor(a1, t2);
		Controller.addArrangementToTutor(a1, t5);
		Controller.addArrangementToTutor(a2, t3);
		Controller.addArrangementToTutor(a3, t3);
		Controller.addArrangementToTutor(a3, t4);
		Controller.addArrangementToTutor(a4, t1);
		Controller.addArrangementToTutor(a4, t5);
		
		
	}

}
