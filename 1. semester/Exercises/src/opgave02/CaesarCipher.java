package opgave02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class CaesarCipher {

	public static void main(String[] args) throws FileNotFoundException {
		 final int DEFUALT_KEY = 3;
		 int key = DEFUALT_KEY;
//		 String inFile = "";
//		 String outFile = "";
//		 int files = 0; // Number of command line arguments that are files
//		 
//		 for (int i = 0; i < args.length; i++) {
//			String arg = args[i];
//			if (arg.charAt(0) == '-') {
//				// it is a command line option
//				
//				char option = arg.charAt(1);
//				if (option == 'd') {key = -key;}
//				else {usage(); return;}
//
//			}
//			else {
//				// it is a file name
//				
//				files++;
//				if (files == 1) {inFile = arg;}
//				else if (files == 2) {outFile = arg;}
//			}
//		}
//		if (files != 2) {usage(); return;}
//		
//		Scanner in = new Scanner(new File(inFile));
//		in.useDelimiter(""); //Process individual characters
//		PrintWriter out = new PrintWriter(outFile);
		 
		 String input;
			Scanner in = new Scanner(System.in);
		 
		
		while (in.hasNext()) {
			char from = in.next().charAt(0);
			char to = encrypt(from, key);
			System.out.println(to);
//			out.print(to);
		}
		in.close();
//		out.close();
		 
	}
	
	public static char encrypt(char ch, int key) {
		int base = 0;
		if ('A' <= ch && ch <= 'Z') {base = 'A';}
		else if ('a' <= ch && ch <= 'z') {base = 'a';}
		else { return ch;} // Not a letter
		int offset = ch - base + key;
		final int LETTERS = 26; // Number of letters in the Roman alphabet
		if (offset >= LETTERS) {offset = offset - LETTERS;}
		else if (offset < 0) {offset = offset + LETTERS;}
		return (char) (base + offset);
	
	}
	
	public static void usage() {
		System.out.println("Usages: java CaesarCipher [-d] infile outfilse");
	}

}
