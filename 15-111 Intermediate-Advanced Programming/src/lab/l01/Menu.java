package lab.l01;

import java.util.Scanner;

/**
 * Menu class which provides the user interface to the <i>Card Catalog</i>
 * application. Once this starts, it provides the menu storing various options
 * to work with the <i>Card Catalog</i> application.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 1
 * @see Card, CardCatalog
 */
public class Menu {
	/**
	 * Start point of this menu application for <i>Card Catalog</i>.
	 */
	public static void main(String[] args) {
		// Show main menu first.
		printMainMenu();

		// Define console input
		Scanner keyboard = new Scanner(System.in);
		String input;

		// Check the input option and quit if the selected option is quit
		// program.
		while ((input = keyboard.next()) != "Q") {
			// Creating catalog option selection
			if (input.equals("C")) {
				createCatalog();
				continue;
			}

			// Adding book option selection
			if (input.equals("A")) {
				if (!checkCatalog())
					continue;
				addBook();
				continue;
			}
			// Search book option selection
			if (input.equals("S")) {
				if (!checkCatalog())
					continue;
				if (!isEmptyCatalog())
					continue;
				searchBook();
				continue;
			}

			// Removing book option selection
			if (input.equals("R")) {
				if (!checkCatalog())
					continue;
				if (!isEmptyCatalog())
					continue;
				removeBook();
				continue;
			}

			// Print the list of books.
			if (input.equals("P")) {
				if (!checkCatalog())
					continue;
				if (!isEmptyCatalog())
					continue;
				printBook();
				continue;
			}
		}
	}

	/**
	 * Creates a catalog instance. If there already is a catalog, it is replaced
	 * with new catalog.
	 */
	public static void createCatalog() {
		// Creates the catalog instance.
		catalog = new CardCatalog();
		System.out.println("");
		System.out.println("A new catalog is successfully created!!!");
		System.out.println("");
		System.out.println("");
		printMainMenu();
	}

	/**
	 * Adds a card to the catalog.
	 */
	public static void addBook() {
		// Basic variable definition
		Scanner input = new Scanner(System.in);
		String title;
		String author;
		String subject;

		// Check whether the catalog is created or not.
		if (catalog == null) {
			// If there is no catalog, print warning message and return to the
			// main menu.
			System.out.println("Please create a catalog first!!!");
			System.out.println("To continue input any character!");
			input.next();
			printMainMenu();
			return;
		}

		// Gather information about book.
		System.out.print("Input the title of book: ");
		title = input.next();
		System.out.print("Input the author of book: ");
		author = input.next();
		System.out.print("Input the subject of book: ");
		subject = input.next();

		// Create a card and add it into catalog.
		Card book = new Card(title, author, subject);
		catalog.addACard(book);

		// Shows the
		System.out.println("Successfully add the book (" + book.toString()
				+ ")");

		// Preparing next steps.
		System.out.println("To continue input any character!");
		input.next();
		printMainMenu();
	}

	/**
	 * Removes books from the catalog. Inside this function, user should insert
	 * the title of the book to be removed.
	 */
	public static void removeBook() {
		Scanner input = new Scanner(System.in);
		System.out.println("The belows are the list of book:");
		catalog.printTheCatalog(0);

		System.out
				.println("Please select the title to be removed from the catalog.");

		String title = input.next();
		int number = 0;

		// Remove books and print how many books are deleted.
		if ((number = catalog.removeAtitle(title)) > 0) {
			System.out.println("Total " + number + " book(s) have(has) title, "
					+ title + " is(are) removed from catalog!!!");
		}

		// Prepares next steps.
		System.out.println("To continue input any character!");
		input.next();
		printMainMenu();
	}

	/**
	 * Searches book with its title, author and subject.
	 */
	public static void searchBook() {
		// Basic variable definition
		Scanner input = new Scanner(System.in);

		System.out.println("Please select the soring option.");
		System.out.println("\t0 - Title");
		System.out.println("\t1 - Author");
		System.out.println("\t2 - Subject");

		int mode = input.nextInt();
		while (mode < 0 || mode > 2) {
			System.out.println("Invalid option! Please select valid option!");
			System.out.println("\t0 - Title");
			System.out.println("\t1 - Author");
			System.out.println("\t2 - Subject");
		}

		System.out.println("Please input keyword!!!");
		String keyword = input.next();
		Card[] results;
		Card result;

		// Branch based on the search option.
		switch (mode) {
		case 0:
			try {
				result = catalog.getATitle(keyword);
				System.out.println(result);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			break;

		case 1:
			results = catalog.getAnAuthor(keyword);
			if (results != null) {
				for (int i = 0; i < results.length; i++) {
					System.out.println(results[i]);
				}
			} else
				System.out.println("There is no search results!!!");
			break;

		case 2:
			results = catalog.getSubject(keyword);
			if (results != null) {
				for (int i = 0; i < results.length; i++) {
					System.out.println(results[i]);
				}
			} else
				System.out.println("There is no search results!!!");
			break;
		}

		System.out.println("Finding is done!!!");

		System.out.println("To continue input any character!");
		input.next();
		printMainMenu();
	}

	/**
	 * Prints books in order by title, author and subject.
	 */
	public static void printBook() {
		// Basic variable definition
		Scanner input = new Scanner(System.in);

		System.out.println("Please select the soring option.");
		System.out.println("\t0 - Title");
		System.out.println("\t1 - Author");
		System.out.println("\t2 - Subject");

		int mode = input.nextInt();
		while (mode < 0 || mode > 2) {
			System.out.println("Invalid option! Please select valid option!");
			System.out.println("\t0 - Title");
			System.out.println("\t1 - Author");
			System.out.println("\t2 - Subject");
		}

		catalog.printTheCatalog(mode);
		System.out.println("Printing is done!!!");

		System.out.println("To continue input any character!");
		input.next();
		printMainMenu();
	}

	/**
	 * Prints main menu.
	 */
	public static void printMainMenu() {
		// Main menu
		System.out.println("=========================================");
		System.out.println("            Card Catalog Menu ");
		System.out.println("=========================================");
		System.out.println(" C: Creating a new card catalog ");
		System.out.println(" A: Add book ");
		System.out.println(" R: Remove book ");
		System.out.println(" S: Search book ");
		System.out.println(" P: Print the list of books ");
		System.out.println(" Q: Quit ");
		System.out.println("=========================================");
		System.out.println("");
		System.out.print("Select menu > ");
	}

	/**
	 * Checks whether a catalog is created or not.
	 * 
	 * @return if there is a catalog, true, otherwise, false.
	 */
	private static boolean checkCatalog() {
		Scanner input = new Scanner(System.in);

		// Check whether the catalog is created or not.
		if (catalog == null) {
			// If there is no catalog, print warning message and return to the
			// main menu.
			System.out.println("Please create a catalog first!!!");
			System.out.println("To continue input any character!");
			input.next();
			printMainMenu();
			return false;
		}
		return true;
	}

	/**
	 * Checks that the catalog is empty.
	 * 
	 * @return if the catalog has at least one book, true, otherwise, false.
	 */
	private static boolean isEmptyCatalog() {
		Scanner input = new Scanner(System.in);
		if (catalog.size() == 0) {
			System.out
					.println("There is no card in the catalog. Please create card first!!!");
			System.out.println("To continue input any character!");
			input.next();
			printMainMenu();
			return false;
		}
		return true;
	}

	private static CardCatalog catalog;
}
