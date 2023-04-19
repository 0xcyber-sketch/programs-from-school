package opgave4;

import java.util.Scanner;

public class PinApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pin pin = new Pin(1234);
		//pin.run();
		Scanner scan = new Scanner(System.in);
		/*pin.tryPin(scan.nextInt());
		pin.tryPin(scan.nextInt());
		pin.tryPin(scan.nextInt());
		pin.tryPin(scan.nextInt());*/
		System.out.println(pin.recursionPin(3));
	}

}
