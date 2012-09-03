package lab.l02;

import java.io.FileNotFoundException;

import junit.framework.TestCase;

public class EncoderTest extends TestCase {
	private Encoder encoder = null;

	protected void setUp() throws FileNotFoundException {
		encoder = new Encoder("test/lab/l02/code.txt");
	}

	public void testEncoder() throws FileNotFoundException {
		this.setUp();
		assertNotNull(encoder);
	}

	public void testEncodeString() throws FileNotFoundException {
		String result = encoder.encodeString("abcdefghi");
		assertEquals("bcdefghij", result);

		result = encoder.encodeString("12b4%");
		assertEquals("12c4%", result);
	}

	public void testEncodeFile() throws FileNotFoundException {
		String filename = "test/lab/l02/TestFile";
		String result = encoder.encodeFile(filename);
	}
}
