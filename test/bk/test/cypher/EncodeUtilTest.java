package bk.test.cypher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EncodeUtilTest {

	Encoder encoder = new EncodeUtil();;

	@Test
	public void testEcryptGeneric() throws InvalidInputException {
		assertEquals("KHOOR", encoder.encryptCode("HELLO")); // encode testing simple case
		assertEquals("DEFG", encoder.encryptCode("ABCD")); // encode testing lower boundary
		assertEquals("ZABC", encoder.encryptCode("WXYZ")); // encode testing upper boundary
		assertEquals("G", encoder.encryptCode("D")); // test size small
		assertEquals("KHOORKHOOR", encoder.encryptCode("HELLOHELLO")); // test 10 char
	}

	@Test
	public void testDecryptGeneric() throws InvalidInputException {
		assertEquals("HELLO", encoder.decryptCode("KHOOR")); // decode testing simple case
		assertEquals("ABCD", encoder.decryptCode("DEFG")); // decode testing lower boundary");
		assertEquals("WXYZ", encoder.decryptCode("ZABC")); // decode testing upper boundary");
	}

	@Test
	public void testValidation() {
		try {
			encoder.encryptCode(""); // test blank
		} catch (InvalidInputException e) {
			assert (true);
		}
		try {
			encoder.encryptCode("HELLOHELLOH"); // test 11 chars
		} catch (InvalidInputException e) {
			assert (true);
		}
		try {
			encoder.encryptCode("abdg"); // test lowercase
		} catch (InvalidInputException e) {
			assert (true);
		}
		try {
			encoder.encryptCode("abdgfg343"); // test alphanumeric
		} catch (InvalidInputException e) {
			assert (true);
		}
	}
}
