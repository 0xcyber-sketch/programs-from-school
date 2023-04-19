package afleveringfravaer;

import java.util.Arrays;

public class FravaersSystem {
	/**
	 * Fraværstallene udskrives på skærmen
	 *
	 * @param fravaer
	 */
	public void udskrivFravaer(int[][] fravaer) {
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				if (j == 0) {
					System.out.print("Elev " + (i + 1) + "| ");
				}
				System.out.print(fravaer[i][j] + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
	 * elevnr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public int samletFravaer(int[][] fravaer, int elevNr) {
		int[] samletFravær = new int[fravaer.length];
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				samletFravær[i] += fravaer[i][j];
			}
		}
		return samletFravær[elevNr - 1];
	}

	/**
	 * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
	 * elevNr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public double gennemsnit(int[][] fravaer, int elevNr) {
		double[] gennemsnitlifFravær = new double[fravaer.length];
		double tempSum = 0;
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				tempSum += fravaer[i][j];
			}
			gennemsnitlifFravær[i] = tempSum / fravaer[i].length;
			tempSum = 0;
		}
		return gennemsnitlifFravær[elevNr - 1];
	}

	/**
	 * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
	 *
	 * @param fravaer
	 * @return
	 */
	public int antalUdenFravaer(int[][] fravaer) {
		int tempSum = 0;
		int amount = 0;
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				tempSum += fravaer[i][j];
			}
			if (tempSum == 0) {
				amount += 1;
			}
			tempSum = 0;
		}
		return amount;
	}

	/**
	 * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
	 * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer for
	 * en af disse.
	 *
	 * @param fravaer
	 * @return
	 */
	public int mestFravaer(int[][] fravaer) {
		int[] samletFravær = new int[fravaer.length];
		int maxValue = Integer.MIN_VALUE;
		int elev = 1;

		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				samletFravær[i] += fravaer[i][j];
			}
		}

		for (int i = 0; i < samletFravær.length; i++) {
			if (samletFravær[i] > maxValue) {
				elev++;
				maxValue = samletFravær[i];
			}
		}
		return elev + 1;
	}

	/**
	 * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
	 * måneder.
	 *
	 * @param fravaer
	 * @param elevNr
	 */
	public void nulstil(int[][] fravaer, int elevNr) {
		for (int i = 0; i < fravaer.length; i++) {
			if (i == (elevNr - 1)) {
				for (int j = 0; j < fravaer[i].length; j++) {
					fravaer[i][j] = 0;
				}
			}
		}
	}
}
