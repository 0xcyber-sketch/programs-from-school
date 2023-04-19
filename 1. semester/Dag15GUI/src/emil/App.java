package emil;
import java.util.ArrayList;
public class App {
	//Opgave 1
	public static void main(String[] args) {
		
		//1. 
		ArrayList<String> list = new ArrayList<String>() ;
		list.add("Ford");
		list.add("VW");
		list.add("Audi");
		list.add("Toyota");
		list.add("Mazda");
		list.add("Seat");
		
		//2 
		
		for (String car : list) {
			System.out.println(car);
		}
		System.out.println();
		
		// 3 
		
		list.add(3, "BMW");
		
		for (String car : list) {
			System.out.println(car);
		}
		System.out.println();
		
		//4 
		list.remove(2);
		for (String car : list) {
			System.out.println(car);
		}
		System.out.println();
		
		//5 
		System.out.println(list.get(2));
		System.out.println();
		
		
		// 6 
		
		list.add(0, "Renault");
		for (String car : list) {
			System.out.println(car);
		}
		System.out.println();
		
		// 7
		int amount = 0;
		for (String car : list) {
			amount += 1;
		}
		System.out.println(amount);
		System.out.println();
		
		
		// 8 
		int brands = 0;
		for (String cars : list) {
			if (cars.length() == 4) {
				System.out.println(cars);
				brands += 1;
			}
		}
		System.out.println(brands);
		System.out.println();
		
		// 9 
		
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0) {
				System.out.println(list.get(i));
			}
		}
		System.out.println();
		
		
		
		
		
		
	}
}
