package storage;

import java.util.ArrayList;

import application.model.Fag;
import application.model.Studerende;

public class Storage {

	private static ArrayList<Fag> fag= new ArrayList<>();
	private static ArrayList<Studerende> studerende = new ArrayList<>();
	
	public static ArrayList<Fag> getFag() {
		return new ArrayList<>(fag);
	}
	public static void addFag(Fag f) {
		fag.add(f);
	}
	
	
	public static ArrayList<Studerende> getStuderende() {
		return new ArrayList<>(studerende);
	}
	
	public static void addStuderende(Studerende s) {
		studerende.add(s);
	}
	
	
	

}
