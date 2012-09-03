package exam.finale.f05.p1;
/************************************************
 * Class Customer
 * 
 * You are to implement a class called Customer that meets the specifications on
 * the Exam handout. A CustomerTester class is provided in order to test your
 * code.
 * 
 * Name: SungJu Cho Section: Kesden Date: sungjuc@andrew.cmu.edu:
 *************************************************/

public class Customer {
	private String name;
	private String typeOfService;
	private int rate;
	private int minutes;
	private int numPhoneLines;

	private final static String RESIDENTIAL = "Residential";
	private final static String BUSINESS = "Business";

	public Customer(String name, String typeOfService, int rate) {
		this.name = name;
		this.typeOfService = typeOfService;
		this.rate = rate;
		this.minutes = 0;
		this.numPhoneLines = 1;
	}

	public Customer(String name, String typeOfService) {
		this.name = name;
		this.typeOfService = typeOfService;
		if (typeOfService.equals(RESIDENTIAL)) {
			this.rate = 8;
		} else if (typeOfService.equals(BUSINESS)) {
			this.rate = 4;
		}
		this.minutes = 0;
		this.numPhoneLines = 1;
	}

	public Customer(String name) {
		this(name, RESIDENTIAL);
	}

	public String getName() {
		return this.name;
	}

	public String getTypeOfService() {
		return this.typeOfService;
	}

	public int getRate() {
		return this.rate;
	}

	public int getMinutes() {
		return this.minutes;
	}

	public int getNumPhoneLines() {
		return this.numPhoneLines;
	}

	public void addUsage(int usage) {
		this.minutes += usage;
	}

	public void addPhoneLine() {
		this.numPhoneLines++;
	}

	public int getTotalCharge() {
		int total = rate * minutes / 100;
		if (this.numPhoneLines > 1) {
			total += (this.numPhoneLines - 1) * 20;
		}
		return total;
	}

	public void removePhoneLine() {
		if (numPhoneLines > 0)
			this.numPhoneLines--;
	}

	public boolean equals(Object o) {
		Customer obj;
		try {
			obj = (Customer) o;
		} catch (ClassCastException cce) {
			return false;
		}
		if (!this.typeOfService.equals(obj.typeOfService))
			return false;
		if (this.numPhoneLines != obj.numPhoneLines)
			return false;

		return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.name).append(",").append(this.typeOfService).append(",");
		sb.append(this.rate).append(" cents/min,").append(this.minutes);
		sb.append(" minutes,").append(this.numPhoneLines).append(
				" phone line(s)");

		return sb.toString();
	}
}