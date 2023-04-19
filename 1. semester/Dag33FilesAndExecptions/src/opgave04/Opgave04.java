package opgave04;

import java.io.IOException;
import java.io.PrintWriter;

public class Opgave04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			String fileName = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-9-20\\tal2.txt"; 
			PrintWriter printWriter = new PrintWriter(fileName);
			
			for (int i = 0; i <= 100; i++) {
				if (i % 2 != 0) {
					printWriter.println(i);
				}
			}
			printWriter.flush();
			printWriter.close();
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
