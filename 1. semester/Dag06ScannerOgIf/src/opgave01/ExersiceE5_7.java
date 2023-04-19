package opgave01;
import java.util.*;

public class ExersiceE5_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int numb1 = scan.nextInt();
		int numb2 = scan.nextInt();
		int numb3 = scan.nextInt();
		
		if (numb2 > numb1 && numb3 > numb2) {
			System.out.println("Number sequence is increasing");
			
		}
		
		else if (numb2 > numb1 || numb3 < numb2 ) {
			System.out.println("Number sequence is decreaseing");
		}
		
		else {
			System.out.println("Number sequence is neither increasing or decreaseing");
		}
		
		scan.close();
		
		

	}

}
