package net.ukr.grygorenko_d;

public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return super.getMessage();
	}

}
