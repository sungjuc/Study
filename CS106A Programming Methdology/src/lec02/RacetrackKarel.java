package lec02;

import stanford.karel.*;

public class RacetrackKarel extends Karel {
	public void run() {
		runTrack();
	}
	
	private void runTrack() {
		for (int i = 0; i < 4; i++) {
			runOneLength();
		}
	}
	
	private void runOneLength() {
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
}
