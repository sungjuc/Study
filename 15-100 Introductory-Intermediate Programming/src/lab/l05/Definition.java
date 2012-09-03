package lab.l05;

/**
 * The class represents the relationship between a word and its meaning.
 * 
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 5
 */
public class Definition implements Comparable<Definition> {

	/**
	 * Constructs the Definition object.
	 * 
	 * @param word
	 *            the word.
	 * @param meaning
	 *            the meaning of the word.
	 */
	public Definition(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
	}

	/**
	 * Returns the value of the word.
	 * 
	 * @return the word.
	 */
	public String getWord() {
		return this.word;
	}

	/**
	 * Returns the value of the meaning.
	 * 
	 * @return the meaning of the word.
	 */
	public String getMeaning() {
		return this.meaning;
	}

	/**
	 * Sets the meaning of the word.
	 * 
	 * @param meaning
	 *            the meaning to be set.
	 */
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Definition o) {
		Definition obj = (Definition) o;
		return this.getWord().compareToIgnoreCase(obj.getWord());
	}

	private String word;
	private String meaning;
}
