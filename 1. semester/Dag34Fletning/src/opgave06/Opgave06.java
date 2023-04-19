package opgave06;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave06 {

	public static void main(String[] args) {
		String fileName1 = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal5.txt";
		String fileName2 = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal6.txt";
		String fileNameNew = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal7.txt";

		findfællesTal(fileName1, fileName2, fileNameNew);

	}

	public static void findfællesTal(String fileName1, String fileName2, String fileNameNew) {
		try {
			File file = new File(fileName1);
			Scanner scan = new Scanner(file);
			File file2 = new File(fileName2);
			Scanner scan2 = new Scanner(file2);

			PrintWriter print = new PrintWriter(fileNameNew);

			int number1 = scan.nextInt();
			int number2 = scan2.nextInt();

			while (scan.hasNext() && scan.hasNext()) {
				if (number1 < number2) {
					number1 = scan.nextInt();

				} else if (number1 > number2){
					number2 = scan2.nextInt();
				}
				else {
					print.println(number1);
					number1 = scan.nextInt();
					number2 = scan2.nextInt();
				}
			}


			scan.close();
			scan2.close();
			print.flush();
			print.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
