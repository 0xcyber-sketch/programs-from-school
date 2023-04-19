package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
	private String navn;
	private LocalDate fraDato;
	private LocalDate tilDato;
	private final ArrayList<Job> jobs = new ArrayList<>();

	public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
		this.navn = navn;
		this.fraDato = fraDato;
		this.tilDato = tilDato;

	}

	public String getNavn() {
		return navn;
	}

	public LocalDate getFraDato() {
		return fraDato;
	}

	public LocalDate getTilDato() {
		return tilDato;
	}

	public ArrayList<Job> getJobs() {
		return new ArrayList<>(jobs);

	}

	public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
		Job job = new Job(kode, beskrivelse, dato, timeHonorar, antalTimer);
		jobs.add(job);
		return job;
	}

	public int budgetteretJobUdgift() {
		int sum = 0;
		for (Job j : getJobs()) {
			sum += (j.getTimeHonorar() * j.getAntalTimer());
		}
		return sum;
	}

	public int realiseretJobUdgift() {
		int sum = 0;
		for (Job j : getJobs()) {
			if (!j.getVagter().isEmpty()) {
				sum += (j.getTimeHonorar() * j.getAntalTimer());
			}
		}
		return sum;
	}
	
	public ArrayList<String> gaverTilFrivillige (){
		ArrayList<Frivillig> list = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		for (Job j : jobs) {
			for (Vagt v : j.getVagter()) {
				list.add(v.getFrivillig());
			}
		}
		
		bubbleSort(list);
		String temp = "";
		for (Frivillig f : list) {
			int gaver = 1;
			if (f instanceof FrivilligForening) {
				gaver = ((FrivilligForening) f).getAntalPersoner();
				temp = f.getNavn() + "\t\t" + gaver + "\t\t" + ((FrivilligForening) f).getForeningsNavn();
			} else {
				temp = f.getNavn() + "\t\t" + gaver; 
			}
			result.add(temp);
			
		}
		
		return result;
		
	}
	
	private  void swap(ArrayList<Frivillig> list, int i, int j) {
		Frivillig temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
		
	}
	
	private  void bubbleSort(ArrayList<Frivillig> list) {
		for (int i = list.size() -1 ; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				String navn1 = list.get(i).getNavn();
				String navn2 = list.get(j+1).getNavn();
				if (navn1.compareTo(navn2) > 0) {
					swap(list,j, j +1);
				}
			}
		}
	}
	
	public String toString() {
		return navn;
	}
	

}
