package net.ukr.grygorenko_d;

public class MyException extends Exception {
	@Override
	public String getMessage() {
		return "Error! Group is full, cannot add another student!";
	}
}