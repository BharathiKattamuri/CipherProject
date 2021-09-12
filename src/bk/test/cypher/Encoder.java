package bk.test.cypher;

public interface Encoder {
	/**
	 * Method encodes the given string and returns the encoded string.
	 * @param myStr
	 * @return
	 * @throws InvalidInputException
	 */
	public String encryptCode(String myStr) throws InvalidInputException;
	
	/**
	 * Method decodes the given string and return the decoded string. 
	 * @param myStr
	 * @return
	 * @throws InvalidInputException
	 */
	public String decryptCode(String myStr) throws InvalidInputException;

}
