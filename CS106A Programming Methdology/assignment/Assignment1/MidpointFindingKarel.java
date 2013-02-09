/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		int length = explore();
		turnAround();
		putBeeperInCenter(length);
	}

	/**
	 * Moves Karel until it encounters wall. Then, returns how many steps it
	 * moves.
	 * 
	 * @return the number of steps Karel moves.
	 */
	private int explore() {
		int count = 0;
		while (this.frontIsClear()) {
			move();
			count++;
		}
		return count;
	}

	/**
	 * Puts beeper in center of the given length.
	 * 
	 * @param length
	 *            total length.
	 */
	private void putBeeperInCenter(int length) {
		int target = length / 2;
		for (int i = 0; i < target; i++) {
			move();
		}
		putBeeper();
	}

}
