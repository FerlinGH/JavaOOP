/*
 * Реализуйте многопоточное копирование каталога,
содержащего несколько файлов.
 */
package net.ukr.grygorenko_d;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File sourceDir = new File("Source"); // already exists with some files;
		File destDir = new File("Destination");
		destDir.mkdir();
		System.out.println("Source directory contains:");
		for (String entry : sourceDir.list()) {
			System.out.println(entry);
		}
		System.out.println();

		File[] toCopy = sourceDir.listFiles();
		Thread[] threads = new Thread[toCopy.length];
		System.out.print("Copying files... Please wait, this can take some time...");
		for (int i = 0; i < toCopy.length; i++) {
			threads[i] = new Thread(new FileCopier(toCopy[i], destDir));
			threads[i].start();
		}
		for (Thread thread : threads) {
			if (thread.isAlive()) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println(" Success!");
		System.out.println("Destination derectory contains:");
		for (String entry : destDir.list()) {
			System.out.println(entry);
		}

	}

}
