package storage;

import java.util.ArrayList;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tilmelding;

public class Storage {
	private static ArrayList<Konference> konferencer = new ArrayList<>();
	private static ArrayList<Hotel> hoteller = new ArrayList<>();
	private static ArrayList<Deltager> deltagere = new ArrayList<>();
	private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

	// ----------------------------------------------
	
	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<>(konferencer);
	}

	public static void addKonference(Konference konference) {
		if (!konferencer.contains(konference)) {
			konferencer.add(konference);
		}
	}

	public static void removeKonference(Konference konference) {
		if (konferencer.contains(konference)) {
			konferencer.remove(konference);
		}

	}
	
	// ----------------------------------------------
	
	public static ArrayList<Hotel> getHoteller() {
		return new ArrayList<>(hoteller);
	}

	public static void addHotel(Hotel hotel) {
		if (!hoteller.contains(hotel)) {
			hoteller.add(hotel);
		}
	}

	public static void removeHotel(Hotel hotel) {
		if (hoteller.contains(hotel)) {
			hoteller.remove(hotel);
		}

	}

	// ----------------------------------------------
	
	public static ArrayList<Tilmelding> getTilmelding() {
		return new ArrayList<>(tilmeldinger);
	}
	
	public static void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
		}
	}
	
	public static void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding)) {
			tilmeldinger.remove(tilmelding);
		}
		
	}
	
	// ----------------------------------------------
	
	public static ArrayList<Deltager> getDeltagere() {
		return new ArrayList<>(deltagere);
	}

	public static void addDeltager(Deltager deltager) {
		if (!deltagere.contains(deltager)) {
			deltagere.add(deltager);
		}
	}

	public static void removeDeltager(Deltager deltager) {
		if (deltagere.contains(deltager)) {
			deltagere.remove(deltager);
		}
	}
}
