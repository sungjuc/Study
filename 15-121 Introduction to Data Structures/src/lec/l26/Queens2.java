package lec.l26;

import java.awt.*;

public class Queens2 {
	private static Grid display;

	public static void main(String[] args) {
		int n = 12;

		boolean[][] board = init(n);

		solve(board);
	}

	public static boolean solve(boolean[][] board) {
		return solve(board, 0);
	}

	// precondition: no queens are already attacking each other
	// col is first empty column
	// tries to place queens on col through end so that non-attacking
	private static boolean solve(boolean[][] board, int col) {
		if (col == board.length)
			return true;
		else {
			for (int row = 0; row < board.length; row++) {
				board[row][col] = true;
				updateDisplay(board, display, row, col);

				if (isSafe(board, row, col, -1, -1)
						&& isSafe(board, row, col, 0, -1)
						&& isSafe(board, row, col, 1, -1)
						&& solve(board, col + 1))
					return true;
				board[row][col] = false;
				updateDisplay(board, display, row, col);
			}
			return false;
		}
	}

	private static boolean isSafe(boolean[][] board, int row, int col,
			int deltaRow, int deltaCol) {
		row += deltaRow;
		col += deltaCol;
		while (row >= 0 && row < board.length && col >= 0 && col < board.length) {
			if (board[row][col])
				return false;
			row += deltaRow;
			col += deltaCol;
		}
		return true;
	}

	// returns empty n-by-n board, and creates display
	private static boolean[][] init(int n) {
		boolean[][] board = new boolean[n][n];
		display = new Grid(n, n);
		display.setTitle(n + " Queens");
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if ((row + col) % 2 == 0)
					display.setColor(row, col, new Color(250, 200, 160));
				else
					display.setColor(row, col, new Color(210, 140, 70));
			}
		}

		return board;
	}

	private static void updateDisplay(boolean[][] board, Grid display, int row,
			int col) {
		if (board[row][col])
			display.setImage(row, col, "queen.gif");
		else
			display.setImage(row, col, null);
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
	}
}