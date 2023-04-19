package test;

import java.io.IOException;
import java.io.PrintWriter;

public class Julefeber {

	public static void main(String[] args) {
		try {
		String name = "C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\12-10-20\\tal8.txt";
		PrintWriter print = new PrintWriter(name);
		
		print.println(Integer.MIN_VALUE);
		print.println(0);
		print.println(Integer.MAX_VALUE);
		print.flush();
		print.close();
		}
		catch (IOException e) {System.out.println(e.getMessage());
			
		}
		
	}

}
