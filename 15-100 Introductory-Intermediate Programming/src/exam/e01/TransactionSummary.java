package exam.e01;

public class TransactionSummary implements Comparable {
	private float totalAmountInDollars;
	private boolean isARefund;
	private int changeCounter;

	public TransactionSummary(float totalAmountInDollars, boolean isARefund) {
		this.totalAmountInDollars = totalAmountInDollars;
		this.isARefund = isARefund;
		changeCounter = 0;
	}

	public float getTotalAmountInDollars() {
		return totalAmountInDollars;
	}

	public boolean isARefund() {
		return isARefund;
	}

	public int getChangeCounter() {
		return changeCounter;
	}

	public boolean increaseTheValue(float changeInValue) {
		if (changeInValue > 0) {
			totalAmountInDollars += changeInValue;
			changeCounter++;
			return true;
		} else
			return false;
	}

	public boolean decreaseTheValue(float changeInValue) {
		if (0 < changeInValue && changeInValue <= totalAmountInDollars) {
			totalAmountInDollars -= changeInValue;
			changeCounter++;
			return true;
		} else
			return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Total Amount In Dollars: " + totalAmountInDollars
				+ "], [Change Counter: " + changeCounter + "], "
				+ "[Is A Refund: " + isARefund + "]");
		return sb.toString();
	}

	public int compareTo(Object o) throws ClassCastException {
		TransactionSummary obj = (TransactionSummary) o;

		if (totalAmountInDollars > obj.totalAmountInDollars)
			return 1;
		else if (totalAmountInDollars < obj.totalAmountInDollars)
			return -1;
		else
			return changeCounter - obj.changeCounter;
	}

	public static void main(String[] args) {
		TransactionSummary ts1 = new TransactionSummary(0.00f, true);
		TransactionSummary ts2 = new TransactionSummary(10.00f, true);

		System.out.println(ts1.toString());
		System.out.println(ts2.toString());

		ts1.increaseTheValue(9.00f);
		ts2.decreaseTheValue(1.00f);

		System.out.println(ts1.toString());
		System.out.println(ts2.toString());

		if (ts1.compareTo(ts2) == 0) {
			System.out.println("ts1 and ts2 are same!");
		} else if (ts1.compareTo(ts2) > 0) {
			System.out.println("ts1 is bigger than ts2!");
		} else {
			System.out.println("ts1 is smaller than ts2!");
		}

	}
}
