package bk.test.cypher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class has two methods to encode and decode.  Encode method can encode/cypher a given string.
 * and Decode method can decode and gives the original string back. 
 * @author bkat
 *
 */
public class EncodeUtil implements Encoder {
	
	// setting these static values for extendability.
	public static final String VALID_REGEX_FORMAT = "^[A-Z]{1,10}$";
	public static final int LOWER_ASCII_CODE = 65;
	public static final int UPPER_ASCII_CODE = 90;
	public static final int SHIFT_VAL = 3;
	
	/**
	 * encodes the given string by forward shifting the given value by SHIFT_VAL steps.
	 */
	public String encryptCode(String myStr) throws InvalidInputException {

		String cypStr = "";
		if (isValidInput(myStr)) {
			char[] cArray = myStr.toCharArray();
			for (char c : cArray) {
				// here we are checking if c+3 is greater than upper limit.
				// eg. Z+3 will be circled back to value C for default constant values.
				// cypNum = c+3 <= 90? c+3: 65 +((c+3) -91)
				int cypNum = c + SHIFT_VAL <= UPPER_ASCII_CODE ? c + SHIFT_VAL
						: LOWER_ASCII_CODE + ((c + SHIFT_VAL)-(UPPER_ASCII_CODE + 1));
				cypStr = cypStr + (char) (cypNum);
			}
		}
		return cypStr;
	}
	
	public String decryptCode(String myStr) throws InvalidInputException {
		String decypStr = "";
		if (isValidInput(myStr)) {
			char[] cArray = myStr.toCharArray();
			for (char c : cArray) {
				// here we are checking if c-3 is less than lower limit.
				// eg. A -3 will be circled back to value X for default constant values.
				// cypNum = c -3 >= 65 ? c-3 : 90 - (64 -(c-3))
				int cypNum = c - SHIFT_VAL >= LOWER_ASCII_CODE ? c - SHIFT_VAL
						: UPPER_ASCII_CODE - ((LOWER_ASCII_CODE - 1) - (c - SHIFT_VAL));
				decypStr = decypStr + (char) (cypNum);
			}
		}
		return decypStr;
	}

	private boolean isValidInput(String myStr) throws InvalidInputException {
		Pattern p = Pattern.compile(VALID_REGEX_FORMAT);
		Matcher m = p.matcher(myStr);
		if (m.matches()) return true;
		else throw new InvalidInputException();
	}
	
	
}
