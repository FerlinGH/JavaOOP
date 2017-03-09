/*
 * Напишите программу которая примет на вход 2 текстовых
файла, а вернет один. Содержимым этого файла должны
быть слова которые есть и в первом и во втором файле.
 */
package net.ukr.grygorenko_d;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File firstFile = new File("Firstfile.txt");
		File secondFile = new File("Secondfile.txt");

		String[] firstArray = WordExtractor.extractWords(firstFile);
		String[] secondArray = WordExtractor.extractWords(secondFile);

		File resultFile = new File("Resultfile.txt");
		try {
			resultFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		WordComparer wc = new WordComparer(firstArray, secondArray, resultFile);
		wc.compareFiles();
	}
}
