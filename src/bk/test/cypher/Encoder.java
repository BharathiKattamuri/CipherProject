package bk.test.cypher;

public interface Encoder {
	
	public String encryptCode(String myStr) throws InvalidInputException;
	public String decryptCode(String myStr) throws InvalidInputException;

}
