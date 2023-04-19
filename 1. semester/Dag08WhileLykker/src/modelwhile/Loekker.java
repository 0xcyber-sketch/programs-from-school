package modelwhile;

public class Loekker {
	public void udskriv1_10() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");

	}

	public void udskriv1_10_iteration() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}

	public int summer() {
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			sum = sum + i;
			i++;
		}
		return sum;

	}

	public int summer(int n) {
		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum = sum + i;
			i++;
		}
		return sum;

	}

	public int multiplum(int a, int b) {
		int resultat = 0;
		int i = 0;
		while (i < a) {
			resultat = resultat + b;
			i++;
		}
		return resultat;

	}

	public int summerEven() {
		// TODO Exercise E6.1a
		int i = 2;
		int sum = 0; 
		
		while (i <= 100) {
			sum += i;
			i += 2;
		}
		return sum;
	}

	public int summerSquare() {
		// TODO Exercise E6.1b
		int i = 1; 
		int sum = 0;
		
		while (i <= 100)
		{
			
			sum += this.multiplum(i, i);
			i++;
		
	}
		return sum;
	}

	public void allPowers() {
		// TODO Exercise E6.1c
		
		int i = 0;
		int out = 1;
		while (i <= 20) {
			System.out.println(out);
			out *= 2;
			i++;
		}
		
	}
	//a er starten af rangen og b er 
	public int sumOdd(int a, int b) {
		

		int sum = 0;
		while (a <= b) {
			if (a % 2 != 0) {
				sum +=a;
			}
			a++;
		}
		
		return sum;
	}

	public int sumOfOddDigits(int number) {
		int sum = 0;
		while (number > 0) {
			
			if (number % 10 % 2 != 0) {
				sum += number % 10;
			}
			number /= 10;
			
		}
		return sum;
	}
}
