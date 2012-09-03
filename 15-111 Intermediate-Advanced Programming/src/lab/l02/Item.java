package lab.l02;

/**
 * The Item class represents the key and value pair of the Cryptography data.
 * 
 * Normally in the Cryptography, the key will be replaced to the value in
 * encoding/decoding.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 2
 */
public class Item {
	private String key;
	private String value;

	/**
	 * Constructs an Item with key and value.
	 * 
	 * @param key
	 *            the key for the item.
	 * @param value
	 *            the value correlated to the key.
	 */
	public Item(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Returns the key.
	 * 
	 * @return the key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Returns the value.
	 * 
	 * @return the value.
	 */
	public String getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		Item item;
		try {
			item = (Item) o;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		if (!item.getKey().equalsIgnoreCase(this.key))
			return false;
		if (!item.getValue().equalsIgnoreCase(this.value))
			return false;

		return true;
	}
}
