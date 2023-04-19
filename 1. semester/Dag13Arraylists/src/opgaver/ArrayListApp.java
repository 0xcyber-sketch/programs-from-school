package opgaver;
import java.util.ArrayList;

// Opgave a) 
public class ArrayListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//opg 1
		ArrayList<String> list;
		list = new ArrayList<String>();
		
		//opg 2
		list.add("Hans");
		list.add("Viggo");
		list.add("Jens");
		list.add("Børge");
		list.add("Bent");
		
		//opg 3
		
		System.out.println(list.size());
		// opg 4 
		
		list.add(2, "Jane");
		
		// opg 5
		
		
		for ( String navn : list) {
			System.out.println(navn);
		}
		
		//opg 6
		list.remove(1);
		
		//opg 7
		list.add(0, "Pia");
		
		//opg 8
		list.add("Ib");
		
		// opg 9
		System.out.println(list.size());
		
		// opg 10
		list.set(2, "Hansi");
		
		// opg 11
		System.out.println(list.size());
		
		// opg 12
		for ( String navn : list) {
			System.out.println(navn);
		}
		// opg 13
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + " Har " + list.get(i).length() + " tegn");
		}
		
		
		// opg 14
		for ( String navn : list) {
			System.out.println(navn + " Har " + navn.length() + " tegn");
		}
		
		
		
		
		
		
		
		
		

	}

}
