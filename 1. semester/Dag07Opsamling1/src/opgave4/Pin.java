package opgave4;
import java.util.Scanner;

public class Pin {

	private int pin;
	private boolean unlocked = true;
	private int attempt2 = 0;


	public Pin(int pin) {
		this.pin = pin;
	}

	public void run() {
		int attempt = 0;

		Scanner scan = new Scanner(System.in);
		int input; 

		while (unlocked) {
			input = scan.nextInt();
			if (attempt < 2 && unlocked ) 
			{
				if (input == pin) {
					System.out.println("Correct, welcome to your account!");
					scan.close();
					return ;

				}
				else 
				{
					System.out.println("Incorrect password");
					attempt++;
				}
			}
			else {
				System.out.println("Your bank account have been locked");
				unlocked = false;

			}

		}
		scan.close();
	}


	public void tryPin(int in) {


		if (unlocked && attempt2 < 2) {
			if (pin == in) {
				System.out.println("Correct, welcome to your account!");
			}
			else {


				System.out.println("Incorrect pin code");
				attempt2 += 1;
			}


		}
		else {
			System.out.println("Access denied");
			unlocked = false;


		}
	}



	//Recursion Stodder challenge
	@SuppressWarnings("resource")
	public int recursionPin(int inputattempts) {
		Scanner scan2 = new Scanner(System.in);
		int inputPin = 0;
		if (inputattempts > 0 && unlocked) {
			inputPin = scan2.nextInt();

			if (inputPin != this.pin)
			{
				
				if (inputattempts == 0) {
					unlocked = false;
				}


				//scan2.close();
				System.out.println("Wrong pin");
				return this.recursionPin(inputattempts - 1);

			}
			else {
				scan2.close();
				System.out.println( "Access granted!");
				return 1;
			}
		}

		else {
			scan2.close();
			System.out.println("Your account have been locked!");
			return 0;
		} 
	}
}




