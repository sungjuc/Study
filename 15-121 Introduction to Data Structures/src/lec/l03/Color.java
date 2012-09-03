package lec.l03;

public class Color {
	private int red;
	private int green;
	private int blue;

	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	int getRed() {
		return this.red;
	}

	int getGreen() {
		return this.green;
	}

	int getBlue() {
		return this.blue;
	}

	boolean equals(Color other) {
		if (other.red != this.red)
			return false;

		if (other.green != this.green)
			return false;

		if (other.blue != this.blue)
			return false;

		return true;
	}
}
