package lab.l02;

import java.io.FileNotFoundException;

import junit.framework.TestCase;

public class DecoderTest extends TestCase {
	private Decoder decoder = null;

	protected void setUp() throws FileNotFoundException {
		this.decoder = new Decoder("test/lab/l02/code.txt");
	}

	public void testDecoder() {
		assertNotNull(decoder);
	}

	public void testDecodeString() throws FileNotFoundException {
		String result = decoder.decodeString("abcdefghi");
		assertEquals("zabcdefgh", result);

		result = decoder.decodeString("12b4%");
		assertEquals("12a4%", result);
	}

	public void testDecodeFile() throws FileNotFoundException {
		String filename = "test/lab/l02/TestFile";
		String result = decoder.decodeFile(filename);
	}
}
