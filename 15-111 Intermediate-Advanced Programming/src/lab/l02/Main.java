package lab.l02;

import java.io.FileNotFoundException;

/**
 * Test drive for the Cryptography lab
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 1
 */
public class Main {
	/**
	 * Test drive for the Cryptography lab
	 * 
	 * @param agrs
	 * @throws FileNotFoundException
	 */
	public static void main(String[] agrs) throws FileNotFoundException {
		// Create encoder and decoder
		Encoder encoder = new Encoder("test/lab/l02/code.txt");
		Decoder decoder = new Decoder("test/lab/l02/code.txt");

		// Encoding and Decoding test
		String original = "abcd1234zyx!@#$";
		String encoded = encoder.encodeString(original);
		String decoded = decoder.decodeString(encoded);
		System.out.println("Original: " + original + "\tEncoded: " + encoded);
		System.out.println("Decoded: " + decoded);

		// Encoding a file and decoding the file
		String encodedFile = encoder.encodeFile("test/lab/l02/TestFile");
		String originalFile = decoder.decodeString(encodedFile);
		System.out.println("Encoded File: " + encodedFile + "\tOriginal File: "
				+ originalFile);
		String decodedFile = decoder.decodeFile("test/lab/l02/TestFile");
		originalFile = encoder.encodeString(decodedFile);
		System.out.println("Decoded File: " + decodedFile + "\tOriginal File: "
				+ originalFile);
	}
}
