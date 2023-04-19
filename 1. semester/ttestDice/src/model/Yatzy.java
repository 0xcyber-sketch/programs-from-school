package model;

import java.util.Random;

public class Yatzy {
	// Face values of the 5 dice.
	// 1 <= values[i] <= 6.
	private int[] values = new int[5];

	// Number of times the 5 dice have been thrown.
	// 0 <= throwCount <= 3.
	private int throwCount = 0;

	// Random number generator.
	private Random random = new Random();

	public Yatzy() {
		//
	}

	/**
	 * Returns the 5 face values of the dice.
	 */
	public int[] getValues() {
		int temp[] = new int[5];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = values[i];
		}
		return temp;
	}

	/**
	 * Sets the 5 face values of the dice. Pre: values contains 5 face values in
	 * [1..6]. Note: This method is only meant to be used for test, and therefore
	 * has package visibility.
	 */
	void setValues(int[] values) {
		for (int i = 0; i < values.length; i++) {
			this.values[i] = values[i];
		}
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		this.throwCount = 0;
	}

	/**
	 * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
	 * boolean values.
	 */
	public void throwDice(boolean[] holds) {
		for (int i = 0; i < holds.length; i++) {
			int faceValue = random.nextInt(6) + 1; // Rolls a random number between 1 & 6.
			if (!holds[i]) {
				this.values[i] = faceValue;
			}
		}
		throwCount++;
	}

	// -------------------------------------------------------------------------

	/**
	 * Returns all results possible with the current face values. The order of the
	 * results is the same as on the score board. Note: This is an optional method.
	 * Comment this method out, if you don't want use it.
	 */
	public int[] getResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.sameValuePoints(i + 1);
		}
		results[6] = this.onePairPoints();
		results[7] = this.twoPairPoints();
		results[8] = this.threeSamePoints();
		results[9] = this.fourSamePoints();
		results[10] = this.fullHousePoints();
		results[11] = this.smallStraightPoints();
		results[12] = this.largeStraightPoints();
		results[13] = this.chancePoints();
		results[14] = this.yatzyPoints();

		return results;
	}

	// -------------------------------------------------------------------------

	// Returns an int[7] containing the frequency of face values.
	// Frequency at index v is the number of dice with the face value v, 1 <= v
	// <= 6.
	// Index 0 is not used.
	private int[] calcCounts() {
		int[] calcCounts = new int[7];
		for (int i = 1; i < calcCounts.length; i++) {
			for (int j = 0; j < values.length; j++) {
				if (values[j] == i) {
					calcCounts[i]++;
				}
			}
		}
		return calcCounts;
	}

	/**
	 * Returns same-value points for the given face value. Returns 0, if no dice has
	 * the given face value. Pre: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int sameValue = 0;
		for (int j = 0; j < values.length; j++) {
			if (values[j] == value) {
				sameValue += value;
			}
		}
		return sameValue;
	}

	/**
	 * Returns points for one pair (for the face value giving highest points).
	 * Returns 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		int maxValue = 0;
		int temp[] = this.calcCounts();
		for( int i = 1; i < temp.length; i++) {
			if (temp[i] > 1) {
				if (i * 2 > maxValue) {
					maxValue = i*2;
				}
			}
		}
		return maxValue;
	}

	/**
	 * Returns points for two pairs (for the 2 face values giving highest points).
	 * Returns 0, if there aren't 2 dice with one face value and 2 dice with a
	 * different face value.
	 */
	public int twoPairPoints() {
		int maxValue1 = 0;
		int maxValue2 = 0;
		int tempArray[] = this.calcCounts();
		for( int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] > 1 && tempArray[i] < 4) {
				int temp = i *2;
				if (temp > maxValue1) {
					maxValue1 = i*2;
				}
			}
		}
		for (int j = 1; j < tempArray.length; j++) {
			if (tempArray[j] > 1 && tempArray[j] < 4) {
				int temp = j*2;
				if (temp > maxValue2 && temp < maxValue1) {
					maxValue2 = temp;
				}
			}
		}
		if (maxValue1 == 0) {
			maxValue2 = 0;
		} else if (maxValue2 == 0) {
			maxValue1 = 0;
		}
		return maxValue1 + maxValue2;
	}

	/**
	 * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with the
	 * same face value.
	 */
	public int threeSamePoints() {
		int temp = 0;
		int tempArray[] = this.calcCounts();
		for( int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] >= 3) {
					temp = i*3;
			}
		}
		return temp;
	}

	/**
	 * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with the
	 * same face value.
	 */
	public int fourSamePoints() {
		int temp = 0;
		int tempArray[] = this.calcCounts();
		for( int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] >= 4) {
					temp = i*4;
			}
		}
		return temp;
	}

	/**
	 * Returns points for full house. Returns 0, if there aren't 3 dice with one
	 * face value and 2 dice a different face value.
	 */
	public int fullHousePoints() {
		int twoSame = 0;
		int threeSame = 0;
		int i = 1;
		int tempArray[] = this.calcCounts();
		while (i < tempArray.length && (twoSame == 0 || threeSame == 0)) {
			if (tempArray[i] == 2) {
				twoSame = i*2;
			}
			else if (tempArray[i] == 3) {
				threeSame = i*3;
			}
			i++;
		}
		if (twoSame == 0 ){
			threeSame = 0;
		} else if (threeSame == 0) {
			twoSame = 0;
		}
		return twoSame + threeSame;
	}

	/**
	 * Returns points for small straight. Returns 0, if the dice are not showing
	 * 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		int temp = 0;
		int tempArray[] = this.calcCounts();
		for (int i = 1; i < tempArray.length-1; i++) {
			if (tempArray[i] == 1) {
				temp += 1;
			}
		}
		if (temp == 5) {
			temp = 15;
		} else {
			temp = 0;
		}
		return temp;
	}

	/**
	 * Returns points for large straight. Returns 0, if the dice is not showing
	 * 2,3,4,5,6.
	 */
	public int largeStraightPoints() {
		int temp = 0;
		int tempArray[] = this.calcCounts();
		for (int i = 2; i < tempArray.length; i++) {
			if (tempArray[i] == 1) {
				temp += 1;
			}
		}
		if (temp == 5) {
			temp = 20;
		} else {
			temp = 0;
		}
		return temp;
	}

	/**
	 * Returns points for chance.
	 */
	public int chancePoints() {
		int temp = 0;
		for (int value : values) {
			temp += value;
		}
		return temp;
	}

	/**
	 * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
	 * face value.
	 */
	public int yatzyPoints() {
		int temp = 0;
		int tempArray[] = this.calcCounts();
		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i] == 5) {
				temp = 50;
			}
		}
		return temp;
	}

}
