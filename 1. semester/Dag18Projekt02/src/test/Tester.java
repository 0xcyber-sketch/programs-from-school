package test;

public class Tester {
	private int[] values = new int[5];
	Tester () {
		
	}
	
	void setValues(int[] values) {
		// TODO
		for (int i = 0; i < values.length; i++) {
			this.values[i] = values[i];
		}
	}
	
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

	public int twoPairPoints() {
		int maxValue1 = 0;
		int maxValue2 = 0;
		for (int i = 1; i < calcCounts().length; i++) {
			if (calcCounts()[i] >= 2) {
				if (i * 2 > maxValue1) {
					maxValue1 = i * 2;

				}
			}
		}
		for (int i = 1; i < calcCounts().length; i++) {
			if (calcCounts()[i] >= 2) {
				if (i * 2 > maxValue2 && i * 2 < maxValue1) {
					maxValue2 = i * 2;

				}
			}
		}
		
//		if (maxValue2 == 0) {
//			maxValue1 = 0;
//		}
//		
//		if (maxValue1 == 0) {
//			maxValue2 = 0;
//		}

		return maxValue1 + maxValue2;
	}
}
