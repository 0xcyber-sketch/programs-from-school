package opgave01;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Measurable chilis[] = new Measurable[5];
		ArrayList<Measurable> chiliss = new ArrayList<>();
		int n = 1;
		for(int i = 0; i < 4; i++) {
			Chili c = new Chili("" + (n+i), 2);
			chiliss.add(c);
		}
		
		
		chilis[0] = new Chili("dog", 2543);
		chilis[1] = new Chili("trick", 20);
		chilis[2] = new Chili("ghost", 9982);
		chilis[3] = new Chili("peper", 276);
		chilis[4] = new Chili("snow", 2098);
		
		System.out.println(Data.max(chilis));
		System.out.println(Data.avg(chilis));
		System.out.println();
		
		System.out.println(Data.avg(chiliss));
		

		
		
		
		
		

	}

}
