package net.ukr.grygorenko_d;

import java.util.concurrent.Callable;

public class SummingThread implements Callable<Long> {
	private int[] array;
	private int startIndex;
	private int endIndex;

	public SummingThread(int[] array, int startIndex, int endIndex) {
		super();
		this.array = array;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public SummingThread() {
		super();
	}

	@Override
	public Long call() throws Exception {
		long result = 0L;
		for (int i = startIndex; i < endIndex; i++) {
			result += array[i];
		}
		return result;
	}
}
