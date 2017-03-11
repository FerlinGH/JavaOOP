/*
 * Создайте сто потоков которые будут вычислять факториал
числа равного номеру этого потока и выводить результат на
экран
 */
package net.ukr.grygorenko_d;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Thread thr = new Thread(new MyThread(BigInteger.valueOf(i)));
			thr.start();
		}
		System.out.println("End of Main thread.");
	}
}
