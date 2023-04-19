package opgave07;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class E11_6 {


	public static void main(String[] args) {
		
		System.out.println("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\columns.txt");
		System.out.println("Which file?: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		scan.close();
		try {
            File filein = new File(fileName);
            scan = new Scanner(filein);
            int count = 0;
            double sum1 = 0;
            double sum2 = 0;
            while (scan.hasNext()) {
                System.out.println(scan.next());
                if (count % 2 == 0) {
                	sum1 += Double.parseDouble(scan.next().trim());
                }
                else {
                	sum2 += Double.parseDouble(scan.next().trim());

                }
                count ++;
            }
//            System.out.println(count);
            System.out.println("Average column 1: " + sum1 / (count/2));
            System.out.println("Average column 2: " + sum2 / (count/2));
            scan.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}

}
