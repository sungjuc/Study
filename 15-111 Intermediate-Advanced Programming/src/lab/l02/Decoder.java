package lab.l02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Decoder class represents a decoder which keeps the decoding and encoding
 * character sets in a hash table. The decoder can decode a string and a file.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 2
 */
public class Decoder {
	/**
	 * Returns a string decoded from given string.
	 * 
	 * @param str
	 *            a string to be decoded.
	 * @return the decoded string.
	 */
	public String decodeString(String str) {
		char[] strs = str.toCharArray();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			result.append(table.get(String.valueOf(strs[i])));
		}

		return result.toString();
	}

	/**
	 * Returns a string decoded from the contents of the file.
	 * 
	 * @param filename
	 *            the file contains characters to be decoded.
	 * @return the decoded string.
	 * @throws FileNotFoundException
	 *             if the file is not found.
	 */
	public String decodeFile(String filename) throws FileNotFoundException {
		Scanner file = new Scanner(new File(filename));
		StringBuffer result = new StringBuffer();
		while (file.hasNext()) {
			result.append(decodeString(file.next()));
		}
		return result.toString();
	}

	/**
	 * Constructs new Decoder object filled with the data from file.
	 * 
	 * @param filename
	 *            the file contains the pairs of characters.
	 * @throws FileNotFoundException
	 *             if the file is not found.
	 */
	public Decoder(String filename) throws FileNotFoundException {
		// Building hash table from the file name
		// Since input string is encoded string, you may not know the original
		// string
		Scanner file = new Scanner(new File(filename));
		table = new HashTable();

		String key;
		String value;

		// Read all data from file
		while (file.hasNext()) {
			value = file.next();
			key = file.next();
			table.add(key, new Item(key, value));
		}
	}

	private HashTable table;
}
