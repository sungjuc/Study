package lec.l03;

public class Location {
	private int row;
	private int col;

	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}

	int getRow() {
		return this.row;
	}

	int getCol() {
		return this.col;
	}

	boolean equals(Location other) {
		if (other.row != this.row)
			return false;

		if (other.col != this.col)
			return false;

		return true;
	}
}
