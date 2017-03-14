package net.ukr.grygorenko_d;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayOperations {
	private int arraySize;
	private int threadsAmount;

	public ArrayOperations(int arraySize, int threadsAmount) {
		super();
		this.arraySize = arraySize;
		this.threadsAmount = threadsAmount;
	}

	public ArrayOperations() {
		super();
	}

	public int[] fillArray() {
		int[] array = new int[arraySize];
		Random rand = new Random();
		for (int i = 0; i < arraySize; i++) {
			array[i] = rand.nextInt(100);
		}
		return array;
	}

	public void sortShell(int[] myArray, int step) {
		ExecutorService execSer = Executors.newFixedThreadPool(threadsAmount);
		List<Runnable> tasks = new ArrayList<>();
		for (int i = 0; i < step; i++) {
			tasks.add(new SortingThread(myArray, i + step, step));
		}
		for (Runnable task : tasks) {
			execSer.execute(task);
		}
		execSer.shutdown();

	}

}
