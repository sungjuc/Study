package lec.l12;

public class RandomPlayer implements Player {
	public int remove(int numLeft) {
		if (numLeft == 1)
			return 1;
		else
			return (int) (Math.random() * 2) + 1;
	}
}
