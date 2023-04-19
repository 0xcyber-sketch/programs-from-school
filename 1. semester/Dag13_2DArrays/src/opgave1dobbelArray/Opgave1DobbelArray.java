package opgave1dobbelArray;

public class Opgave1DobbelArray {

	public static void main(String[] args) {
		final int ROW = 8;
		final int COL = 8;
		int[][] values = new int[ROW][COL];
		DobbelArray da = new DobbelArray();

		//Udskriv values på tabel form
		da.udskrivArray(values);


		// TODO Opgave 1.1  lav ændringer i values så der står 5 på alle pladser
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				values[i][j] = 5;
			}


		}

		System.out.println();
		System.out.println("Nedenfor skulle der stå 5 på alle pladser");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.2  lav ændringer i values så der står 2 i lige rækker og 3 i ulige 
		for ( int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (i % 2 == 0) {
					values[i][j] = 2;
				}
				else {
					values[i][j] = 3;
				}
			}
		}

		System.out.println();
		System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden række");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.3  lav ændringer i values så der står 2 i lige søjler og 3 i ulige 

		for ( int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (j % 2 == 0) {
					values[i][j] = 2;
				}
				else {
					values[i][j] = 3;
				}
			}
		}

		System.out.println();
		System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden søjle");
		System.out.println();
		da.udskrivArray(values);


		// TODO Opgave 1.4 lav ændringer i values så den har skiftende 0'er og 1'er som på et
		// skakbræt
		
		for (int i = 0; i < ROW; i ++) {
			for (int j = 0; j < COL; j++) {
				values[i][j] = (i+j)%2;
			}
		}
		
//		for ( int i = 0; i < ROW; i++) {
//			if ( i % 2 == 0) { 
//				for (int j = 0; j < COL; j++) {
//					if (j % 2 == 0) {
//						values[i][j] = 0;
//					}
//					else {
//						values[i][j] =1 ;
//					}
//				}
//			}
//			else {
//				for (int j = 0; j < COL; j++) {
//					if (j % 2 != 0) {
//						values[i][j] = 0;
//					}
//					else {
//						values[i][j] = 1;
//					}
//
//
//				}
//			}
//		}

		System.out.println();
		System.out.println("Nedenfor skulle der stå 0 og 1 på alle pladser som på skakbræt");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.5 lav ændringer så alle elementer i nederste og øverste række samt første
		// og sidste søjle er 5 og resten skal være 2.
		
		for (int i = 0; i< ROW; i++ ) {
			for (int j = 0; j < COL; j++) {
				if (i == 0 || i == ROW-1 || j == 0 || j == COL -1) {
					values[i][j] = 5;
					
				} else  {
					values[i][j] = 2;
				}
			}
		}

		System.out.println();
		System.out.println("Nedenfor skulle der stå 5 i kanten og 2 ellers");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.6 beregn summen af alle tallene i values og udskriv denne.
		
		int sum = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				sum += values[i][j];
				
			}
		}
		System.out.println(sum);
	}

}
