package application.model;

import java.util.ArrayList;

public class Hotel {

	private double prisEnkeltVærelse;
	private String navn;
	private String adresse;
	private ArrayList<TillægsService> tillægsServices;
	private double prisDobbeltVærelse;
	
	public Hotel(double prisEnkeltVærelse, String navn, String adresse,  double prisDobbeltVærelse) {
		this.prisEnkeltVærelse = prisEnkeltVærelse;
		this.navn = navn;
		this.adresse = adresse;
		this.tillægsServices = new ArrayList<>();
		this.prisDobbeltVærelse = prisDobbeltVærelse;
	}
	
	public ArrayList<TillægsService> getTillægsServices() {
		return new ArrayList<>(tillægsServices);
	}
	
	public TillægsService createTillægsService(String beskrivelse, double pris) {
		TillægsService t1 = new TillægsService(beskrivelse, pris);
		tillægsServices.add(t1);
		return t1;
	}
	
	public void deleteTillægsService(TillægsService tillægsService) {
		if (tillægsServices.contains(tillægsService)) {
			tillægsServices.remove(tillægsService);
			for (Tilmelding tilmelding : tillægsService.getTilmeldinger()) {
				tilmelding.removeTilllægService(tillægsService);
			}
		}
		
		
	}

	public double getPrisEnkeltVærelse() {
		return prisEnkeltVærelse;
	}
	
	public void setPrisEnkeltVærelse(double prisEnkeltVærelse) {
		this.prisEnkeltVærelse = prisEnkeltVærelse;
	}
	
	public double getPrisDobbeltVærelse() {
		return prisDobbeltVærelse;
	}
	
	public void setPrisDobbeltVærelse(double prisDobbeltVærelse) {
		this.prisDobbeltVærelse = prisDobbeltVærelse;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}
	
	@Override
	public String toString() {
		return navn;
	}
}