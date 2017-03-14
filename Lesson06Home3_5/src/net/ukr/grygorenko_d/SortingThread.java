package net.ukr.grygorenko_d;

public class SortingThread implements Runnable {
	private int[] array;
	private int secondCell;
	private int step;

	public SortingThread(int[] array, int secondCell, int step) {
		super();
		this.array = array;
		this.secondCell = secondCell;
		this.step = step;
	}

	public SortingThread() {
		super();
	}

	public void compareTwo(int cell) {
		for (int i = cell; i < array.length; i += step) {
			if (array[i] < array[i - step]) {
				int temp = 0;
				temp = array[i];
				array[i] = array[i - step];
				array[i - step] = temp;
				if ((i - 2 * step) >= 0) {
					compareTwo(i - step);
				}
			}
		}
	}

	@Override
	public void run() {
		compareTwo(secondCell);
	}

}
