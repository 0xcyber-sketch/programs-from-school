package opgave06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileUtill {

	public int max(String filename) throws IOException {
		File fileIn = new File(filename);
		Scanner scan = new Scanner(fileIn);
		int max = Integer.MIN_VALUE;
		while (scan.hasNext()) {
			
			int input = scan.nextInt();
			if (input > max) {
				max = input;
			}
			
		}
		scan.close();
		return max;
	}
	public int min(String filename) throws IOException {
		File fileIn = new File(filename);
		Scanner scan = new Scanner(fileIn);
		int min = Integer.MAX_VALUE;
		while (scan.hasNext()) {
			
			int input = scan.nextInt();
			if (input < min) {
				min = input;
			}
			
		}
		scan.close();
		return min;
	}
	public double average(String filename) throws IOException {
		File fileIn = new File(filename);
		Scanner scan = new Scanner(fileIn);
		double sum = 0;
		int counter = 0;
		while (scan.hasNext()) {
			int input = scan.nextInt();
			sum += input;
			counter++;
			
			
		}
		scan.close();
		return sum / counter;
	}
	
	
	
//	private int readFile(String fileName) throws IOEcxeption{
//		File fileIn = new File(fileName);
//		Scanner scan = new Scanner(fileIn);
//		int input = 
//		
//		
//		
//	}

}
