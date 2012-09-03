package lab.l07;

import java.util.Random;

/**
 * The Class simulating Web objects, like HTML pages, MPEGs, GIFs, etc. For the
 * purpose of simulation, the only property that a WebIbject has is a size in
 * the range of 1024Bytes (1KB) to 1048,576Bytes (1024KB), measured in whole
 * kilobytes.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 7
 */
public class WebObject implements Comparable {
	private int size;
	private static Random rand = new Random();

	/**
	 * Constructs a new web object with a random size in the range of 1KB to 1MB
	 * (1024KB).
	 */
	public WebObject() {
		// Gets the next integer. This value in the range of 0 to 1023.
		int num = rand.nextInt(1023);

		// Increment one so to make it 1 and 1024.
		this.size = num + 1;
	}

	/**
	 * Returns the size of the WebObject.
	 * 
	 * @return the size of the WebObject.
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Creates an exact copy of the WebObject.
	 * 
	 * @return the created exact copy of the WebObject.
	 */
	public WebObject copy() {
		WebObject wObj = new WebObject();
		wObj.size = this.size;
		return wObj;
	}

	@Override
	public int compareTo(Object obj) {
		WebObject wObj = (WebObject) obj;
		return this.size - wObj.getSize();
	}
}
