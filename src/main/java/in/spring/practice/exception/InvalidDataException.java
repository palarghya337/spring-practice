package in.spring.practice.exception;

public class InvalidDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidDataException() {
		// Default Constructor
	}
	public InvalidDataException(String message) {
		super(message);
	}
	public InvalidDataException(Throwable throwable) {
		super(throwable);
	}
	public InvalidDataException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
