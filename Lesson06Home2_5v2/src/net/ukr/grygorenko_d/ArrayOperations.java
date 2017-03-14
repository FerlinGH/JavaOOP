package net.ukr.grygorenko_d;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ArrayOperations {
	private int arraySize;

	public ArrayOperations(int arraySize) {
		super();
		this.arraySize = arraySize;
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

	public List<Callable<Long>> createTasks(int[] array, int threadsAmount) {
		int segmentLength = array.length / threadsAmount;
		List<Callable<Long>> tasks = new ArrayList<>();
		for (int i = 1; i <= threadsAmount; i++) {
			int splitPoint = segmentLength * i;
			int startIndex = splitPoint - segmentLength;
			int endIndex = (i == threadsAmount) ? array.length : splitPoint;
			tasks.add(new SummingThread(array, startIndex, endIndex));
		}
		return tasks;
	}

	public void threadsSummary(List<Callable<Long>> tasks, int threadsAmount) {
		ExecutorService execSer = Executors.newFixedThreadPool(threadsAmount);
		long t1 = System.currentTimeMillis();
		List<Future<Long>> results = null;
		try {
			results = execSer.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long threadsSum = 0L;
		for (Future<Long> future : results) {
			try {
				threadsSum += future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Summing result in Multy-threads: " + threadsSum);
		System.out.println("Calculations took " + (t2 - t1) + " ms.");
		execSer.shutdown();
	}

	public void simpleSummmary(int[] array) {
		long result = 0L;
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Summing result in Single-thread: " + result);
		System.out.println("Calculations took " + (t2 - t1) + " ms.");

	}

}
