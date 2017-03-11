package net.ukr.grygorenko_d;

import java.util.Arrays;
import java.util.Random;

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

	public MyThread[] createMyThreadsArray(int[] array, int threadsAmount) {
		int segmentLength = array.length / threadsAmount;
		MyThread[] threadsArray = new MyThread[threadsAmount];
		for (int i = 1; i <= threadsAmount; i++) {
			int splitPoint = segmentLength * i;
			int startIndex = splitPoint - segmentLength;
			int endIndex = (i == threadsAmount) ? array.length : splitPoint;
			int[] tempArray = Arrays.copyOfRange(array, startIndex, endIndex);
			threadsArray[i-1] = new MyThread(tempArray);
		}

		return threadsArray;
	}
	
	public Thread[] createThreadsArray(MyThread[] myThreadsArray){
		Thread[] threadsArray = new Thread[myThreadsArray.length];
		for (int i = 0; i < myThreadsArray.length; i++) {
			threadsArray[i] = new Thread(myThreadsArray[i]);
		}
		return threadsArray;
	}
	
	public void calculate(Thread[] threadsArray, MyThread[] myThreadsArray){
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < threadsArray.length; i++) {
			threadsArray[i].start();
		}
		for (int i = 0; i < threadsArray.length; i++) {	
			try {
				threadsArray[i].join();		
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		long result = getResult(myThreadsArray);
		long t2 = System.currentTimeMillis();
		System.out.println("Calculated sum  = " + result);
		System.out.println("Calculations took " + (t2 - t1) + " ms.");
		
	}
	
	public long getResult(MyThread[] myThreadsArray){
		long result = 0;
		for (int i = 0; i < myThreadsArray.length; i++) {
			if(myThreadsArray[i].getSum() == 0){
				System.out.println("Error: Thread " + i + " has failed to join() ! Calculation's result is unreliable!");
				break;
			}else{
				result += myThreadsArray[i].getSum();
			}
		}
		return result;
	}

}
