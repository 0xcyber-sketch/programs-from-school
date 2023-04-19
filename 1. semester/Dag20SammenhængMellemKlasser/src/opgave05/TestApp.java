package opgave05;
import java.util.ArrayList;
public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> cast = new ArrayList<>();
		ArrayList<String> ga1 = new ArrayList<>();
		ArrayList<String> ga2 = new ArrayList<>();
		ArrayList<String> ga3 = new ArrayList<>();
		
		//Cast names 
		String cN1 = "Emilo";
		String cN2 = "Ander";
		String cN3 = "Stutter";
		
		cast.add(cN1);
		cast.add(cN2);
		cast.add(cN3);
		
		
		//Guest actors 
		String gN1 = "Carl";
		String gN2 = "James";
		String gN3 = "Kurt";
		String gN4 = "Marie";
		String gN5 = "Trine";
		String gN6 = "Trunte";
		String gN7 = "Iffa";
		
		ga1.add(gN1);
		ga1.add(gN2);
		ga1.add(gN3);
		ga2.add(gN4);
		ga2.add(gN5);
		ga3.add(gN6);
		ga3.add(gN7);
		 
		
		
		Series s1 = new Series("Forgotten Ones", cast);

		
		s1.createEpisode(1, ga1, 65);
		s1.createEpisode(2, ga2, 40);
		s1.createEpisode(3, ga3, 54);
		
		System.out.println(s1.totalLength());
		
		System.out.println(s1.getGuestActors());
		

	}

}
