package lec.l11;

public class RandomPlayer {
	public int remove(int numLeft) {
		if (numLeft == 1)
			return 1;
		else
			return (int) (Math.random() * 2) + 1;
	}
}
