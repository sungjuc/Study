package exam.e01;

import java.util.Arrays;

public class RetirementAccount implements Comparable {

	private float balance;
	private boolean taxDeferred;
	private String holder;

	public RetirementAccount(String holder, boolean taxDeferred) {
		this(holder, 0f, taxDeferred);
	}

	public RetirementAccount(String holder, float balance, boolean taxDeferred) {
		this.holder = holder;
		this.taxDeferred = taxDeferred;
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	public boolean getTaxDeferred() {
		return taxDeferred;
	}

	public String getHolder() {
		return holder;
	}

	public void toggleDeferredStatus() {
		taxDeferred = !taxDeferred;
	}

	public boolean contribute(float amount) {
		if (amount >= 0) {
			balance += amount;
			return true;
		} else
			return false;
	}

	public void appreciate(float gain) {
		if (gain >= 0) {
			balance = balance * (1 + gain / 100);
			if (gain >= 10)
				taxDeferred = false;
		} else {
			balance += gain;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Name: " + holder + "], ");
		sb.append("[Balance: " + balance + "], ");
		sb.append("[Tax deferred: " + taxDeferred + "]");

		return sb.toString();
	}

	public int compareTo(Object o) throws ClassCastException {
		RetirementAccount obj = (RetirementAccount) o;
		if (balance > obj.getBalance())
			return 1;
		else if (balance < obj.getBalance())
			return -1;
		return 0;
	}

	public static void main(String[] args) {
		RetirementAccount[] accounts = new RetirementAccount[2];
		accounts[0] = new RetirementAccount("Joe", true);
		accounts[1] = new RetirementAccount("Ihny", 1000.00f, true);

		Arrays.sort(accounts);
		for (RetirementAccount account : accounts)
			System.out.println(account.toString());

		System.out.println("-------------------");

		accounts[0].contribute(10);
		System.out.println(accounts[0].toString());

		System.out.println("-------------------");

		accounts[0].appreciate(10);
		System.out.println(accounts[0].toString());

		System.out.println("-------------------");

		accounts[0].appreciate(-1);
		System.out.println(accounts[0].toString());

		System.out.println("-------------------");

		Arrays.sort(accounts);
		for (RetirementAccount account : accounts)
			System.out.println(account.toString());

		System.out.println("-------------------");
	}
}
