package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import application.controller.Controller;
import application.model.Deltagelse;
import application.model.Fag;
import application.model.Lektion;
import application.model.Studerende;

public class TestApp {


	public static void main(String[] args) {
		Studerende s1 = Controller.createStuderende("Peter Hansen", "ph@stud.dk");
		Studerende s2 = Controller.createStuderende("Tina Jensen", "tj@stud.dk");
		Studerende s3 = Controller.createStuderende("Sascha Petersen", "sp@stud.dk");
		
		Studerende s4 = Controller.createStuderende("Mads Nord", "mn@stud.dk");

		Fag f1 = Controller.createFag("PRO1", "20S");
		Fag f2 = Controller.createFag("PRO1", "20T");
		Fag f3 = Controller.createFag("SU1", "20S");

		Lektion l1 = Controller.createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30), "A1.32");
		Lektion l2 = Controller.createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30), "A1.32");
		Lektion l3 = Controller.createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30), "A1.32");
		Lektion l4 = Controller.createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(10, 30), "A1.32");

		Controller.addLektionToFag(l1, f1);
		Controller.addLektionToFag(l2, f1);
		Controller.addLektionToFag(l3, f1);
		Controller.addLektionToFag(l4, f1);

		Controller.opretDeltagelser(f1, s1);
		Controller.opretDeltagelser(f1, s2);
		Controller.opretDeltagelser(f1, s3);
		Controller.opretDeltagelser(f1, s4);
		
		
		
		
		
		
		
		
		
		String[] omgængere =  {"Karl Lars", "Lone Madsen", "Sune Karl" };
		
		
		
		
		
		
		ArrayList<Studerende> list = Controller.studerendeTilObservation(3);
		
		Controller.fraværOmgængere(omgængere, list, "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\rep\\test3.txt");
		
	}

}
