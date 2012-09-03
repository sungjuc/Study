package lab.l05;

/**
 * The class represents Dictionary providing the ability to add and look up
 * definition.
 * 
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 5
 */
public class Dictionary {
	private Definition[] definitions;
	private int count;

	/**
	 * Constructs the Dictionary object with its capacity.
	 * 
	 * @param capacity
	 *            the capacity of the Bookshelf.
	 */
	public Dictionary(int capacity) {
		definitions = new Definition[capacity];
		count = 0;
	}

	/**
	 * Adds the definition into the Dictionary. The inserted definitions are
	 * keep in sorted order. Therefore, this adding method find its proper
	 * position.
	 * 
	 * @param definition
	 *            the definition to be inserted.
	 */
	public void add(Definition definition) {
		if (count == definitions.length)
			grow();

		int i;
		for (i = 0; i < definitions.length; i++) {
			if (definitions[i] != null) {
				if (definitions[i].compareTo(definition) > 0) {
					break;
				}
			} else {
				break;
			}
		}
		for (int j = definitions.length; j > i; j--) {
			if (definitions[j - 1] != null)
				definitions[j] = definitions[j - 1];
		}
		definitions[i] = definition;
		count++;
	}

	/**
	 * Finds and returns the meaning of the word.
	 * 
	 * @param word
	 *            the word to be found.
	 * @return the meaning of the word.
	 * @throws WordNotFoundException
	 *             if there is no word in the Dictionary.
	 */
	public String findMeaning(String word) throws WordNotFoundException {
		Definition definition = new Definition(word, null);

		int position = binarySearch(definitions, definition, 0, count - 1);

		if (position < 0)
			throw new WordNotFoundException(
					"There is no word in the dictionary");

		return definitions[position].getMeaning();
	}

	/**
	 * Searches the definition in the Definition array using binary search
	 * algorithm.
	 * 
	 * @param definitions
	 *            the array of Definition objects.
	 * @param definition
	 *            the Definition to be found.
	 * @param low
	 *            the minimum index of the array.
	 * @param high
	 *            the maximum index of the array.
	 * @return the position of the definition found. -1 if there is no
	 *         definition.
	 */
	private int binarySearch(Definition[] definitions, Definition definition,
			int low, int high) {
		if (low > high)
			return -1;

		int middle = (low + high) / 2;

		if (definitions[middle].compareTo(definition) < 0)
			return binarySearch(definitions, definition, middle + 1, high);
		else if (definitions[middle].compareTo(definition) > 0)
			return binarySearch(definitions, definition, low, middle - 1);
		else if (definitions[middle].compareTo(definition) == 0)
			return middle;

		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < definitions.length; i++)
			if (definitions[i] != null) {
				sb.append(definitions[i].getWord() + ": "
						+ definitions[i].getMeaning() + "\n");
			}
		return sb.toString();
	}

	/**
	 * Returns another Dictionary contains the list of words starts with the
	 * provided String.
	 * 
	 * @param character
	 *            the word starts with the characters.
	 * @return Dictionary containing the list of word starting with the provided
	 *         String.
	 */
	public Dictionary beginsWith(String character) {
		int initCapacity = 1;
		Dictionary newDic = new Dictionary(initCapacity);
		for (int i = 0; i < definitions.length; i++)
			if (definitions[i] != null) {
				if (definitions[i].getWord().startsWith(character)) {
					if (i > initCapacity)
						newDic.add(definitions[i]);
				}
			}
		return newDic;
	}

	/**
	 * Increase the capacity of the Dictionary as twice.
	 */
	public void grow() {
		Definition[] newDefinitions = new Definition[2 * definitions.length];
		for (int i = 0; i < definitions.length; i++) {
			newDefinitions[i] = definitions[i];
		}

		this.definitions = newDefinitions;
	}

	/**
	 * The class represents the exceptional case that there is no word in the
	 * Dictionary.
	 * 
	 * @author sungju.cho
	 * 
	 */
	public class WordNotFoundException extends Exception {
		public WordNotFoundException(String message) {
			super(message);
		}
	}
}
