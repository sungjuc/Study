/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	int moveUpCount;
	int moveCount;

	public void run() {
		moveUpCount = 0;
		moveCount = 0;
		while (true) {
			horizontalMove();
			if (!moveUp()) {
				break;
			}
		}
	}

	/**
	 * Moves horizontally until it meet the wall with putting beepers every two
	 * moves. Precondition: Karel should face the right direction.
	 * Postcondition: Karel should face the wall.
	 */
	private void horizontalMove() {
		while (this.frontIsClear()) {
			putBeeperIfRequired();
			move();
			moveCount++;
		}
		putBeeperIfRequired();
	}

	/**
	 * Moves vertically one step with changing direction correctly.
	 * Precondition: Karel should face the wall in horizontal direction.
	 * Postcondition: If there is no wall in horizontal direction, Karel moves
	 * up and face the right direction.
	 * 
	 * @return true if the Karel move up successfully, otherwise false.
	 */
	private boolean moveUp() {
		turn();
		if (frontIsClear()) {
			move();
			turn();
			moveCount++;
			moveUpCount++;
			return true;
		} else
			return false;
	}

	/**
	 * Turns Karel in appropriate direction based on the move up count.
	 */
	private void turn() {
		if (moveUpCount % 2 == 0) {
			turnLeft();
		} else {
			turnRight();
		}
	}

	/**
	 * Puts beepers, if the move count is divided by 2.
	 */
	private void putBeeperIfRequired() {
		if (moveCount % 2 == 0)
			putBeeper();
	}
}
