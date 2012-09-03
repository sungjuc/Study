package lab.l04;

import java.util.Scanner;

import lab.l04.Bookshelf.TextbookNotFoundException;
import lab.l04.Textbook.NegativePagesException;
import lab.l04.Textbook.NegativePriceException;

/**
 * Test drive.
 * 
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 4
 */
public class Menu {

	/**
	 * Test drive for bookshelf class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// options for creating a new Bookshelf of a user-defined size
		mainMenu();

		Scanner keyboard = new Scanner(System.in);
		int input;
		String temp;
		while (true) {
			if ((temp = keyboard.next()).equals("Q"))
				break;
			input = Integer.valueOf(temp);
			switch (input) {
			case 1:
				try {
					createAShelf();
				} catch (IndexOutOfBoundsException ioobe) {
					System.out
							.println("The bookshelf size must be bigger than 1.");
				}
				break;

			case 2:
				System.out.println("2");
				try {
					addABook();
					System.out.println("The book is added successfully!!!");
				} catch (NullPointerException npe) {
					System.out.println("Please make bookshelf first!!!");
				} catch (IndexOutOfBoundsException ioobe) {
					System.out.println("There is no proper position!!!");
				} catch (NegativePagesException npe) {
					System.out.println("The pages cannot be negative!!!");
				} catch (NegativePriceException npe) {
					System.out.println("The price cannot be negative!!!");
				} catch (Exception e) {
					System.out.println("Unkown error is happend");
				} finally {
					endOfMenu();
				}
				break;

			case 3:
				try {
					removeABook();
				} catch (IndexOutOfBoundsException e) {
					System.out
							.println("There is no proper position in the bookshelf");
					e.printStackTrace();
				} catch (TextbookNotFoundException e) {
					System.out
							.println("There is no book to be removed in the position.");
					e.printStackTrace();
				} finally {
					endOfMenu();
				}
				break;

			case 4:
				printABook();
				endOfMenu();
				break;
			case 5:
				printAllBooks();
				endOfMenu();
				break;
			}
		}
	}

	/**
	 * Prints the main menu.
	 */
	private static void mainMenu() {
		System.out.println("#################################");
		System.out.println("           Main Menu             ");
		System.out.println("#################################");
		System.out.println(" 1. Creating a new Bookshelf     ");
		System.out.println(" 2. Adding a new book            ");
		System.out.println(" 3. Removing a book              ");
		System.out.println(" 4. Printing individual books    ");
		System.out.println(" 5. Printing a list of titles    ");
		System.out.println("#################################");
	}

	/**
	 * Creates an instance of bookshelf. This method receives an integer value
	 * for the size of the bookshelf, then creates an bookshelf with the size.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the size is smaller than 0.
	 */
	private static void createAShelf() throws IndexOutOfBoundsException {
		System.out.print("Input the maximum number of books in the shelf >> ");
		Scanner keyboard = new Scanner(System.in);
		int size = keyboard.nextInt();

		bookshelf = new Bookshelf(size);

		System.out.println();
		System.out.println("The book shelf is successfully created!!!");
		endOfMenu();
	}

	/**
	 * Adds a book into the bookshelf. This method receives position value as
	 * user input. Then, it receives the information of the book to make an
	 * instance of the book to be inserted. Once the book is created, it is
	 * inserted into the position of the bookshelf. If a book already in the
	 * position, the book will be overwritten by a new book.
	 * 
	 * @throws NegativePagesException
	 *             if the number of pages is smaller than 0.
	 * @throws NegativePriceException
	 *             if the price is smaller than 0.
	 * @throws IndexOutOfBoundsException
	 *             if the position is bigger than the maximum position of the
	 *             bookshelf or smaller than 0.
	 */
	private static void addABook() throws NegativePagesException,
			NegativePriceException, IndexOutOfBoundsException {
		System.out.print("Input the position in the bookshelf >> ");
		Scanner keyboard = new Scanner(System.in);
		int position = keyboard.nextInt();

		System.out.print("Input the title >> ");
		keyboard = new Scanner(System.in);
		String title = keyboard.nextLine();
		System.out.print("Input the author >> ");
		keyboard = new Scanner(System.in);
		String author = keyboard.nextLine();
		System.out.print("Input the price >> ");
		keyboard = new Scanner(System.in);
		float price = keyboard.nextFloat();
		System.out.print("Input the pages >> ");
		keyboard = new Scanner(System.in);
		int pages = keyboard.nextInt();
		System.out.print("Input the comments >> ");
		keyboard = new Scanner(System.in);
		String comments = keyboard.nextLine();

		System.out.println();

		Textbook aBook = new Textbook(title, author, pages, price, comments);

		bookshelf.addABook(position, aBook);
	}

	/**
	 * Removes a book from the bookshelf. This method receives a position value
	 * from user and try to remove a book in the position.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the position is bigger than the maximum position of the
	 *             bookshelf or smaller than 0.
	 * @throws TextbookNotFoundException
	 *             if there is no text book in the position.
	 */
	private static void removeABook() throws IndexOutOfBoundsException,
			TextbookNotFoundException {
		System.out
				.print("Input the position of the books in the bookshelf >> ");
		Scanner keyboard = new Scanner(System.in);
		int position = keyboard.nextInt();
		bookshelf.removeABook(position);
	}

	/**
	 * Prints the information of the book. This method receives a position value
	 * from user input and print the information about the book.
	 * 
	 * If the position value is not valid, it will print out the error message
	 * and return back to menu. If there is no text book in the position, it
	 * will print out the error message and return back to menu.
	 */
	private static void printABook() {
		System.out.println();
		System.out.println("Input the position of the books to be printed >> ");
		Scanner keyboard = new Scanner(System.in);
		int position = keyboard.nextInt();
		Textbook book;
		try {
			book = bookshelf.getABook(position);
			System.out.println(book.toString());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("There is no position in the bookshelf");
		} catch (TextbookNotFoundException e) {
			System.out.println("There is no book in the bookshelf");
		}
	}

	/**
	 * Prints all books in the bookshelf.
	 */
	private static void printAllBooks() {
		System.out.println();
		System.out.println("Printing all text books in the bookshelf...");
		System.out.println();

		System.out.println(bookshelf.getAlist());

	}

	/**
	 * Indicates the end of each menu and let user return back to main menu.
	 */
	private static void endOfMenu() {
		System.out.println();
		System.out.print("Press any key to go back to main menu >>  ");
		Scanner keyboard = new Scanner(System.in);
		if (keyboard.hasNext()) {
			System.out.println();
			System.out.println();
			mainMenu();
		}
	}

	private static Bookshelf bookshelf;

}
