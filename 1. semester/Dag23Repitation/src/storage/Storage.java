package storage;

import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Plads;
import application.model.Reservation;

public class Storage {
	private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();
	private static final ArrayList<Reservation> reservationer = new ArrayList<>();
	private static final ArrayList<Plads> pladser = new ArrayList<>();
	
	
	
	//-----------------------------------------------
	public static ArrayList<Arrangement> getArrangementer() {
		return new ArrayList<>(arrangementer);
	}
	
	public static void addArragement(Arrangement arragement) {
		arrangementer.add(arragement);
	}
	
	
	//-----------------------------------------------
	public static ArrayList<Reservation> getReservationer() {
		return new ArrayList<>(reservationer);
	}
	
	public static void addReservation(Reservation reservation) {
		reservationer.add(reservation);
	}
	//-----------------------------------------------
	public static ArrayList<Plads> getPladser() {
		return new ArrayList<>(pladser);
	}
	
	public static void addPlads(Plads plads) {
		pladser.add(plads);
	}

}
