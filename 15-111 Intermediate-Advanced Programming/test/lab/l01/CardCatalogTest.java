package lab.l01;

import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Test cases for CardCatalog.
 * 
 * @author sungju.cho
 * @version 15-111 intermediate/Advanced Programming
 * @see CardCatalog
 */
public class CardCatalogTest extends TestCase {
	private Card[] cards;
	private Card[] growTestCards;
	private Card[] authorTestCards;
	private CardCatalog catalog;
	private CardCatalog authorTestCatalog;

	@Override
	protected void setUp() {
		// Preparing a new array has 4 elements which is used for tests.
		cards = new Card[4];
		cards[0] = new Card("Java Tutorial", "Greg Kesden", "Computer");
		cards[1] = new Card("Homels", "Conan Doyle", "Novel");
		cards[2] = new Card("The Age of Turbulance", "Alan Greenspan", "Essay");
		cards[3] = new Card("The C Programming Language", "None", "Computer");

		authorTestCards = new Card[4];
		authorTestCards[0] = new Card("Java Tutorial", "None", "Computer");
		authorTestCards[1] = new Card("Homels", "Conan Doyle", "Novel");
		authorTestCards[2] = new Card("The Age of Turbulance",
				"Alan Greenspan", "Essay");
		authorTestCards[3] = new Card("The C Programming Language", "None",
				"Computer");

		// Preparing a catalog which is filled with the elements of the above
		// card arrays.
		catalog = new CardCatalog();
		for (int index = 0; index < cards.length; index++) {
			catalog.addACard(cards[index]);
		}

		// Preparing a catalog which is filled with the elements of the above
		// card arrays.
		authorTestCatalog = new CardCatalog();
		for (int index = 0; index < authorTestCards.length; index++) {
			authorTestCatalog.addACard(authorTestCards[index]);
		}

		// Preparing a new array has 30 elements which is used for grow test.
		growTestCards = new Card[30];
		for (int index = 0; index < growTestCards.length; index++) {
			growTestCards[index] = new Card("", "", "");
		}
	}

	/**
	 * Checks the constructor.
	 */
	public void testCardCatalog() {
		CardCatalog testCatalog = new CardCatalog();

		assertNotNull(testCatalog);
	}

	/**
	 * Checks the there is no errors in adding items in the catalog.
	 */
	public void testAddACard() {
		CardCatalog testCatalog = new CardCatalog();

		assertNotNull(testCatalog);

		for (int index = 0; index < cards.length; index++) {
			testCatalog.addACard(cards[index]);
		}
		assertNotNull(testCatalog);
	}

	/**
	 * Checks the CardCatalog.grow() functions.
	 */
	public void testGrow() {
		CardCatalog testCatalog = new CardCatalog();
		assertNotNull(testCatalog);

		for (int index = 0; index < growTestCards.length; index++) {
			testCatalog.addACard(growTestCards[index]);
		}
		assertNotNull(testCatalog);

	}

	/**
	 * Checks the CardCatalog.getAtitle() method.
	 * 
	 * @throws Exception
	 */
	public void testGetATitle() throws Exception {
		assertEquals(catalog.getATitle(cards[0].getTitle()), cards[0]);
		assertEquals(catalog.getATitle(cards[1].getTitle()), cards[1]);
		assertEquals(catalog.getATitle(cards[2].getTitle()), cards[2]);
		assertEquals(catalog.getATitle(cards[3].getTitle()), cards[3]);
	}

	/**
	 * Checks the CardCatalog.getAnAuthor() method.
	 */
	public void testGetAnAuthor() {
		assertTrue(Arrays.equals(catalog.getAnAuthor(cards[0].getAuthor()),
				new Card[] { cards[0] }));
		assertTrue(Arrays.equals(catalog.getAnAuthor(cards[1].getAuthor()),
				new Card[] { cards[1] }));
		assertTrue(Arrays.equals(catalog.getAnAuthor(cards[2].getAuthor()),
				new Card[] { cards[2] }));
		assertTrue(Arrays.equals(catalog.getAnAuthor(cards[3].getAuthor()),
				new Card[] { cards[3] }));

		assertNull(catalog.getAnAuthor("null author"));

		assertTrue(Arrays.equals(authorTestCatalog
				.getAnAuthor(authorTestCards[0].getAuthor()), new Card[] {
				authorTestCards[0], authorTestCards[3] }));

		assertTrue(Arrays.equals(authorTestCatalog
				.getAnAuthor(authorTestCards[1].getAuthor()),
				new Card[] { authorTestCards[1] }));
	}

	/**
	 * Checks the CardCatalog.getSubject() method.
	 */
	public void testGetSubject() {
		String keyword = "Com";
		Card[] results = catalog.getSubject(keyword);
		assertEquals(2, results.length);
		for (int i = 0; i < results.length; i++) {
			assertTrue(results[i].getSubject().contains(keyword));
		}

		keyword = "o";
		results = catalog.getSubject(keyword);
		assertEquals(3, results.length);
		for (int i = 0; i < results.length; i++) {
			assertTrue(results[i].getSubject().contains(keyword));
		}
	}

	/**
	 * Checks the CardCatalog.printATitle() method.
	 */
	public void testPrintATitle() {
		System.out.println("************************");
		catalog.printTheCatalog(0);
		System.out.println("************************");
		catalog.printTheCatalog(1);
		System.out.println("************************");
		catalog.printTheCatalog(2);
		System.out.println("************************");
	}

	/**
	 * Checks the CardCatalog.removeATitle() method.
	 */
	public void testRemoveATitle() {
		assertEquals(1, catalog.removeAtitle(cards[0].getTitle()));

		assertEquals(1, catalog.removeAtitle(cards[1].getTitle()));

		assertEquals(1, catalog.removeAtitle(cards[2].getTitle()));

		assertEquals(1, catalog.removeAtitle(cards[3].getTitle()));
	}

}
