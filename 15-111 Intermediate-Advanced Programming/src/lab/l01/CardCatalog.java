package lab.l01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * A catalog holds the list of cards.
 * 
 * The catalog has three different lists store same the list of cards in
 * different order.
 * 
 * This provides various utility methods to manage the list of cards.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 1
 * @see Card
 */
public class CardCatalog {

	/**
	 * Constructs an empty catalog with an initial capacity of ten.
	 */
	public CardCatalog() {
		this.orderByTitle = new Card[DEFAULT_SIZE];
		this.orderByAuthor = new Card[DEFAULT_SIZE];
		this.orderBySubject = new Card[DEFAULT_SIZE];
		this.count = 0;
	}

	/**
	 * Inserts a new card into catalog.
	 * 
	 * @param card
	 *            card to be inserted.
	 */
	public void addACard(Card card) {
		// In case that the arrays are already filled with elements.
		if (count == orderByTitle.length)
			grow();

		addByTitle(card);
		addByAuthor(card);
		addBySubject(card);

		count++;
	}

	/**
	 * Returns a new card which title matches to the specified title value.
	 * 
	 * @param title
	 *            the value to be matched for.
	 * @return the instance of card which title matches.
	 * @throws Exception
	 *             if there is no matched card.
	 */
	public Card getATitle(String title) throws Exception {
		int index = binarySearch(orderByTitle, new Card(title, "", ""),
				new Card.TitleComparator());

		if (index == -1) {
			throw new Exception("The title is not in the item");
		}
		return orderByTitle[index];
	}

	/**
	 * Returns the list of card of which author matches to the specified author
	 * value.
	 * 
	 * @param author
	 *            the value to be matched for.
	 * @return the array of Card.
	 */
	public Card[] getAnAuthor(String author) {
		Card[] results = null;
		int index = binarySearch(orderByAuthor, new Card("", author, ""),
				new Card.AuthorComparator());

		// Return null if there is no search results.
		if (index == -1)
			return results;

		int lowerBound = index;
		int upperBound = index;

		// Get the lower bound index.
		while (lowerBound > 0
				&& orderByAuthor[lowerBound - 1].getAuthor().equals(author)) {
			lowerBound--;
		}

		// Get the upper bound index.
		while (upperBound < count - 1
				&& orderByAuthor[upperBound + 1].getAuthor().equals(author)) {
			upperBound++;
		}

		// Prepares the array to be returned.
		results = new Card[upperBound - lowerBound + 1];

		if (lowerBound == upperBound)
			results[0] = orderByAuthor[index];
		else
			for (int i = lowerBound, count = 0; i <= upperBound; i++, count++)
				results[count] = orderByAuthor[i];

		return results;
	}

	/**
	 * Returns the list of card of which subject contains the specified keyword
	 * value.
	 * 
	 * @param keyword
	 *            the value to be searched for.
	 * @return the array of Card.
	 */
	public Card[] getSubject(String keyword) {
		Pattern pattern = Pattern.compile(".*" + keyword + ".*");
		ArrayList<Card> list = new ArrayList<Card>();
		for (int i = 0; i < count; i++) {
			if (pattern.matcher(orderBySubject[i].getSubject()).matches()) {
				list.add(orderBySubject[i]);
			}
		}

		if (list.size() > 0)
			return list.toArray(new Card[list.size()]);

		return null;
	}

	/**
	 * Deletes cards which title matches to the title value.
	 * 
	 * @param title
	 *            the value to be matched for.
	 */
	public int removeAtitle(String title) {
		int index;
		int authorIndex = -1;
		int subjectIndex = -1;
		int counter = 0;

		while ((index = binarySearch(orderByTitle, new Card(title, "", ""),
				new Card.TitleComparator())) != -1) {

			Card cardToBeRemoved = orderByTitle[index];
			remove(index, orderByTitle);

			for (int i = 0; i < orderByAuthor.length; i++) {
				if (orderByAuthor[i] == cardToBeRemoved) {
					authorIndex = i;
				}
				if (orderBySubject[i] == cardToBeRemoved) {
					subjectIndex = i;
				}
			}

			if (authorIndex != -1)
				remove(authorIndex, orderByAuthor);

			if (subjectIndex != -1)
				remove(subjectIndex, orderBySubject);

			count--;
			counter++;
		}
		return counter;
	}

	/**
	 * Prints the contents of the catalog in specified order. The order is
	 * specified using the mode parameter.
	 * 
	 * @param mode
	 *            the order to be sorted. 0 - title, 1 - author, 2 - subject
	 */
	public void printTheCatalog(int mode) {
		switch (mode) {
		case 0:
			for (int i = 0; i < count; i++)
				System.out.println(orderByTitle[i]);
			break;
		case 1:
			for (int i = 0; i < count; i++)
				System.out.println(orderByAuthor[i]);
			break;
		case 2:
			for (int i = 0; i < count; i++)
				System.out.println(orderBySubject[i]);
			break;
		}
	}

