package lec.l11;

import java.util.ArrayList;

public class Player {
	private String name;
	private int numChips;
	private ArrayList<Card> hand;

	public Player(String name, int numChips) {
		this.name = name;
		this.numChips = numChips;
	}

	public String getName() {
		return name;
	}

	public int getNumChips() {
		return numChips;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}
}
