package lec.l26;

public class BackTracking {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		System.out.println("8: " + BackTracking.canMakeSum(a, 8, 0));
		System.out.println("12: " + BackTracking.canMakeSum(a, 12, 0));
		System.out.println("100: " + BackTracking.canMakeSum(a, 100, 0));

		System.out.println("8: " + BackTracking.canMakeSum2(a, 8, 0));
		System.out.println("12: " + BackTracking.canMakeSum2(a, 12, 0));
		System.out.println("100: " + BackTracking.canMakeSum2(a, 100, 0));
		
	}

	public static boolean canMakeSum(int[] a, int sum, int i) {
		if (sum == 0)
			return true;
		if (i == a.length - 1)
			return false;
		if (canMakeSum(a, sum - a[i], i + 1))
			return true;
		else
			return canMakeSum(a, sum, i + 1);
	}

	public static boolean canMakeSum2(int[] a, int sum, int i) {
		return (sum == 0) || (i < a.length - 1)
			&& canMakeSum(a, sum - a[i], i + 1)
			|| canMakeSum(a, sum, i + 1);
	}
}