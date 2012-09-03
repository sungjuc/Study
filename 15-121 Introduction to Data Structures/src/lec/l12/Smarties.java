package lec.l12;

public class Smarties {
	public static void play(Player player1, Player player2, int numLeft) {
		while (numLeft > 0) {
			numLeft -= player1.remove(numLeft);
			if (numLeft == 0) {
				System.out.println("Player 2 won");
				return;
			}
			numLeft -= player2.remove(numLeft);
		}
		System.out.println("player 1 won");
	}
}
