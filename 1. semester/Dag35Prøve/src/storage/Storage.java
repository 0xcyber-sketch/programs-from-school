package storage;

import java.util.ArrayList;


import application.model.Festival;
import application.model.Frivillig;

public class Storage {

	private static ArrayList<Festival> festivaler = new ArrayList<>();
	private static ArrayList<Frivillig> frivillige = new ArrayList<>();

	
	public static ArrayList<Festival> getFestivaler(){
		return new ArrayList<>(festivaler);
	}
	
	public static void addFestival(Festival festival) {
		festivaler.add(festival);
	}
	
	
	
	public static ArrayList<Frivillig> getFrivillige(){
		return new ArrayList<>(frivillige);
	}
	
	public static void addFrivillig(Frivillig frivillig) {
		frivillige.add(frivillig);
	}
	
	
	
}
