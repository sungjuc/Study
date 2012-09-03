package lab.l03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/*
 * This class models a maze. It can read it from a file, identify
 * the start and finish, as well as the paths, and be viewed as a 
 * String, &c
 */
public class Maze {
	private boolean maze[][]; // 2D maze; true=path, false=wall

	// Start position
	private int start_row;
	private int start_col;

	// Finish position
	private int finish_row;
	private int finish_col;

	// Models a cell, or (row, col) pair within the maze. This is basically
	// here so that we can return both coordinates at once.
	public static class Cell {
		// The row and the column of some cell (path or wall) within the maze
		private int row;
		private int col;

		// Returns the column in which this cell lives
		public int getCol() {
			return col;
		}

		// Returns the row in which this cell lives
		public int getRow() {
			return row;
		}

		// "true" if two cells have the same (row, col) pair, "false" otherwise
		public boolean isEqual(Object obj) {
			Cell oCell = null;
			// Cast the object first.
			try {
				oCell = (Cell) obj;
			} catch (ClassCastException cce) {
				// If the cast is impossible, the object cannot equal to this
				// cell.
				return false;
			}
			if (this.row != oCell.row)
				return false;
			if (this.col != oCell.col)
				return false;
			return true;
		}

		// Returns String representation of a Cell.
		public String toString() {
			return "(" + row + "," + col + ")";
		}

		// A very simple constructor
		public Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	// This gets thrown if we detect a corrupt input file
	public class InvalidMazeFileException extends Exception {
		private int lineNum; // The current line (what we just read) of input

		// Returns the current line of the input file
		public int getLineNumber() {
			return lineNum;
		}

		// String representation of the exception: basically, the line number
		public String toString() {
			String s = super.toString();
			s = s + " at line: " + lineNum;
			return s;
		}

		// A very simple constructor
		public InvalidMazeFileException(String message, int lineNumber) {
			super(message);
			this.lineNum = lineNumber;
		}
	}

	// This class modesl the maze: a 2D array containing walls and paths
	public Maze(String filename) throws InvalidMazeFileException {
		int lineNum = 0;
		int numCols = 0;
		int numRows = 0;

		finish_col = -1;
		finish_row = -1;

		BufferedReader mazeFile = null;

		StringTokenizer lineTokenizer = null;
		String token = null;
		String line = null;

		try {
			mazeFile = new BufferedReader(new FileReader(filename));
			while (lineNum < 4) {
				lineNum++;

				line = mazeFile.readLine();
				lineTokenizer = new StringTokenizer(line);

				token = lineTokenizer.nextToken();

				if (token.equalsIgnoreCase("Rows:")) {
					numRows = Integer.parseInt(lineTokenizer.nextToken());
				} else if (token.equalsIgnoreCase("Cols:")) {
					numCols = Integer.parseInt(lineTokenizer.nextToken());
				} else if (token.equalsIgnoreCase("Start:")) {
					lineTokenizer = new StringTokenizer(line, "(,)");
					lineTokenizer.nextToken();

					start_row = Integer.parseInt(lineTokenizer.nextToken());
					start_col = Integer.parseInt(lineTokenizer.nextToken());
				} else if (token.equalsIgnoreCase("Finish:")) {
					lineTokenizer = new StringTokenizer(line, "(,)");
					lineTokenizer.nextToken();

					finish_row = Integer.parseInt(lineTokenizer.nextToken());
					finish_col = Integer.parseInt(lineTokenizer.nextToken());
				} else {
					throw new InvalidMazeFileException("Invalid Maze File",
							lineNum);
				}
			}

			if ((numRows <= 0) || (numCols <= 0)) {
				throw new InvalidMazeFileException("Invalid Maze File", lineNum);
			}

			maze = new boolean[numRows][numCols];
			for (int row = 0; row < numRows; row++) {
				for (int col = 0; col < numCols; col++) {
					maze[row][col] = false;
				}
			}

			// Read in each line of the file
			int row, col;
			lineNum++;

			while ((line = mazeFile.readLine()) != null) {
				// Ignore empty lines
				if (!line.equals("")) {
					// Get the row and column out of the line
					lineTokenizer = new StringTokenizer(line, "(,)");
					row = Integer.parseInt(lineTokenizer.nextToken());
					col = Integer.parseInt(lineTokenizer.nextToken());

					maze[row][col] = true;
				}

				lineNum++;
			}
		} catch (Exception e) {
			throw new InvalidMazeFileException("Invalid Maze File", lineNum);
		}
	}

	// Returns the coordinates of the finish block
	public Cell getFinish() {
		return new Cell(this.finish_row, this.finish_col);
	}

	// Returns the coordinates of the start block
	public Cell getStart() {
		return new Cell(this.start_row, this.start_col);
	}

	// "true" if the cell contains the coordinates of "finish", false otherwise
	// Note: Returns false if out of bounds
	public boolean isFinish(Cell cell) {
		if (cell.getCol() != this.finish_col)
			return false;
		if (cell.getRow() != this.finish_row)
			return false;
		return true;
	}

	// "true" if the cell contains is a path (not a wall), false otherwise
	// Note: Returns false if out of bounds
	// Note: paths are "true", walls are "false" within the maze array
	public boolean isPath(Cell cell) {
		int row = cell.getRow();
		int col = cell.getCol();
		if (row < 0 || row > maze.length - 1 || col < 0
				|| col > maze[0].length - 1)
			return false;
		return maze[row][col];
	}

	// "true" if the cell contains the coordinates of "start", false otherwise
	// Note: Returns false if out of bounds
	public boolean isStart(Cell cell) {
		if (cell.getCol() != this.start_col)
			return false;
		if (cell.getRow() != this.start_row)
			return false;
		return true;
	}

	// Make a String representation of the Maze. X for wall, space for path,
	// S for start, F for finish.
	// See the assignment documentation for sample output
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Cell tempCell;

		sb.append("  ");
		for (int col = 0; col < maze[0].length; col++)
			sb.append(col);
		sb.append("\n");

		for (int row = 0; row < maze.length; row++) {
			sb.append(row + " ");
			for (int col = 0; col < maze[0].length; col++) {
				if (maze[row][col]) {
					tempCell = new Cell(row, col);
					if (isFinish(tempCell)) {
						sb.append("F");
						continue;
					}
					if (isStart(tempCell)) {
						sb.append("S");
						continue;
					}
					sb.append(" ");
				} else {
					sb.append("X");
				}
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	// Used by the constructor to add a path
	private void makePath(int row, int col) {
		// if (row, col) is not within the maze, do nothing
		if ((row < 0) || (row >= maze.length) || (col < 0)
				|| (col >= maze[0].length)) {
			return;
		}

		maze[row][col] = true;
	}
}
