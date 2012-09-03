package lab.l01;

import java.util.Comparator;

/**
 * The Card class represents a library card holding the information about a
 * book.
 * 
 * The title, author and subject are the attributes of this class. Each
 * attribute is accessible from out of class.
 * 
 * The AuthorComparator and TitleComparator are nested comparators to be used to
 * compare cards.
 * 
 * @author sungjuc
 * @version 15-111 Intermediate/Advanced Programming Lab 1
 * @see CardCatalog
 */
public class Card {
	/**
	 * Constructs an card with the specified title, author and subject.
	 * 
	 * @param title
	 *            the title of book.
	 * @param author
	 *            the author of book.
	 * @param subject
	 *            the subject of book.
	 */
	public Card(String title, String author, String subject) {
		this.title = title;
		this.author = author;
		this.subject = subject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Title: " + title + "\tAuthor: " + author + "\tSubject: "
				+ subject;
	}

	@Override
	public boolean equals(Object o) {
		Card card = (Card) o;
		if (!this.title.equals(card.getTitle()))
			return false;
		if (!this.author.equals(card.getAuthor()))
			return false;
		if (!this.subject.equals(card.getSubject()))
			return false;
		return true;
	}

	/**
	 * Returns the title of book.
	 * 
	 * @return the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of book.
	 * 
	 * @param title
	 *            the title to be set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the author of book.
	 * 
	 * @return the author of book.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author of book.
	 * 
	 * @param author
	 *            the author to be set.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns the subject of book.
	 * 
	 * @return the subject of book
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject of book.
	 * 
	 * @param subject
	 *            the subject to be set.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	private String title; // The title of book.
	private String author; // The author of book.
	private String subject; // The subject of book.

	/**
	 * Comparator compares cards using title.
	 * 
	 * @author sungju.cho
	 * 
	 */
	public static class TitleComparator implements Comparator<Card> {
		@Override
		public int compare(Card card1, Card card2) {
			return card1.getTitle().compareTo(card2.getTitle());
		}
	}

	/**
	 * Comparator compares cards using author name.
	 * 
	 * @author sungju.cho
	 * 
	 */
	public static class AuthorComparator implements Comparator<Card> {
		@Override
		public int compare(Card card1, Card card2) {
			return card1.getAuthor().compareTo(card2.getAuthor());
		}
	}
}
