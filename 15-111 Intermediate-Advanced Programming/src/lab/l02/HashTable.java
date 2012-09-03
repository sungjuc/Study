package lab.l02;

/**
 * The HashTable class represents hash table holding the key and the item which
 * contains the encoding and encoding character relationship.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 2
 */
public class HashTable {

	/**
	 * Checks whether there is item has same key value or not.
	 * 
	 * @param key
	 *            the value of key to search.
	 * @return true if there is item with same key value. Otherwise, false.
	 */
	public boolean containsKey(String key) {
		int hashVal = hash(key);
		Item value;

		// Checks the first bucket has item or not.
		if (table[hashVal] != null)
			// Quadratic probing.
			while ((value = table[hashVal]) != null) {
				if (value.getKey().equals(key))
					return true;
				hashVal = serchNextBucket(hashVal);
			}

		return false;
	}

	/**
	 * Add an item into tables.
	 * 
	 * @param key
	 *            the item's key value.
	 * @param value
	 *            the item.
	 */
	public void add(String key, Item value) {
		int hashVal = hash(key);

		// Find proper bucket to insert the value.
		while ((table[hashVal]) != null)
			hashVal = serchNextBucket(hashVal);

		table[hashVal] = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < HASH_SIZE; i++)
			if (table[i] != null)
				result.append("[" + table[i].getKey() + ", "
						+ table[i].getValue() + "]");

		return result.toString();
	}

	/**
	 * Returns the value of the item.
	 * 
	 * Since this hash table make use of quadratic probing to avoid collision,
	 * this method also look for the item using quadratic probing if there are
	 * collied items.
	 * 
	 * If there is no items matches the key value, the key value will be
	 * returned.
	 * 
	 * @param key
	 *            the value for searching.
	 * @return the value of the item searched with the key value.
	 */
	public String get(String key) {
		int hashVal = hash(key);
		Item data;

		// Quadratic probing.
		while ((data = table[hashVal]) != null) {
			// Check if the key values are same.
			if (data.getKey().equals(key)) {
				return data.getValue();
			}

			// Increase the hash value based on the quadratic probing.
			hashVal = serchNextBucket(hashVal);
		}

		return key;
	}

	/**
	 * Returns the hash value calculated based on the hash size and hash code of
	 * the key.
	 * 
	 * Before the hash value is calculated, key will be converted to upper case
	 * letter so as to make this key case insensitive.
	 * 
	 * @param key
	 *            the key.
	 * @return the hash value of the key.
	 */
	private int hash(String key) {
		return key.toUpperCase().hashCode() % HASH_SIZE;
	}

	/**
	 * Returns a new hash value based on the quadratic probing.
	 * 
	 * @param hashVal
	 *            the value to be changed based on the quadratic probing.
	 * @return the increased value.
	 */
	private int serchNextBucket(int hashVal) {
		return (hashVal * hashVal) % HASH_SIZE;
	}

	private Item[] table = new Item[HASH_SIZE];
	private static final int HASH_SIZE = 101;
}
