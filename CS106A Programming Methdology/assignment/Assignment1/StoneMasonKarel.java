/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		// Repairs arch until it went to the end of map.
		while (true) {
			repairArchAndReturnBack();
			turnLeft();
			// If the front is wall, we ar done.
			if (frontIsClear()) {
				if (!moveToNextArch())
					break;
			} else
				break;
		}
	}

	/**
	 * Repairs arch and return back to its original position.
	 */
	private void repairArchAndReturnBack() {
		turnLeft();
		while (this.frontIsClear()) {
			putBeeperIfAbsent();
			move();
		}
		putBeeperIfAbsent();
		turnAround();
		while (frontIsClear()) {
			move();
		}
	}

	/**
	 * Move to next arch.
	 * 
	 * @return true if it successfully move to next arch. false if there is no
	 *         arch until it get the wall.
	 */
	private boolean moveToNextArch() {
		for (int i = 0; i < 4; i++) {
			if (frontIsClear())
				move();
			else
				return false;
		}
		return true;
	}

	/**
	 * Puts beeper if there is no existing beepers.
	 */
	private void putBeeperIfAbsent() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}

}
