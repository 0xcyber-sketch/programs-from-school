package opgave08;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave08 {

	
	public static void main(String[] args) {
		String fileName1 = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal2.txt";
		String fileName2 = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal3.txt";
		String fileNameNew = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal4.txt";
	
		
		fletAlleHelTal(fileName1, fileName2, fileNameNew);

	}
	
	public static void fletAlleHelTal(String fileName1, String fileName2, String fileNameNew) {
		try {
			File file = new File(fileName1);
			Scanner scan = new Scanner(file);
			File file2 = new File(fileName2);
			Scanner scan2 = new Scanner(file2);
			
			PrintWriter print = new PrintWriter(fileNameNew);
			
			
			int number1 = scan.nextInt();
			int number2 = scan2.nextInt();

			while (scan.hasNextInt() && scan2.hasNextInt()) {
				if (number1 <= number2) {
					print.println(number1);
					number1 = scan.nextInt();
				}
				else {
					print.println(number2);
					number2 = scan2.nextInt();
				}
			}
			
			while (scan.hasNextInt()) {
				print.println(number1);
				number1 = scan.nextInt();
			}
			while (scan2.hasNextInt()) {
				print.println(number2);
				number2 = scan2.nextInt();
			}
			
			scan.close();
			scan2.close();
			print.flush();
			print.close();
			
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
