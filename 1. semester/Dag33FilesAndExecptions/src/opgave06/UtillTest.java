package opgave06;

import java.io.IOException;
import java.util.Scanner;

public class UtillTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			System.out.println("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\tal5.txt"); // For copy paste sake haha
			System.out.println("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\tal6.txt"); // For copy paste sake haha
			FileUtill f = new FileUtill();
			Scanner scan = new Scanner(System.in);
			String file = scan.next();
	
			
			System.out.println(f.min(file));
			System.out.println(f.max(file));
			System.out.println(f.average(file));
			 
			scan.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
