package application.model;

import java.util.ArrayList;


public class Uddannelse {

	private String navn;
	private ArrayList<Hold> hold = new ArrayList<>();
	
	public Uddannelse(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}
	
	public ArrayList<Hold> getHold(){
		return new ArrayList<>(hold);
	}
	
	public Hold createHold(String betegnelse, String holdLeder){
		Hold h = new Hold(betegnelse, holdLeder, this);
		this.hold.add(h);
		return h;
	}
	
	public void addHold(Hold h) {
		if (hold.contains(h)) {
			hold.add(h);
		}
	}
	
	public ArrayList<String> tutorOversigt(){
		ArrayList<String> list = new ArrayList<>();
		for (Hold h : hold) {
			String str = "";
			for (Tutor t : h.getTutor()) {
				str = t.getNavn() + " " + this.navn + " " + h.getBetegnelse() + " " + t.getEmail() + " "
						+ h.getHoldLeder();
				list.add(str);
			}
		}
		return list;
	}

	@Override
	public String toString() {
		return navn;
	}
 
	
	

}
