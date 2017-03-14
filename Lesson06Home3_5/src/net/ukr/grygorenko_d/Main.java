/*
 * Напишите многопоточный вариант сортировки массива
методом Шелла.
 */
package net.ukr.grygorenko_d;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int threadsAmount = 4; // number of threads (can be changed here)
		ArrayOperations ao = new ArrayOperations(100, threadsAmount); // size of
																		// array
		int[] myArray = ao.fillArray();

		System.out.println("Initial array:"); // comment this lines
		System.out.println(Arrays.toString(myArray)); // if array is large

		int step = myArray.length / 2;

		while (step > 0) {
			System.out.println("Step = " + step);
			ao.sortShell(myArray, step);
			System.out.println(Arrays.toString(myArray));
			step /= 2;
		}

		System.out.println("Sorted array:"); // comment this lines
		System.out.println(Arrays.toString(myArray)); // if array is large
	}

}
