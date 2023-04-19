package controller;

import java.util.ArrayList;

import model.Bestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

public class ControllerApp {


	public static void main(String[] args) {
		Controller.init();
		ArrayList<Kunde> kunder = Storage.getKunder();
		Kunde k1 = Storage.getKunder().get(1);
		System.out.println(k1);
//			for (Bestilling b : k1.getBestillinger()) {
//				
//				for (Plads p : b.getPladser()){
//					System.out.println(p);
//				}
//			}
		System.out.println(Controller.getKundesPladser(k1));
		
	System.out.println("What");
		
//		Controller.oversigtOverForestillinger("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\rep\\test2.txt");
		
	}

}
