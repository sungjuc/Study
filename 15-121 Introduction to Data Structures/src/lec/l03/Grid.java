package lec.l03;

public class Grid {
	private Color[][] colors;

	public Grid(int numRows, int numCols) {
		this.colors = new Color[numRows][numCols];
	}

	public Grid(String imageFileName) {

	}

	int getNumRows() {
		return this.colors.length;
	}

	int getNumCols() {
		return this.colors[0].length;
	}

	Color getColor(Location loc) {
		return this.colors[loc.getRow()][loc.getCol()];
	}

	void setColor(Location loc, Color color) {
		this.colors[loc.getRow()][loc.getCol()] = color;
	}

	void load(String imageFileName) {

	}

	public static void onlyRed(Grid g) {
		for (int row = 0; row < g.getNumRows(); row++) {
			for (int col = 0; col < g.getNumCols(); col++) {
				Location loc = new Location(row, col);
				int red = g.getColor(loc).getRed();
				g.setColor(loc, new Color(red, 0, 0));
			}
		}
	}

	public static int brightness(Color c) {
		return (c.getRed() + c.getGreen() + c.getBlue()) / 3;
	}

	public static void grayScale(Grid g) {
		for (int row = 0; row < g.getNumRows(); row++) {
			for (int col = 0; col < g.getNumCols(); col++) {
				Location loc = new Location(row, col);
				int b = brightness(g.getColor(loc));
				g.setColor(loc, new Color(b, b, b));
			}
		}
	}
}
