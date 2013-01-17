package lec01;
/*************************************************
 * File: OurKarelProgram.java
 *
 * A simple Karel program where Karel picks up a
 * beeper and carries it up a hill.
 */

import stanford.karel.*;

public class OurKarelProgram extends Karel {
	public void run() {
		move();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		putBeeper();
		move();
	}
}
