package application;

import java.time.LocalDate;

import application.controller.Controller;
import application.model.Festival;
import application.model.Frivillig;
import application.model.FrivilligForening;
import application.model.Job;

public class Test {
	public static void main(String[] args) {

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
	
		Controller.tagVagt(j1, f1, 3);
	}

}
