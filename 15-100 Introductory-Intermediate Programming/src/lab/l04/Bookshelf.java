package lab.l04;

/**
 * The class represents the bookshelf.
 * 
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 4
 */
public class Bookshelf {
	private Textbook[] textbooks;

	/**
	 * Constructs an instance of Bookshelf.
	 * 
	 * @param maximumNumberOfBooks
	 *            if the number of books is smaller than 1.
	 */
	public Bookshelf(int maximumNumberOfBooks) throws IndexOutOfBoundsException {
		if (maximumNumberOfBooks < 1)
			throw new IndexOutOfBoundsException();
		textbooks = new Textbook[maximumNumberOfBooks];
	}

	/**
	 * Adds a book into the Bookshelf to specified position.
	 * 
	 * @param pos
	 *            the position in the Bookshelf.
	 * @param textBook
	 *            the Textbook to be inserted.
	 * @throws IndexOutOfBoundsException
	 *             if there is no position specified by the pos parameters.
	 */
	public void addABook(int pos, Textbook textBook)
			throws IndexOutOfBoundsException {
		checkIndex(pos);

		textbooks[pos] = textBook;
	}

	/**
	 * Returns a Textbook from the Bookshelf. The position of the Textbook to be
	 * returned specified as the input parameter.
	 * 
	 * @param pos
	 *            the position of the book.
	 * @return a Textbook in the position of the Bookshelf.
	 * @throws TextbookNotFoundException
	 *             if there is no Textbook in the position.
	 * @throws IndexOutOfBoundsException
	 *             if the position is not valid.
	 */
	public Textbook getABook(int pos) throws TextbookNotFoundException,
			IndexOutOfBoundsException {
		checkIndex(pos);

		Textbook book = textbooks[pos];
		if (book == null)
			throw new TextbookNotFoundException();

		return book;
	}

	/**
	 * Removes a Textbook from the specified position in the Bookshelf.
	 * 
	 * @param pos
	 *            the position of the Textbook in Bookshelf to be deleted.
	 * @throws TextbookNotFoundException
	 *             if there is no Textbook in the position.
	 * @throws IndexOutOfBoundsException
	 *             if the position is not valid.
	 */
	public void removeABook(int pos) throws TextbookNotFoundException,
			IndexOutOfBoundsException {
		checkIndex(pos);
		if (textbooks[pos] == null)
			throw new TextbookNotFoundException();
		textbooks[pos] = null;
	}

	/**
	 * Returns the all Textbook in the BookShelf.
	 * 
	 * @return a list contains all Textbook description.
	 */
	public String getAlist() {
		StringBuilder sb = new StringBuilder();

		for (Textbook book : textbooks) {

			if (book != null) {
				sb.append("======================\n");
				sb.append(book.toString());
			}

		}
		sb.append("======================\n");

		return sb.toString();
	}

	/**
	 * Checks the validity of position provided as parameter.
	 * 
	 * @param pos
	 *            the position to be checked.
	 * @throws IndexOutOfBoundsException
	 *             if the index is smaller than 0 or bigger than the length of
	 *             the Bookshelf.
	 */
	private void checkIndex(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos > textbooks.length - 1) {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Represents an exceptional case that there is no Textbook in the position.
	 * 
	 * @author sungju.cho
	 * 
	 */
	class TextbookNotFoundException extends Exception {
		public TextbookNotFoundException() {
			super("Textbook is not found.");
		}
	}
}
