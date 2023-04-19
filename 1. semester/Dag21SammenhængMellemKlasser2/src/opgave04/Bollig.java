package opgave04;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bollig {
	private int kvm;
	private String adresse;
	private int prisPrMåned;
	
	private Kollegie kollegie;
	private final ArrayList<LejeAftale> lejeAftaler= new ArrayList<>();
	
	public Bollig (int kvm, String adresse, int pris) {
		this.kvm = kvm;
		this.adresse = adresse;
		prisPrMåned = pris;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getPrisPrMåned() {
		return prisPrMåned;
	}

	public void setPrisPrMåned(int prisPrMåned) {
		this.prisPrMåned = prisPrMåned;
	}

	public int getKvm() {
		return kvm;
	}
	
	public void setKollegie(Kollegie kollegie) {
		if (this.kollegie != kollegie) {
			Kollegie oldKollegie = this.kollegie;
			if (oldKollegie != null) {
				oldKollegie.removeBollig(this);
			}
			this.kollegie = kollegie;
			if (kollegie != null) {
				kollegie.addBollig(this);
			}
		}
	}
	
	public Kollegie getKollegie() {
		return this.kollegie;
	}
	
	public ArrayList<LejeAftale> getLejeAftaler(){
		return new ArrayList<>(lejeAftaler);
	}
	
	public LejeAftale createLejeAftale(LocalDate fraDato) {
		LejeAftale l = new LejeAftale(fraDato, this);
		lejeAftaler.add(l);
		return  l;
		}
	
	
	public void removeLejeAftale(LejeAftale lejeAftale) {
		if (lejeAftaler.contains(lejeAftale)) {
			lejeAftaler.remove(lejeAftale);

		}
	}
	
	
	
	
	
	

}
