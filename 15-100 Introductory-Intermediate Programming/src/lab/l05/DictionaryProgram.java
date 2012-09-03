package lab.l05;

import java.util.Scanner;

/**
 * The class represents Dictionary Program providing the user interface.
 * 
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 5
 */
public class DictionaryProgram {
	public static void main(String[] args) {
		mainMenu();

		Scanner keyboard = new Scanner(System.in);
		String input;
		while (true) {
			if ((input = keyboard.next()).equals("Q"))
				break;

			int menu = Integer.parseInt(input);

			switch (menu) {
			case 1:
				createANewDictionary();
				break;

			case 2:
				addAWord();
				break;

			case 3:
				findAWord();
				break;

			case 4:
				printAllWord();
				break;

			case 5:
				printAllWordBeginsWith();
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
		System.out.println(" 1. Creating a new Dictionary    ");
		System.out.println(" 2. Adding a word                ");
		System.out.println(" 3. Finding a word               ");
		System.out.println(" 4. Printing a list of words     ");
		System.out.println(" 5. A list of words begins with a String");
		System.out.println(" Q. Exit                         ");
		System.out.println("#################################");
	}

	/**
	 * Creates a new Dictionary.
	 */
	public static void createANewDictionary() {
		System.out.println("Please input the capacity of new Dictionary >> ");
		Scanner keyboard = new Scanner(System.in);
		try {
			int capacity = keyboard.nextInt();
			dictionary = new Dictionary(capacity);
		} catch (Exception e) {
			System.out.println("Input correct number.");
		} finally {
			endOfMenu();
		}
	}

	/**
	 * Prints the end of menu.
	 */
	public static void endOfMenu() {
		System.out.println();
		System.out.println("Press any key to go back to main menu >> ");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.next();
		System.out.println();
		mainMenu();
	}

	/**
	 * Adds a word into the Dictionary.
	 */
	public static void addAWord() {
		System.out.println();
		System.out.println("Input the word to be inserted >> ");
		Scanner keyboard = new Scanner(System.in);
		String word = keyboard.next();
		keyboard = new Scanner(System.in);
		System.out.println("Input the meaning of the word >> ");
		String meaning = keyboard.nextLine();
		Definition definition = new Definition(word, meaning);
		dictionary.add(definition);
		endOfMenu();
	}

	/**
	 * Finds a word from the Dictionary.
	 */
	public static void findAWord() {
		System.out.println();
		System.out.println("Input the word to be found >> ");
		Scanner keyboard = new Scanner(System.in);
		String word = keyboard.next();
		try {
			String meaning = dictionary.findMeaning(word);
			System.out.println(word + " : " + meaning);
		} catch (Dictionary.WordNotFoundException wnfe) {
			System.out.println(wnfe.toString());
		}
		endOfMenu();
	}

	/**
	 * Prints the list of all word in the Dictionary.
	 */
	public static void printAllWord() {
		System.out.println();
		System.out.println(dictionary.toString());
		endOfMenu();
	}

	/**
	 * Prints the list of word starts with given characters.
	 */
	public static void printAllWordBeginsWith() {
		System.out.println();
		System.out.println("Input the word to starts with >> ");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.next();
		Dictionary newDic = dictionary.beginsWith(input);
		System.out.println(newDic.toString());
		endOfMenu();
	}

	private static Dictionary dictionary;
}
