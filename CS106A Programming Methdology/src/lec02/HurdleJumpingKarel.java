package lec02;

import stanford.karel.*;

public class HurdleJumpingKarel extends SuperKarel {
	public void run() {
		for (int i = 0; i < 8; i++) {
			if (frontIsClear()) {
				move();
			} else {
				jumpOneHurdle();
			}
		}
	}
	
	private void jumpOneHurdle() {
		ascendHurdle();
		move();
		descendHurdle();
	}
	
	private void ascendHurdle() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		}
		turnRight();
	}
	
	private void descendHurdle() {
		turnRight();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
}
