package lab.l02;

/**
 * @author sungjuc
 * @version 15-100 Introductory/Intermediate Programming
 */
public class Classroom {

	/**
	 * Test drive
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Test drive for toString and equals methods.
		System.out.println("--------------------------------------");
		Classroom cr1 = new Classroom("WEH", "5419B", 30, false);
		Classroom cr2 = new Classroom("WEH", "5419B", 30, false);
		Classroom cr3 = new Classroom("WEH", "5419A", 30, true);

		System.out.println(cr1.toString());
		System.out.println(cr2.toString());
		System.out.println(cr3.toString());

		System.out.println(cr1.toString() + " and " + cr2.toString() + " : "
				+ cr1.equals(cr2));
		System.out.println(cr2.toString() + " and " + cr3.toString() + " : "
				+ cr2.equals(cr3));
		System.out.println("--------------------------------------");

		// Test drive for entering
		System.out.println("--------------------------------------");
		System.out.println("Current Number of poeple:\t" + cr1.numberOfPeople);
		System.out.println("Entering 1 people       :\t" + cr1.enter(1));
		System.out.println("Current Number of poeple:\t" + cr1.numberOfPeople);
		System.out.println("Entering 30 people      :\t" + cr1.enter(30));
		System.out.println("Current Number of poeple:\t" + cr1.numberOfPeople);
		System.out.println("Entering 29 people      :\t" + cr1.enter(29));
		System.out.println("Current Number of poeple:\t" + cr1.numberOfPeople);
		System.out.println("--------------------------------------");

		// Test drive for leaving
		System.out.println("--------------------------------------");
		System.out.println("Current Number of poeple:\t" + cr1.numberOfPeople);
		System.out.println("Leaving 1 people        :\t" + cr1.leave(1));
		System.out.println("Current Number of poeple:\t" + cr1.numberOfPeople);
		System.out.println("Leaving 30 people       :\t" + cr1.leave(30));
		System.out.println("Current Number of poeple:\t" + cr1.numberOfPeople);
		System.out.println("Leaving 29 people     	:\t" + cr1.leave(29));
		System.out.println("Current Number of poeple:\t" + cr1.numberOfPeople);
		System.out.println("--------------------------------------");
	}

	/**
	 * Provides way for people to leave class room. Bigger the number of leaving
	 * compared to the number of people will produce error.
	 * 
	 * @param numberOfLeaves
	 * @return success (true) or failure (false) of leaving
	 */
	public boolean leave(int numberOfLeaves) {
		// If the number of leaving is bigger than the number of people, it
		// would be exception.
		if (this.numberOfPeople - numberOfLeaves < 0)
			return false;

		// Otherwise, extract the number of leaving from the number of people
		this.numberOfPeople -= numberOfLeaves;

		return true;
	}

	/**
	 * Provides way for people to enter class room. If there is no enough seats,
	 * it will report error.
	 * 
	 * @param numberOfEnters
	 * @return success (true) of failure (false) of entering
	 */
	public boolean enter(int numberOfEnters) {
		// If there is no enough seats, report error.
		if (this.numberOfPeople + numberOfEnters > this.numberOfSeats)
			return false;

		// Otherwise, sum the number of entering to the number of people.
		this.numberOfPeople += numberOfEnters;

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// It will print the information of object as shown in the below:
		// buildigNumber, roomNumber, audioVideoSystem, numberOfSeats,
		// numberOfPeople
		return this.buildingNumber + ", " + this.roomNumber + ", "
				+ this.audioVideoSystem + ", " + this.numberOfSeats + ", "
				+ this.numberOfPeople;
	}

	/**
	 * Compares the following properties then return the results true if all
	 * properties are same.
	 * 
	 * @param o
	 *            An object should be an instance of Classroom class.
	 * @return true if two objects has same value of all properties.
	 */
	public boolean equals(Object o) {
		Classroom cr = (Classroom) o;

		if (this.buildingNumber != cr.buildingNumber)
			return false;

		if (this.roomNumber != cr.roomNumber)
			return false;

		if (this.numberOfSeats != cr.numberOfSeats)
			return false;

		if (this.numberOfPeople != cr.numberOfPeople)
			return false;

		if (this.audioVideoSystem != cr.audioVideoSystem)
			return false;

		return true;
	}

	/**
	 * Creates an instance of Classroom with buildingNumber, roomNumber,
	 * numberOfSeats and audioVideoSystem.
	 * 
	 * @param buildingNumber
	 * @param roomNumber
	 * @param numberOfSeats
	 * @param audioVideoSystem
	 */
	public Classroom(String buildingNumber, String roomNumber,
			int numberOfSeats, boolean audioVideoSystem) {
		this.buildingNumber = buildingNumber;
		this.roomNumber = roomNumber;
		this.numberOfSeats = numberOfSeats;
		this.audioVideoSystem = audioVideoSystem;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public boolean isAudioVideoSystem() {
		return audioVideoSystem;
	}

	private String buildingNumber; // ex) NSH, WEH and DHH
	private String roomNumber; // 101, 1958A and 40B
	private int numberOfSeats;
	private int numberOfPeople;
	private boolean audioVideoSystem;
}
