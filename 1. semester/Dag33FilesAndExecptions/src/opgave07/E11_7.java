package opgave07;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class E11_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File filein = new File("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\rows.txt");
			Scanner scan = new Scanner(filein);

			while (scan.hasNext()) {
				String string = scan.nextLine();
				String tempString = "";

				double sum = 0;
				int count = 0;
				for (int i = 0; i < string.length(); i++) {
					if (Character.isDigit(string.charAt(i)) ) {
						tempString += string.substring(i, i + 1);
						if (i == string.length() - 1 || string.charAt(i+1) == ',') {
							count++;
							sum += Integer.parseInt(tempString);
							tempString = "";
						}

					} else  {
						sum += 0;}
			
							
						

					

				}

//				double sum = 0;
//				int count = 0;
//				for (int i = 0; i < string.length(); i++) {
//					int check = 1;
//					if (string.charAt(i) == ',') {
//						check = 0;
//						if (!tempString.isEmpty()) {
//							sum += Integer.parseInt(tempString);
//							count++;
//						}
//						tempString = "";
//
//					}
//					if (string.charAt(i) == ' ') {
//						sum += 0;
//						check = 0;
//					}
//					if (check > 0) {
//						tempString += string.substring(i, i + 1);
//						if (i == string.length() - 1 || string.charAt(i) == ',') {
//							sum += Integer.parseInt(tempString);
//							count++;
//						}
//
//					}
//					check++;
//
//				}

				if (sum == 0) {
					System.out.println(string + " Average: " + (sum));
				} else {
					System.out.println(string + " Average: " + (sum / count));
				}

			}
			scan.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
