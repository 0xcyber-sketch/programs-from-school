package opgave5;

public class Primtal {

	private int n;




	public Primtal(int input) {
		this.n = input;
	}
	//TODO 
	public void calculate() {
		int m; //Divide by two to do the first factor
		int check = 0;
		


		for (int i = 2; i <= n+1; i++) {
			check = 0;
			m = i/2;
			for (int j = 2; j <= m; j++) {
				if (i % j == 0) {
					check = 1;
				}
			}
			
			if (check == 0 ) {
				System.out.println(i);
			}
			
		}
			
		
		
		
		
	}
}
		
		

		