	/**
	 * Returns the number of cards in the catalog.
	 * 
	 * @return the number of cards.
	 */
	public int size() {
		return this.count;
	}

	private void remove(int index, Card[] list) {
		for (int i = index + 1; i < list.length; i++) {
			list[i - 1] = list[i];
		}
	}

	private void addByTitle(Card card) {
		if (count == 0) {
			orderByTitle[count] = card;
			return;
		}

		for (int index = 0; index < count; index++) {
			if (card.getTitle().compareTo(orderByTitle[index].getTitle()) < 0) {
				for (int remains = count - 1; remains >= index; remains--) {
					orderByTitle[remains + 1] = orderByTitle[remains];
				}
				orderByTitle[index] = card;
				return;
			}
		}
		orderByTitle[count] = card;
	}

	private void addByAuthor(Card card) {
		if (count == 0) {
			orderByAuthor[count] = card;
			return;
		}

		for (int index = 0; index < count; index++) {
			if (card.getAuthor().compareTo(orderByAuthor[index].getAuthor()) < 0) {
				for (int remains = count - 1; remains >= index; remains--) {
					orderByAuthor[remains + 1] = orderByAuthor[remains];
				}
				orderByAuthor[index] = card;
				return;
			}
		}
		orderByAuthor[count] = card;
	}

	private void addBySubject(Card card) {
		if (count == 0) {
			orderBySubject[count] = card;
			return;
		}

		for (int index = 0; index < count; index++) {
			if (card.getSubject().compareTo(orderBySubject[index].getSubject()) < 0) {
				for (int remains = count - 1; remains >= index; remains--) {
					orderBySubject[remains + 1] = orderBySubject[remains];
				}
				orderBySubject[index] = card;
				return;
			}
		}
		orderBySubject[count] = card;
	}

	/**
	 * Increase the size of each array by grow factor times.
	 */
	private void grow() {
		// Create new arrays with the size of increasing as multiple with grow
		// factor.
		Card[] biggerOrderByTitle = new Card[count * GROW_FACTOR];
		Card[] biggerOrderByAuthor = new Card[count * GROW_FACTOR];
		Card[] biggerOrderBySubject = new Card[count * GROW_FACTOR];

		// Copy all elements from old arrays to bigger arrays.
		for (int index = 0; index < count; index++) {
			biggerOrderByTitle[index] = orderByTitle[index];
			biggerOrderByAuthor[index] = orderByAuthor[index];
			biggerOrderBySubject[index] = orderBySubject[index];
		}

		// Replace the reference.
		orderByTitle = biggerOrderByTitle;
		orderByAuthor = biggerOrderByAuthor;
		orderBySubject = biggerOrderBySubject;
	}

	/**
	 * Searches array for specified object using the binary algorithm. The array
	 * must be sorted into ascending order according to the specified comparator
	 * prior to making this call. If it is not sorted, the results are
	 * undefined.
	 * 
	 * @param list
	 *            the array to be searched.
	 * @param key
	 *            the value to be searched for.
	 * @param c
	 *            the comparator by which the array is sorted.
	 * @return index of the search key, if it is contained in the array within
	 *         the specified range; otherwise -1.
	 */
	private <T> int binarySearch(T[] list, T key, Comparator<? super T> c) {
		if (count == 0)
			return -1;
		return binarySearch(list, 0, count - 1, key, c);
	}

	/**
	 * Searches a range of the specified array for the specified object using
	 * the binary search algorithm. The range must be sorted into ascending
	 * order according to the specified comparator prior to making this call. If
	 * it is not sorted, the results are undefined. If the range contains
	 * multiple elements equal to the specified object, there is no guarantee
	 * which one will be found.
	 * 
	 * @param list
	 *            the array to be searched.
	 * @param fromIndex
	 *            the index of first element to be searched.
	 * @param toIndex
	 *            the index of last element to be searched.
	 * @param key
	 *            the value to be searched for.
	 * @param c
	 *            the comparator by which the array is sorted.
	 * @return index of the search key, if it is contained in the array within
	 *         the specified range; otherwise -1.
	 */
	private <T> int binarySearch(T[] list, int fromIndex, int toIndex, T key,
			Comparator<? super T> c) {

		int middleIndex = (toIndex + fromIndex) / 2;

		if (c.compare(key, list[middleIndex]) == 0) {
			return middleIndex;
		}
		if ((c.compare(key, list[middleIndex]) < 0)
				&& (middleIndex > fromIndex)) {

			return binarySearch(list, fromIndex, middleIndex - 1, key, c);
		}
		if ((c.compare(key, list[middleIndex]) > 0) && (toIndex > middleIndex)) {
			return binarySearch(list, middleIndex + 1, toIndex, key, c);
		}
		return -1;
	}

	private Card[] orderByTitle;
	private Card[] orderByAuthor;
	private Card[] orderBySubject;

	private int count;

	private static final int DEFAULT_SIZE = 10; // Default size for each array
	private static final int GROW_FACTOR = 2;
}
