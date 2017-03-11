/*
 * Написать код для многопоточного подсчета суммы элементов
массива целых чисел. Сравнить скорость подсчета с простым
алгоритмом.
 */
package net.ukr.grygorenko_d;

public class Main {

	public static void main(String[] args) {
		int threadsAmount = 2; // number of threads (can be changed here)
		ArrayOperations ao = new ArrayOperations(40000000);		//size of the array
		int[] myArray = ao.fillArray();

		MyThread[] myThreadsArray = ao.createMyThreadsArray(myArray, threadsAmount);
		Thread[] threadsArray = ao.createThreadsArray(myThreadsArray);
		
		System.out.println("Multy-thread calculation.");
		ao.calculate(threadsArray, myThreadsArray);
		System.out.println();

		MyThread[] mySingleThread = ao.createMyThreadsArray(myArray, 1);
		Thread[] singleThread = ao.createThreadsArray(mySingleThread);
		System.out.println("Single-thread calculation");
		ao.calculate(singleThread, mySingleThread);
	}
}
