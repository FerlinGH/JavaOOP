/*
 * Реализуйте процесс многопоточного поиска файла в
файловой системе. Т.е. вы вводите название файла и в какой
части файловой системы его искать. Программа должна
вывести на экран все адреса в файловой системе файлов с
таким названием.
 */
package net.ukr.grygorenko_d;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		String filename = "firstfile.txt";
		File startDirectory = new File("F:\\");
		int threadsAmount = 4;

		FileSearcher fs = new FileSearcher(filename, threadsAmount);
		System.out.println("Begin searching for " + filename + " starting from " + startDirectory);
		fs.startFrom(startDirectory);

	}

}
