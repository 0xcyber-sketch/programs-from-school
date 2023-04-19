package opgave03;

import java.time.LocalDate;
import java.util.ArrayList;



/***Modellererensvømmer*/
public class Svømmer {
	private String navn;
	private String klub;
	private LocalDate fødselsdag;
	private ArrayList<Double> tider;
	
	/***Initialiserer en ny svømmer med navn,fødselsdag,klub og tider.
	 *Pre: længden af tider er mindst 2
	 */
	public Svømmer(String navn, String klub, LocalDate fødselsdag, ArrayList<Double> tider) {
		this.navn = navn;
		this.klub = klub;
		this.fødselsdag = fødselsdag;
		this.tider = tider;
		
	}
	
	/***
	 * Returnerer svømmerens navn.
	 */
	public String getNavn() {
		return navn;
	}
	
	/***
	 * Returnerer svømmerens årgang.
	 */
	public int getÅrgang() {
//		return  LocalDate.now().getYear() - fødselsdag.getYear();
		return fødselsdag.getYear();
	}
	
	/***
	 * Returnerer svømmerens klub.
	 */
	public String getKlub() {
		return klub;
	}
	
	/***
	 * Registrerer svømmerens klub
	 * @param klub
	 */
	public void setKlub(String nyKlub) {
		klub = nyKlub;
	}
	
	/***
	 * Returnerer den hurtigste tidsvømmeren har opnået
	 * Pre: Der er registreret mindst to tider for svømmeren
	 */
	
	public double bedsteTid(){
		double min = Integer.MAX_VALUE;
		for (int i = 0; i < tider.size(); i++) {
			if (tider.get(i) < min) {
				min = tider.get(i);
			}
		}
		return min;
		}
	
	/***
	 * Returnerer gennemsnittet af de tider svømmeren har opnået*
	 *  Pre: Der er registreret mindst to tider for svømmeren
	 *  
	 */
	
	public double gennemsnitAfTid(){
		double sum = 0;
	    for (int i = 0; i < tider.size(); i++) {
	    	sum += tider.get(i);
	    }
	    return (double) sum/tider.size();
		
		}
	
	/***Returnerer gennemsnittet af de tider svømmeren har 
	 * *opnået idet den langsomste tid ikke er med regnet*
	 *  Pre: Der er registreret mindst to tider for svømmeren
	 *  */
	
	public double snitUdenDårligste() {
		double max = Integer.MIN_VALUE;
		
		for (int i = 0; i < tider.size(); i++) {
			if (tider.get(i) > max) {
				max = tider.get(i);
				
				
			}
		}
		int temp = tider.indexOf(max);
		tider.remove(temp);
		
		
		double sum = 0;
	    for (int i = 0; i < tider.size(); i++) {
	    	sum += tider.get(i);
	    }
	    return (double) sum/tider.size();
		}
	
	
	
	
	}
	
	
	
	
	
	
	