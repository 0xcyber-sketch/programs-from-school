package opgave07;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class E11_4 {

	public E11_4() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File filein = new File("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\Mary.txt");
            Scanner scan = new Scanner(filein);
            int count = 1; 
            
            String input;
            while (scan.hasNext()) {
            	input = scan.nextLine();
            	System.out.println("/* " + count + " */ " + input);
            	count++;
            }
            scan.close();

		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
