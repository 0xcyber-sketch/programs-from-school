package storage;

import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Tutor;
import application.model.Uddannelse;

public class Storage {
	private static ArrayList<Uddannelse> uddannelser = new ArrayList<>();
	private static ArrayList<Tutor> tutorer = new ArrayList<>();
	private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
	
	
	public static void  addTutor(Tutor t){
		tutorer.add(t);
	}
	
	public static ArrayList<Tutor> getTutorer(){
		return new ArrayList<>(tutorer);
	}
	public static void  addArrangementer(Arrangement a){
		arrangementer.add(a);
	}
	
	public static ArrayList<Arrangement> getArrangementer(){
		return new ArrayList<>(arrangementer);
	}
	public static void  addUddannelse(Uddannelse u){
		uddannelser.add(u);
	}
	
	public static ArrayList<Uddannelse> getUddannelser(){
		return new ArrayList<>(uddannelser);
	}

}
