package storage;

import java.util.ArrayList;

import model.Forestilling;
import model.Kunde;

public class Storage {

	private static ArrayList<Kunde> kunder = new ArrayList<>();
	private static ArrayList<Forestilling> forstilllinger = new ArrayList<>();
	
	public static void addKunder(Kunde k) {
		kunder.add(k);
	}
	
	public static ArrayList<Kunde> getKunder(){
		return new ArrayList<>(kunder);
	}
	public static void addForestillinger(Forestilling f) {
		forstilllinger.add(f);
	}
	
	public static ArrayList<Forestilling> getForstilllinger(){
		return new ArrayList<>(forstilllinger);
	}
}
