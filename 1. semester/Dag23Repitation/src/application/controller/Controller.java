package application.controller;


import java.time.LocalDateTime;

import application.model.Arrangement;
import application.model.Område;
import application.model.Plads;
import application.model.Reservation;
import storage.Storage;

public class Controller {
	//Create, update, delete, add 
	
	/**
     * Creates a new Arrangmant.<br />
     */
    public static Arrangement createArrangement(String navn, boolean offentlig) {
    	Arrangement a = new Arrangement(navn, offentlig);
        Storage.addArragement(a);
        return a;
    }
    
    
    //---------- Plads---------------------
    public static Plads createPlads(int nr, Område område) {
    	Plads p = new Plads(nr, område);
    	Storage.addPlads(p);
    	return p;
    }
    
    public static void addPladsTilReservation(Reservation reservation, Plads plads) {
    	reservation.addPlads(plads);
    }
    
  //---------- Reservation---------------------
    public static Reservation createReservation(LocalDateTime start, LocalDateTime stop) {
    	Reservation r = new Reservation(start, stop);
    	Storage.addReservation(r);
    	return r;
    }
    
    public static void addReservationTilArrangement(Reservation reservation, Arrangement arrangement) {
    	arrangement.addReservation(reservation);
    }
    public static void addReservationTilPlads(Reservation reservation, Plads plads) {
    	plads.addReservation(reservation);
    }
    
//    public static void deleteArrangement(Arrangement a) {
//    	Storage.
//    }
	
    
    
	
	 /**
     * Initializes the storage with some objects.
     */
	public static void initStorage() {
		Plads p1 = createPlads(1, Område.TURNERING);
		Plads p2 = createPlads(2, Område.TURNERING);
		Plads p3 = createPlads(3, Område.STANDARD);
		Plads p4 = createPlads(4, Område.STANDARD);
		Plads p5 = createPlads(5, Område.BØRNE);
		Plads p6 = createPlads(6, Område.VIP);
		
		Arrangement a1 = createArrangement("Dota 2 tournament", true);
		Arrangement a2 = createArrangement("CS GO tournamen", false);
		
		Reservation r1 = new Reservation(LocalDateTime.of(2019, 8, 12, 20, 0), LocalDateTime.of(2019, 8, 12, 23, 0));
		Reservation r2 = new Reservation(LocalDateTime.of(2019, 8, 13, 19, 0), LocalDateTime.of(2019, 8, 14, 6, 0));
		Reservation r3 = new Reservation(LocalDateTime.of(2019, 8, 14, 19, 0), LocalDateTime.of(2019, 8, 15, 6, 0));
		
		addReservationTilArrangement(r1, a1);
		addPladsTilReservation(r1, p1);
		addPladsTilReservation(r1, p2);
		
		
		addPladsTilReservation(r2, p3);
		addPladsTilReservation(r2, p4);
		
		
		addPladsTilReservation(r3, p6);
		
		
		
		
		
	}
	
	public static void init() {
		initStorage();
	}

}
