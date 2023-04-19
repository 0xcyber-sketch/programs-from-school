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
		// TODO
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
		// TODO
		for (int i = 0; i < values.length; i++) {
			this.values[i] = values[i];
		}
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		// TODO
		
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
	}

	/**
	 * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
	 * boolean values.
	 */
	public void throwDice(boolean[] holds) {
		// TODO
		int faceValue; // Get a random number from 1 - 6

		for (int i = 0; i < holds.length; i++) {
			faceValue = random.nextInt(6) + 1;
			if (holds[i] != true) {
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
		
		for (int i = 0; i < values.length; i++) {
			calcCounts[values[i]]++;
		}
		
		
//		for (int i = 1; i < calcCounts.length; i++) {
//			for (int j = 0; j < values.length; j++) {
//				if (values[j] == i) {
//					calcCounts[i]++;
//				}
//			}
//		}
		return calcCounts;
	}

	/**
	 * Returns same-value points for the given face value. Returns 0, if no dice has
	 * the given face value. Pre: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int temp = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == value) {
				temp += value;
			}

		}

		return temp;
	}

	/**
	 * Returns points for one pair (for the face value giving highest points).
	 * Returns 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		// TODO
		int maxValue = 0;
		for (int i = 1; i < calcCounts().length; i++) {
			if (calcCounts()[i] > 1) {
				if (i * 2 > maxValue) {
					maxValue = i * 2;
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
		for (int i = 1; i < calcCounts().length; i++) {
			if (calcCounts()[i] < 4 && 1 < calcCounts()[i]) {
				if (i * 2 > maxValue1) {
					maxValue1 = i * 2;

				}
			}
		}
		for (int i = 1; i < calcCounts().length; i++) {
			if (calcCounts()[i] < 4 && 1 < calcCounts()[i]) {
				if (i * 2 > maxValue2 && i * 2 < maxValue1) {
					maxValue2 = i * 2;

				}
			}
		}
		
		if (maxValue2 == 0) {
			maxValue1 = 0;
	}
	
		else if (maxValue1 == 0) {
		maxValue2 = 0;
	}

		return maxValue1 + maxValue2;
	}

	/**
	 * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with the
	 * same face value.
	 */
	public int threeSamePoints() {
		// TODO
		int temp = 0;
		for (int i = 1; i < calcCounts().length; i++) {
			if (calcCounts()[i] >= 3) {
				temp = i * 3;
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
		for (int i = 1; i < calcCounts().length; i++) {
			if (calcCounts()[i] >= 4) {
				temp = i * 4;
			}
		}
		return temp;
	}

	/**
	 * Returns points for full house. Returns 0, if there aren't 3 dice with one
	 * face value and 2 dice a different face value.
	 */
	public int fullHousePoints() {
		// TODO
		int i = 1;
		int twoALike = 0;
		int threeALike = 0;

		while (i < calcCounts().length && (threeALike == 0 || twoALike == 0)) {
			if (calcCounts()[i] == 3) {
				threeALike = i * 3;
			}
			if (calcCounts()[i] == 2) {
				twoALike = i * 2;
			}
			i++;
		}
		if (threeALike == 0) {
			twoALike = 0;

		} else if (twoALike == 0) {
			threeALike = 0;
		}

		return twoALike + threeALike;
	}

	/**
	 * Returns points for small straight. Returns 0, if the dice are not showing
	 * 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		int temp = 0;
		for (int i = 1; i < calcCounts().length - 1; i++) {
			if (calcCounts()[i] == 1) {
				temp += 1;
			}
		}
		if (temp == 5) {
			temp = 15;
		}
		else {
			temp = 0;
		}
		return temp;
	}

	/**
	 * Returns points for large straight. Returns 0, if the dice is not showing
	 * 2,3,4,5,6.
	 */
	public int largeStraightPoints() {
		// TODO
		int temp = 0;
		for (int i = 2; i < calcCounts().length; i++) {
			if (calcCounts()[i] == 1) {
				temp += 1;
			}
		}
		if (temp == 5) {
			temp = 20;
		}
		else {
			temp = 0;
		}
		return temp;
	}

	/**
	 * Returns points for chance.
	 */
	public int chancePoints() {
		int temp = 0;
		for (int i = 0; i < values.length; i++) {
			temp += values[i];
		}
		return temp;
	}

	/**
	 * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
	 * face value.
	 */
	public int yatzyPoints() {
		// TODO

		int temp = 0;
		int i = 1;

		while (i < calcCounts().length && temp != 50) {
			if (calcCounts()[i] == 5) {
				temp = 50;
			}
			i++;
		}

		return temp;
	}

}
