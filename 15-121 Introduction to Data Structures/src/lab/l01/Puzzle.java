package lab.l01;

//Full Name: SungJu Cho
//Andrew ID: sungjuc
//Section: A
//Approximate Number Of Hours Spent On Assignment:
public class Puzzle {
	// Since this puzzle assumes 8 columns, colors can prepared only 6.
	private static int colors[][] = new int[][] { { 255, 0, 0 }, { 0, 255, 0 },
			{ 0, 0, 255 }, { 255, 255, 0 }, { 255, 0, 255 }, { 0, 255, 255 } };

	public static void main(String[] args) {
		setup(3);
		play();
	}

	public static void setup(int numRows) {
		// stores row and column numbers
		Grid.window(numRows, 8);
		Grid.setLineColor(0, 0, 0);

		// fills grid with arrows images and colors
		fillGrids(Grid.getNumRows(), Grid.getNumCols());

		// swaps colors 100 times.
		swapColors(100, Grid.getNumRows(), Grid.getNumCols());
	}

	public static void play() {
		int row;
		int col;
		int numMoves;

		numMoves = 0;

		while (!solved()) {
			Grid.setTitle("Column Puzzle:  " + numMoves + " moves");

			Draw.pauseUntilMouse();
			row = Grid.getMouseRow();
			col = Grid.getMouseCol();

			// checks the validity of row and column first
			if (Grid.isValid(row, col)) {
				if (col == 0) { // left arrow!
					slideLeft(row);
					numMoves++;
					continue;
				}
				if (col == Grid.getNumCols() - 1) { // right arrow!
					slideRight(row);
					numMoves++;
					continue;
				}
				boolean success = slideOneTile(row, col); // move tile
				if (success)
					numMoves++;
			}
		}

		Grid.setTitle("Column Puzzle:  " + numMoves + " moves");
		Grid.showMessageDialog("You solved the puzzle in " + numMoves
				+ " moves");
		System.exit(0);
	}

	public static boolean solved() {
		for (int i = 1; i < Grid.getNumCols() - 1; i++) {
			int red = 0;
			int green = 0;
			int blue = 0;

			for (int j = 0; j < Grid.getNumRows(); j++) {
				// no need to check empty space.
				if (isEmpty(j, i))
					continue;

				// if the color is not stored yet, just store the color and
				// continue.
				if (red == 0 && green == 0 && blue == 0) {
					red = Grid.getRed(j, i);
					green = Grid.getGreen(j, i);
					blue = Grid.getBlue(j, i);
					continue;
				}

				// if the color is not matched with the first row, just false;
				if (red != Grid.getRed(j, i) || green != Grid.getGreen(j, i)
						|| blue != Grid.getBlue(j, i))
					return false;
			} // iteration over row
		} // iteration over column
		// all things are correct.
		return true;
	}

	/**
	 * Shows arrow images in the rightmost and leftmost columns and fills
	 * colors. Picks a grid randomly and fills with black color.
	 * 
	 * @param numRows
	 *            the number of rows.
	 * @param numCols
	 *            the number of columns.
	 */
	private static void fillGrids(int numRows, int numCols) {
		for (int i = 0; i < numRows; i++) {
			// left arrow image load
			Grid.setImage(i, 0, "left.gif");
			// right arrow image load
			Grid.setImage(i, numCols - 1, "right.gif");

			// fill colors
			for (int j = 1; j < numCols - 1; j++) {
				Grid.setColor(i, j, colors[j - 1][0], colors[j - 1][1],
						colors[j - 1][2]);
			}
		}

		// set one of the color in black indicating empty.
		int row = randomRow(numRows);
		int col = randomCol(numCols);
		Grid.setColor(row, col, 0, 0, 0);
	}

	/**
	 * Swap colors for 100 times. This method pick up two random location in
	 * Grid and swap colors each other.
	 * 
	 * @param numSwaps
	 *            the number of swap.
	 * @param numRows
	 *            the number of rows.
	 * @param numCols
	 *            the number of columns.
	 */
	private static void swapColors(int numSwaps, int numRows, int numCols) {
		int loc1[] = new int[2];
		int loc2[] = new int[2];

		for (int i = 0; i < numSwaps; i++) {
			loc1[0] = randomRow(numRows);
			loc1[1] = randomCol(numCols);

			loc2[0] = randomRow(numRows);
			loc2[1] = randomCol(numCols);

			swapColor(loc1, loc2);
		}
	}

