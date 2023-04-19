package opgaver;
import java.util.ArrayList;

public class MethodsArrayListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodsArrayList klasse = new MethodsArrayList();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		list.add(3);
		list.add(92);
		list.add(2);
		list.add(3);
		list.add(92);
		list.add(8);
		list.add(1);
		list.add(6);
		list.add(0);
		list.add(0);
		list.add(32);
		
		System.out.println(klasse.min(list));
		
		System.out.println(klasse.average(list));
		
		System.out.println(klasse.findZero(list));
		
		//klasse.swapEvenWithZero(list);
		//System.out.println(list);
		
		System.out.println(klasse.aEvenList(list));

		
		
		
		
	}

}
