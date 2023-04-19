package opgave04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave04 {

	public static void main(String[] args) {
		System.out.println(linFileSearch(9, "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal.txt"));
		System.out.println(linFileSearch(44, "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal.txt"));

	}

	public static boolean linFileSearch(int target, String filename) {
		boolean result = false;
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);

			while (scan.hasNextInt() && !result) {
				if (target == scan.nextInt()) {
					result = true;
				}
			}
			scan.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
