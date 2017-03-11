package net.ukr.grygorenko_d;

public class MyThread implements Runnable {
	private int[] array;
	private long sum;

	public MyThread(int[] array, long sum) {
		super();
		this.array = array;
	}

	public MyThread() {
		super();
	}

	public MyThread(int[] array) {
		super();
		this.array = array;
		sum = 0;
	}

	public long getSum() {
		return sum;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		long result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		sum = result;

	}

}
