package week5.friday.bank.exception;

public class AgeException extends Exception {
	private static final long serialVersionUID = 1798746547050576140L;

	public AgeException() {
	}

	public AgeException(String message) {
		super(message);
	}
}
