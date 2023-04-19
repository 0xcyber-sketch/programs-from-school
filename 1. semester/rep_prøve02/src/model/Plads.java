package model;

public class Plads {
	@Override
	public String toString() {
		return "Plads [række=" + række + ", nr=" + nr + ", pris=" + pris + "]";
	}

	private int række;
	private int nr;
	private int pris;

	public Plads(int række, int nr, int pris) {
		this.række = række;
		this.nr = nr;
		this.pris = pris;
	}

	public int getRække() {
		return række;
	}

	public int getNr() {
		return nr;
	}

	public int getPris() {
		return pris;
	}

}
