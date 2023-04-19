package opgave02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave02 {

	public Opgave02() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//		File fileIn = new File("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\tal.txt");
		File fileIn = new File("C:\\Users\\Emil\\Desktop\\Datamatiker\\1. Semester\\PRO1\\TextFiler\\12-9-20\\tal.txt");
		Scanner scan = new Scanner(fileIn);
		
		while (scan.hasNext()) {
			System.out.println(scan.nextInt() * 2);
		}
		scan.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		
		
		

	}

}
