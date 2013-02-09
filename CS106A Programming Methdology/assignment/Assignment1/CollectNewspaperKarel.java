/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {

	public void run() {
		goToDoor();
		pickBeeper();
		backToPosition();
		turnAround();
	}

	/**
	 * Moves Karel to front door.
	 */
	private void goToDoor() {
		moveTwo();
		turnRight();
		move();
		turnLeft();
		move();
	}

	/**
	 * Moves Karel to its original position.
	 */
	private void backToPosition() {
		turnAround();
		move();
		turnRight();
		move();
		turnLeft();
		moveTwo();
	}

	/**
	 * Moves Karel toward two times.
	 */
	private void moveTwo() {
		move();
		move();
	}

	/**
	 * Makes Karel turn right.
	 */
	private void turnRight() {
		turnLeft();
		turnAround();
	}

	/**
	 * Makes Karel turn around;
	 */
	private void turnAround() {
		turnLeft();
		turnLeft();
	}
}
