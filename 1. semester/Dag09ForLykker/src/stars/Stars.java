package stars;

public class Stars {
	final int MAX_ROWS = 10;

	public void starPicture() {
		for (int row = 1; row <= MAX_ROWS; row++) {
			for (int star = 1; star <= row; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void starPictureA() {
		for (int row = 10; row >= 0; row--) {
			for (int star = 1; star <= row; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void starPictureB() {
		for (int row = 1; row <= MAX_ROWS; row++) {
			for (int star = 10; star >= 1; star--) {
				if (star > row) {
					System.out.print(" ");
				}

				else {
					System.out.print("*");
				}

			}
			System.out.println();
		}
		System.out.println();
	}

	public void starPictureC() {
		for (int i = 1; i <= MAX_ROWS; i++) {
			for (int j = 1; j <= 10; j++)
			{
				if (i > j) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}


			}
			System.out.println();

		}
		// TODO
	}

	public void starPictureD() {
		// TODO
		for (int i = 1; i< MAX_ROWS+1; i++) {
			for (int j = 1; j <= 9; j ++) {
				if (i < 6) {
					if ( (MAX_ROWS)/2 - i < j && (MAX_ROWS)/2 + i > j) {
						System.out.print("*");
						//break;
						
					}
					else {
						System.out.print("-");
					}
				}
				else {
					// +5 is because the off set is moved from 1 to 6
					if ( -((MAX_ROWS)/2 - i) <= j && (MAX_ROWS+5 -i >= j)) {
						System.out.print("*");
						//break;
						
					}
					else {
						System.out.print("-");
					}
				}

			}
			System.out.println();
		}
	}

}
