package cst8284.lab6;

public class BadAccountInputException extends java.lang.RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BadAccountInputException() {
		
	} // no-arg constructor
	
	public  BadAccountInputException(String message) {
		super(message);
	}
}
