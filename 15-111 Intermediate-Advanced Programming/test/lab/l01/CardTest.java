package lab.l01;

import junit.framework.TestCase;

/**
 * Test cases for CardCatalog.
 * 
 * @author sungju.cho
 * @version 15-111 intermediate/Advanced Programming
 * @see Card
 */
public class CardTest extends TestCase {
	/**
	 * Checks the constuctor and getter/setter methods.
	 */
	public void testCard() {
		String title = "Java Tutorial";
		String author = "Greg Kesden";
		String subject = "Computer Programming";
		String message = "Title: " + title + "\tAuthor: " + author
				+ "\tSubject: " + subject;

		Card testCard = new Card(title, author, subject);

		assertNotNull(testCard);
		assertEquals(testCard.getTitle(), title);
		assertEquals(testCard.getAuthor(), author);
		assertEquals(testCard.getSubject(), subject);
		assertEquals(testCard.toString(), message);
	}
}
