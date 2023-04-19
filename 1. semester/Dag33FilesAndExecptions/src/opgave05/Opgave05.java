package opgave05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave05 {

	public Opgave05() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	try {
		String fileName = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\tal3.txt"; 
		PrintWriter printWriter = new PrintWriter(fileName);
		Scanner scan = new Scanner(System.in);
		
		int input = 0;
		while (input != -1) {
		input = scan.nextInt();
		if (input >= 0 ) {
			printWriter.println(input);
		}
		}
		printWriter.flush();
		printWriter.close();
		scan.close();
		
		
	}
	catch (IOException e) {
		System.out.println(e.getMessage());
	}

	}

}
