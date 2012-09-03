package lec.l17;

public class ComparableUtils {
	public static Comparable max(Comparable x, Comparable y) {
		if (x.compareTo(y) > 0)
			return x;
		else
			return y;
	}
}
