package lab.l03;

/**
 * The class represents a text book with title, author, pages and price.
 * 
 * The title, author and pages cannot be modified once an object is
 * instantiated. The price can be adjusted. The price and pages should be bigger
 * than or equal to 0. The comments can be added, however already added comments
 * cannot be deleted or modified.
 * 
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 3
 */
/**
 * @author sungju.cho
 * 
 */
public class Textbook {
	private String title;
	private String author;
	private int pages;
	private float price;
	private String comments;

	/**
	 * Returns the title.
	 * 
	 * @return the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns the author.
	 * 
	 * @return the author.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Returns the number of page.
	 * 
	 * @return the number of page.
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * Returns the price.
	 * 
	 * @return the price.
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Returns the comments.
	 * 
	 * @return the comments.
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the price.
	 * @throws NegativePriceException
	 *             if the price is smaller than 0.
	 */
	public void setPrice(float price) throws NegativePriceException {
		if (price < 0)
			throw new NegativePriceException(
					"The price should be bigger than 0.");
		this.price = price;
	}

	/**
	 * Adds the comments. Each comments are separated by a delimiter, "|".
	 * 
	 * @param comments
	 *            the comments.
	 */
	public void addComments(String comments) {
		if (this.comments.equals(""))
			this.comments = comments;
		else
			this.comments += "|" + comments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Title: ");
		sb.append(title);
		sb.append(", \tAuthor: ");
		sb.append(author);
		sb.append(", \tPages: ");
		sb.append(pages);
		sb.append(", \tPrice: ");
		sb.append(price);
		sb.append(", \tComments: ");
		sb.append(comments);

		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		Textbook tb;
		try {
			tb = (Textbook) obj;
		} catch (ClassCastException cce) {
			cce.printStackTrace();
			return false;
		}

		if (!this.title.equals(tb.getTitle()))
			return false;
		if (!this.author.equals(tb.getAuthor()))
			return false;
		if (this.price != tb.getPrice())
			return false;
		if (this.pages != tb.getPages())
			return false;
		if (!this.comments.equals(tb.getComments()))
			return false;

		return true;
	}

	/**
	 * Constructs a text book with title, author, pages and price.
	 * 
	 * @param title
	 *            the title.
	 * @param author
	 *            the author.
	 * @param pages
	 *            the number of pages.
	 * @param price
	 *            the price.
	 * @throws NegativePriceException
	 *             if the price is smaller than 0.
	 * @throws NegativePagesException
	 *             if the number of pages is smaller than 0.
	 */
	public Textbook(String title, String author, int pages, float price)
			throws NegativePriceException, NegativePagesException {

		if (price < 0)
			throw new NegativePriceException(
					"The price should be bigger than 0.");
		if (pages < 0)
			throw new NegativePagesException(
					"The pages should be bigger than 0.");

		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
		this.comments = "";
	}

	/**
	 * Constructs a text book with title, author, pages, price and comments.
	 * 
	 * @param title
	 *            the title.
	 * @param author
	 *            the author.
	 * @param pages
	 *            the pages.
	 * @param price
	 *            the number of pages.
	 * @param comments
	 *            the comments.
	 * @throws NegativePriceException
	 *             if the price is smaller than 0.
	 * @throws NegativePagesException
	 *             if the number of pages is smaller than 0.
	 */
	public Textbook(String title, String author, int pages, float price,
			String comments) throws NegativePriceException,
			NegativePagesException {
		this(title, author, pages, price);
		this.comments = comments;
	}

	/**
	 * Test drive.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Textbook javaBook = null;
		try {
			javaBook = new Textbook("15-100", "Greg Kesden", 300, (float) 19.99);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(javaBook.toString());

		javaBook.addComments("This is really nice book!");
		System.out.println(javaBook.toString());

		Textbook myBook = null;
		try {
			myBook = new Textbook("XML", "SungJu Cho", 428, (float) 59.99,
					"Nice book!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(myBook.toString());

		myBook.addComments("Not so good!!!");
		System.out.println(myBook.toString());

		try {
			myBook.setPrice((float) 60.00);
		} catch (NegativePriceException e) {
			e.printStackTrace();
		}
		System.out.println(myBook.toString());

		Textbook badBook = null;
		try {
			badBook = new Textbook("Bad", "Bad Guy", -200, (float) 10.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			badBook = new Textbook("Bad", "Bad Guy", 200, (float) -10.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			badBook = new Textbook("Bad", "Bad Guy", 200, (float) 10.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(badBook.toString());
		try {
			badBook.setPrice((float) -10.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The exception class represents the exceptional case that the price is
	 * smaller than 0.
	 * 
	 * @author sungju.cho
	 * 
	 */
	public class NegativePriceException extends Exception {
		public NegativePriceException(String message) {
			super(message);
		}
	}

	/**
	 * The exception class represents the exceptional case that the number of
	 * page is smaller than 0.
	 * 
	 * @author sungju.cho
	 * 
	 */
	public class NegativePagesException extends Exception {
		public NegativePagesException(String message) {
			super(message);
		}
	}
}
