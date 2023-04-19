package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        // TODO Opgave 4.1
    	Spiller spiller = null;
    	int i = 0; 
    	while (spiller == null && i < spillere.size()) {
    		Spiller k = spillere.get(i);
    		if (k.getMaal() == score) {
    			spiller = k;
    		}
    		else {
    			i++;
    		}
    	}
        return spiller;
    }
    
    public Spiller findScorebinær(ArrayList<Spiller> spillere, int score) {
        // TODO Opgave 4.2
    	Spiller spiller = null;
    	int left = 0;
    	int right = spillere.size() - 1;
    	int middle = -1;
    	while (spiller == null && left <= right) {
    		middle = (left + right)/2;
    		Spiller k = spillere.get(middle);
    		if (k.getMaal() == score) {
    			spiller = k;
    		}
    		else if (k.getMaal() < score) {
    			right = middle -1; 
    		}
    		else {
    			left = middle + 1;
    		}
    	}
        return spiller;
    }
    
    public String findBedste(ArrayList<Spiller> spillere) {
        // TODO Opgave 4.3
    	String temp = "";
    	int i = 0; 
    	while (temp.isEmpty() && i < spillere.size()) {
    		if (spillere.get(i).getHoejde() < 170 && spillere.get(i).getMaal() > 50) {
    			temp = spillere.get(i).getNavn();
    		}
    		i++;
    	}
        return temp;
    }

    // Her tilføjes metoder der løser opgve 4.2 og 4.3

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

        // Tilføj kode der afprøver opgaver 4.2 og 4.3
        System.out.println();
        ArrayList<Spiller> spillerListe2 = new ArrayList<>();
        spillerListe2.add(new Spiller("Hans", 196, 99, 60));
        spillerListe2.add(new Spiller("Bo", 203, 89, 47));
        spillerListe2.add(new Spiller("Jens", 188, 109, 45));
        spillerListe2.add(new Spiller("Finn", 194, 102, 32));
        spillerListe2.add(new Spiller("Lars", 192, 86, 21));
        spillerListe2.add(new Spiller("Mads", 200, 103, 12));

        System.out.println("Spiller der har scoret 21 mål: " + metoder.findScorebinær(spillerListe2, 21));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScorebinær(spillerListe2, 30));
        
        System.out.println();
        ArrayList<Spiller> spillerListe3 = new ArrayList<>();
        spillerListe3.add(new Spiller("Hans", 196, 99, 60));
        spillerListe3.add(new Spiller("Bo", 203, 89, 47));
        spillerListe3.add(new Spiller("Jens", 188, 109, 45));
        spillerListe3.add(new Spiller("Finn", 194, 102, 32));
        spillerListe3.add(new Spiller("Lars", 192, 86, 21));
        spillerListe3.add(new Spiller("Mads", 200, 103, 12));
        spillerListe3.add(new Spiller("Mads L", 169, 103, 51));
        spillerListe3.add(new Spiller("Casten", 168, 103, 52));

        System.out.println("Spiller:" + metoder.findBedste(spillerListe3));  
        }
    
    

}
