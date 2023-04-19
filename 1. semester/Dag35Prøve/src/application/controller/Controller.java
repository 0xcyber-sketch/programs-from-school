package application.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Festival;
import application.model.Frivillig;
import application.model.FrivilligForening;
import application.model.Job;
import application.model.Vagt;
import storage.Storage;

public class Controller {
	
	public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato) {
		Festival festival = new Festival(navn, fraDato, tilDato);
		Storage.addFestival(festival);
		return festival;
	}
	
	public static Frivillig createFrivilig(String navn, String mobil, int maksAntalTimer) {
		Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);
		Storage.addFrivillig(frivillig);
		return frivillig;
	}
	
	public static FrivilligForening createFrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner) {
		FrivilligForening frivilligForening = new FrivilligForening(navn, mobil, maksAntalTimer, foreningsNavn, antalPersoner);
		Storage.addFrivillig(frivilligForening);
		return frivilligForening;
	}
	
	public static Vagt tagVagt(Job job, Frivillig frivillig, int timer){
		Vagt v1 = job.createVagt(timer);
		try {
			if (frivillig.ledigeTimer() >= job.ikkeBesatteTimer() ) {
			v1.setFrivillig(frivillig);
		}
		}
		catch (RuntimeException e) {
			e.getMessage();
		}
		return v1;
	}
	
	public static boolean findFrivillig(Festival festival, String navn) {
		ArrayList<String> list = festival.gaverTilFrivillige();
		boolean found = false;
		int left = 0;
		int right = list.size() - 1;
		int middle = -1;
		
		while (!found && left <= right) {
			middle = (left + right) / 2;
			String k = list.get(middle);
			if (k.equals(navn)) {
				found = true;
			}
			else if (k.compareTo(navn) > 0) {
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
			
		}
		
		return found;
	}

	public static void initStorage() {
		Festival festival = Controller.createFestival("Northside", LocalDate.of(2020, 6, 4), LocalDate.of(2020, 6, 6));
		
		Frivillig f1 = Controller.createFrivilig("Jane Jensen", "12345677", 20);
		Frivillig f2 = Controller.createFrivilig("Lone Hansens", "78787878", 25);
		Frivillig f3 = Controller.createFrivilig("Anders Mikkelsen", "55555555", 10);
		
		
		FrivilligForening fe1 = Controller.createFrivilligForening("Christian Madsen", "23232323", 100, "Erhvervsakademi Aarhus", 40);
		
		Job j1 = festival.createJob("T1", "Rengøring af toilet", LocalDate.of(2020, 6, 4), 100, 5);
		Job j2 = festival.createJob("T2", "Rengøring af toilet", LocalDate.of(2020, 6, 4), 100, 5);
		Job j3 = festival.createJob("T3", "Rengøring af toilet", LocalDate.of(2020, 6, 4), 100, 5);
		Job j4 = festival.createJob("T4", "Rengøring af toilet", LocalDate.of(2020, 6, 5), 100, 5);
		Job j5 = festival.createJob("T5", "Rengøring af toilet", LocalDate.of(2020, 6, 5), 100, 5);
		Job j6 = festival.createJob("T6", "Rengøring af toilet", LocalDate.of(2020, 6, 5), 100, 5);
		Job j7 = festival.createJob("T7", "Rengøring af toilet", LocalDate.of(2020, 6, 6), 100, 5);
		Job j8 = festival.createJob("T8", "Rengøring af toilet", LocalDate.of(2020, 6, 6), 100, 5);
		Job j9 = festival.createJob("T9", "Rengøring af toilet", LocalDate.of(2020, 6, 6), 100, 5);
		
	}

	public static void init() {
		initStorage();
	}

}
