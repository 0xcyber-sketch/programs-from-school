package opgave03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave03 {

	public Opgave03() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> tal = new ArrayList<>();
		try {
		File fileIn = new File("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\tal.txt");
		Scanner scan = new Scanner(fileIn);
		
		while (scan.hasNext()) {
			tal.add(scan.nextInt());
		}
		
		scan.close();

		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		for (int i = tal.size() - 1; i >= 0; i--) {
			System.out.println(tal.get(i));
		}
		
		
		
		

	}

}
