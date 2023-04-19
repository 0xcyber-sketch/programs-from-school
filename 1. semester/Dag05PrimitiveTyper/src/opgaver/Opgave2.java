package opgaver;

public class Opgave2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String ord1 = "Datamatiker";
		String ord2 = "Uddannelsen"
				+ "";
		
		//opgave A 
		System.out.println(ord1.toUpperCase());
		
		//Opgave B
		System.out.println(ord2.toLowerCase());
		
		//Opgave C
		System.out.println(ord1 + " " + ord2);
		
		//Opgave D
		String ord3 = ord1.toUpperCase() +  ord2.toLowerCase();
		System.out.println(ord3);
		
		//Opgave E 
		System.out.println(ord3.length());
		
		//opg f 
		System.out.println(ord1.substring(0,7));
		
		// opg h 
		System.out.println(ord2.substring(2,7));
		
		// opg h
		System.out.println(ord3.substring((ord3.length()/2)));
		
		System.out.println(ord3.lastIndexOf("M"));
		
		

	}
	
	

}
