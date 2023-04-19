package opgave07;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave07 {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\persons.txt";

		System.out.println(linFileSearchPerson(fileName, "Hansen"));
	}

	public static String linFileSearchPerson(String fileName, String target) {
		String result = "\"\"";
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			String currentString = scan.nextLine();

			boolean found = false;

			while (!found && scan.hasNext()) {
				int i = currentString.length() - 1;
				
				while (currentString.charAt(i) != ' ') {
					i--;
				}
				
				String tempString = currentString.substring(i + 1);
				if (target.equals(tempString)) {
					result = currentString;
					found = true;
				}
				else {
					 currentString = scan.nextLine();
				}

			}
			scan.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;

	}

}