	/**
	 * Swaps colors.
	 * 
	 * @param loc1
	 *            the location array.
	 * @param loc2
	 *            the location array.
	 */
	private static void swapColor(int[] loc1, int[] loc2) {
		// stores color information in temporary variable.
		int tempRed = Grid.getRed(loc1[0], loc1[1]);
		int tempGreen = Grid.getGreen(loc1[0], loc1[1]);
		int tempBlue = Grid.getBlue(loc1[0], loc1[1]);

		// sets the color of the first location with the colors in second
		// location.
		Grid.setColor(loc1[0], loc1[1], Grid.getRed(loc2[0], loc2[1]), Grid
				.getGreen(loc2[0], loc2[1]), Grid.getBlue(loc2[0], loc2[1]));

		// sets the color of second location with temporary colors (the colors
		// in
		// first location).
		Grid.setColor(loc2[0], loc2[1], tempRed, tempGreen, tempBlue);
	}

	/**
	 * Returns random row.
	 * 
	 * @param numRows
	 *            the number of rows.
	 * @return the random row.
	 */
	private static int randomRow(int numRows) {
		return (int) (Math.random() * numRows);
	}

	/**
	 * Returns random column between 1 and maximum column - 1.
	 * 
	 * @param numRows
	 *            the number of columns.
	 * @return the random column.
	 */
	private static int randomCol(int numCols) {
		return (int) (Math.random() * (numCols - 2)) + 1;
	}

	/**
	 * Checks whether the location is empty or not.
	 * 
	 * @param row
	 *            the row number
	 * @param col
	 *            the column number
	 * @return true if the location is empty.
	 */
	private static boolean isEmpty(int row, int col) {
		// checks the row is valid.
		if (row < 0 || row > Grid.getNumRows())
			return false;
		// checks the col is valid.
		if (col < 1 || col > Grid.getNumCols() - 2)
			return false;
		// checks whether the row and column is valid.
		if (!Grid.isValid(row, col))
			return false;

		// checks the red color
		if (Grid.getRed(row, col) != 0)
			return false;
		// check the green color
		if (Grid.getGreen(row, col) != 0)
			return false;
		// checks the blue color
		if (Grid.getBlue(row, col) != 0)
			return false;

		// it is empty!
		return true;
	}

	/**
	 * Slides the tile at that location up or down one row, into an empty
	 * location. If the tile is not above or below an empty location, then this
	 * method should do nothing.
	 * 
	 * @param row
	 *            the row number
	 * @param col
	 *            the column number
	 * @return true if slide is done. Otherwise false.
	 */
	private static boolean slideOneTile(int row, int col) {
		// checks upper part is empty then swap it.
		if (isEmpty(row - 1, col)) {
			swapColor(new int[] { row, col }, new int[] { row - 1, col });
			return true;
		}

		// checks lower part is empty then swap it.
		if (isEmpty(row + 1, col)) {
			swapColor(new int[] { row, col }, new int[] { row + 1, col });
			return true;
		}

		// otherwise, just return false without
		return false;
	}

	/**
	 * Slides all the tiles in the given row to the left by one column. the left
	 * most tile moves to the right most.
	 * 
	 * @param row
	 *            the row number.
	 */
	private static void slideLeft(int row) {
		int red = Grid.getRed(row, 1);
		int green = Grid.getGreen(row, 1);
		int blue = Grid.getBlue(row, 1);
		int i;
		for (i = 2; i < Grid.getNumCols() - 1; i++) {
			Grid.setColor(row, i - 1, Grid.getRed(row, i), Grid
					.getGreen(row, i), Grid.getBlue(row, i));
		}
		Grid.setColor(row, i - 1, red, green, blue);
	}

	/**
	 * Slides all the tiles in the given row to the right by one column. the
	 * right most tile moves to the left most.
	 * 
	 * @param row
	 *            the row number.
	 */
	private static void slideRight(int row) {
		int red = Grid.getRed(row, Grid.getNumCols() - 2);
		int green = Grid.getGreen(row, Grid.getNumCols() - 2);
		int blue = Grid.getBlue(row, Grid.getNumCols() - 2);
		int i;
		for (i = Grid.getNumCols() - 3; i > 0; i--) {
			Grid.setColor(row, i + 1, Grid.getRed(row, i), Grid
					.getGreen(row, i), Grid.getBlue(row, i));
		}
		Grid.setColor(row, 1, red, green, blue);
	}

}