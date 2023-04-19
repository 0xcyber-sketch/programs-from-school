package test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
import application.model.TillægsService;
import application.model.Tilmelding;
import application.model.Udflugt;

public class TestApp {

	public static void main(String[] args) {
		
		Konference k1 = Controller.createKonference("HOH", "Filler", LocalDateTime.of(2020, 11, 18, 6, 0), "Odense Universitet", 1500, LocalDateTime.of(2020, 11, 20, 23, 0));
		Deltager d1 = Controller.createDeltager("Finn Madsen", "Filler", "62", "637272");
		
		Tilmelding t1 = Controller.createTilmelding(LocalDate.of(2020, 11, 18), LocalDate.of(2020, 11, 20), d1, k1);
				
		
		System.out.println(Controller.beregnSamletPris(t1));
		
		Deltager d2 = Controller.createDeltager("Niels Petersen", "Filler", "62", "637272");
		Hotel h1 = Controller.createHotel(1050, "Den Hvide Svane", "Filler", 1250);
		
		Tilmelding t2 = Controller.createTilmelding(LocalDate.of(2020, 11, 18), LocalDate.of(2020, 11, 20), d2, k1);
		Controller.addHotelToTilmelding(h1, t2);
		
		System.out.println(Controller.beregnSamletPris(t2));
		
		Deltager d3 = Controller.createDeltager("Peter Sommer", "Filler", "62", "637272");
		
		
		Tilmelding t3 = Controller.createTilmelding(LocalDate.of(2020, 11, 18), LocalDate.of(2020, 11, 20), d3, k1);
		Ledsager l1 = Controller.createLedsager("Hanne Sommer", t3);
		
		TillægsService ts1 = Controller.createTillægsService(h1, "WIFI", 50);
		
		Udflugt u1 = Controller.createUdflugt(k1, "Egeskov", LocalDateTime.of(2020, 11, 19, 8, 0), 75, "Filler");
		Udflugt u2 = Controller.createUdflugt(k1, "Trapholt Museum,Kolding", LocalDateTime.of(2020, 11, 20, 10, 0), 200, "Filler");
		
		Controller.addUdflugtToLedsager(u1, l1);
		Controller.addUdflugtToLedsager(u2, l1);
		
		Controller.addHotelToTilmelding(h1, t3);
		Controller.addTillægsServiceToTilmelding(ts1, t3);
		
		System.out.println(Controller.beregnSamletPris(t3));
		
		Deltager d4 = Controller.createForedragsholder("Lone Jensen", "Filler", "62", "637272", "Hav");
		Tilmelding t4 = Controller.createTilmelding(LocalDate.of(2020, 11, 18), LocalDate.of(2020, 11, 20), d4, k1);
		Ledsager l2 = Controller.createLedsager("Jan Madsen", t4);
		
		Udflugt u3 = Controller.createUdflugt(k1, "Byrundtur, Odense", LocalDateTime.of(2020, 11, 18, 10, 0), 125, "Filler");
		Controller.addUdflugtToLedsager(u3, l2);
		Controller.addUdflugtToLedsager(u1, l2);
		
		Controller.addHotelToTilmelding(h1, t4);
		Controller.addTillægsServiceToTilmelding(ts1, t4);
		
		System.out.println(Controller.beregnSamletPris(t4));
		
		
		System.out.println(k1.getTilmeldinger());
		
		

		

	}

}
