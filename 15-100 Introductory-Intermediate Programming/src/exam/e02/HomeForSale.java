package exam.e02;

public class HomeForSale implements Comparable {
	private String address;
	private int baths;
	private int beds;
	private int priceInDollars;

	public HomeForSale(String address, int baths, int beds, int priceInDollars) {
		this.address = address;
		this.baths = baths;
		this.beds = beds;
		this.priceInDollars = priceInDollars;
	}

	public String getAddress() {
		return address;
	}

	public int getBeds() {
		return beds;
	}

	public int getBaths() {
		return baths;
	}

	public int priceInDollars() {
		return priceInDollars;
	}

	@Override
	public int compareTo(Object o) {
		HomeForSale obj = (HomeForSale) o;
		return priceInDollars - obj.priceInDollars();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Price: " + priceInDollars() + "], ");
		sb.append("[Beds: " + getBeds() + "], ");
		sb.append("[Baths: " + getBaths() + "], ");
		sb.append("[Address: " + getAddress() + "]");
		return sb.toString();
	}
}
