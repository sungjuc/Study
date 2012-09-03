package exam.finale.s05.p1;

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
	private double rate;
	private int hours;

	private final static double DEFAULT_RESIDENT_RATE = 0.6;
	private final static double DEFAULT_BUSINESS_RATE = 0.4;
	private final static String RESIDENT_TYPE = "Residential";
	private final static String BUSINESS_TYPE = "Business";

	public Customer(String name, String typeOfService) {
		this(name);
		this.typeOfService = typeOfService;

		if (typeOfService.equals(RESIDENT_TYPE))
			this.rate = DEFAULT_RESIDENT_RATE;
		if (typeOfService.equals(BUSINESS_TYPE))
			this.rate = DEFAULT_BUSINESS_RATE;
	}

	public Customer(String name, double rate) {
		this(name);
		this.rate = rate;
		if (rate >= 0.5)
			this.typeOfService = RESIDENT_TYPE;
		else
			this.typeOfService = BUSINESS_TYPE;
	}

	public Customer(String name) {
		super();
		this.name = name;
		this.hours = 0;
		this.typeOfService = RESIDENT_TYPE;
		this.rate = DEFAULT_RESIDENT_RATE;
	}

	public String getName() {
		return name;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public double getRate() {
		return rate;
	}

	public int getHours() {
		return hours;
	}

	public double getTotalCost() {
		double total = hours * rate;
		if (hours > 45 && typeOfService.equals(BUSINESS_TYPE))
			total += 10;
		return ((total * 100)) / 100;
	}

	public void addUsage(int hours) {
		this.hours += hours;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(",");
		sb.append(typeOfService).append(",");
		sb.append("Hours:").append(hours).append(",");
		sb.append("Rate:$").append(rate).append(",");
		sb.append("Total:$").append(getTotalCost());

		return sb.toString();
	}

	public boolean equals(Object o) {
		Customer obj;
		try {
			obj = (Customer) o;
		} catch (ClassCastException e) {
			return false;
		}

		if (this.rate != obj.rate)
			return false;

		if (!this.typeOfService.equals(obj.typeOfService))
			return false;

		return true;
	}
}
