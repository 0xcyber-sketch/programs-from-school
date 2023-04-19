package soegningelevopgaver;

import java.util.ArrayList;
import java.util.Collections;

public class Soegning {

	public boolean findUlige(int[] tabel) {
		// TODO Opgave1
		boolean temp = false;
		int i = 0;
		while (temp == false && tabel.length > i) {
			int k = tabel[i];
			if (k % 2 != 0) {
				temp = true;
			}
			i++;
		}

		return temp;
	}

	// her skriver du metoder til opgaverne 2,3,5,6 og 7

	// opgave 2
	public int linearSearchTenToFifteen(int[] tabel, int lowest, int highest) {
		int index = -1;
		int i = 0;

		while (index == -1 && i < tabel.length) {
			int k = tabel[i];
			if (k >= lowest && k <= highest) {
				index = k;
			}
			else {
			i++;
			}

		}
		return index;
	}

	// opgave 3
	public boolean linearSearchTwoInARow(int[] tabel) {
		int i = 0;
		boolean temp = false;

		while (temp == false && i < tabel.length - 1) {
			int k = tabel[i];
			if (k == tabel[i + 1]) {
				temp = true;
			}
			i++;

		}
		return temp;
	}
	// opgave 5

	public int linearSearchTaskFive(int n) {
		int i = 0;
		int temp = 0;
		boolean found = false;

		while (i <= n && !found) {
			if (i * i <= n && n < (i + 1) * (i + 1)) {
				temp = i;
				found = true;
			}
			i++;
		}
		return temp;
	}

	public int binarySearchTaskFive(int n) {
		int left = 0;
		int temp = -1;
		int right = n;
		int middle = -1;

		while (temp == -1 && left <= right) {
			middle = (right + left) / 2;
			if (middle * middle <= n && n < (middle + 1) * (middle + 1)) {
				temp = middle;
			} else if (middle * middle > n && n < (middle + 1) * (middle + 1)) {

				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return temp;
	}

	public int find(ArrayList<Integer> list, int n) {
		int index = -1;
		int i = 0;

		while (i < list.size() && index == -1) {
			int k = list.get(i);
			if (i == 0 || i == (list.size() - 1)) {
				if (k == n) {
					index = list.indexOf(k);
				}
			} else {

				if (k == n) {
					index = list.indexOf(list.get(i - 1));
					Collections.swap(list, i, index);
					
				}
			}
			i++;
		}
		return index;

	}

}