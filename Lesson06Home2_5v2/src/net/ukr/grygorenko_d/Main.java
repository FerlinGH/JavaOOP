/*
 * Написать код для многопоточного подсчета суммы элементов
массива целых чисел. Сравнить скорость подсчета с простым
алгоритмом.
 */
package net.ukr.grygorenko_d;

import java.util.List;
import java.util.concurrent.Callable;

public class Main {

	public static void main(String[] args) {
		int threadsAmount = 8; // number of threads (can be changed here)
		ArrayOperations ao = new ArrayOperations(170000000); // size of the
																// array
		int[] myArray = ao.fillArray();

		List<Callable<Long>> tasks = ao.createTasks(myArray, threadsAmount);

		ao.threadsSummary(tasks, threadsAmount);
		System.out.println();
		ao.simpleSummmary(myArray);
	}

}
