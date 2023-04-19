package opgave4barchart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BarChart {
    private ArrayList<Integer> list = new ArrayList<>();
    private String[] array;

    public ArrayList<Integer> readValues() {
        System.out.println("Indtast nogle positive tal.  " + "Indtast et negativt tal for at afslutte: ");

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while (n >= 0) {
            list.add(n);
            n = in.nextInt();
        }
        return list;
    }
    
    public void getNames (ArrayList<Integer> list) {
    	array = new String[list.size()];
    	Scanner input = new Scanner(System.in);
    	System.out.println("What is the name of the chart?");
    	for (int i = 0; i < array.length; i++) {
    		
    		array[i] = input.nextLine();
    	}
    	    	
    }
    private void adjustName() {
    	int maxLength = Integer.MIN_VALUE;
    	
    	for (int i = 0; i < array.length; i++) {
    		
    		if (array[i].length() > maxLength) {
    			maxLength = array[i].length();}
		}
    	
    	
    	for (int i = 0; i < array.length; i++) {
			if (array[i].length() != maxLength) {
				int tempLen = maxLength - array[i].length();
				String tempS = "";
				for (int j = 0; j < tempLen ; j++) {
					tempS += " ";
				}
				
				array[i] = array[i] + tempS;
								
				
				}
			
		}
    }

    /**
     * Finds and returns the max value in the list.
     *
     * @param list
     *            the list with values.
     * @return the max value found.
     */
    public int findMax(ArrayList<Integer> list) {
        // TODO: find max in list
    	int max = Collections.max(list);
        return max;
    }

    /**
     * Prints out a BarChart of the values using the System.out.println method.
     */
    public void printBarChart() {
    	this.adjustName();
        int max = findMax(this.list);
        double scale = 40.0/max; 
        for (int i = 0; i < this.list.size(); i++) {
        	for (int j = 0; j < (this.list.get(i) * scale ); j++) {
        			if (j == 0) {
        				System.out.print("" + this.array[i]);
        				System.out.printf("%10s"," ");
        			}
        			System.out.print("*");
        		}
        	System.out.println();
        	}
        	
        }
        
    
}

