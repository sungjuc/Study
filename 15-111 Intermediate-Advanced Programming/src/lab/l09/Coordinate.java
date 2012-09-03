package lab.l09;

/**
 * Class represents the position of landmark in Cartesion plane.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 9
 */
public class Coordinate {
	private float x;
	private float y;

	/**
	 * Constructs the instance with initial x and y position string.
	 * 
	 * @param xString
	 * @param yString
	 */
	public Coordinate(String xString, String yString) {
		this.x = Float.parseFloat(xString);
		this.y = Float.parseFloat(yString);
	}

	public String toString() {
		return "X: " + this.x + "\tY: " + this.y;
	}

	/**
	 * Returns the x position.
	 * 
	 * @return the x position.
	 */
	public float getX() {
		return x;
	}

	/**
	 * Returns the y position.
	 * 
	 * @return the y position.
	 */
	public float getY() {
		return y;
	}
}