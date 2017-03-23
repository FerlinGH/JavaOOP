/*
 * Написать программу переводчик, которая будет переводить текст
в файле English.in,написанный на английском языке, на украинский
язык согласно заранее составленному словарю. Результат
сохранить в файл Ukrainian.out.
	Сделать ф-ю ручного наполнения словаря и возможность его
сохранения на диск.
 */
package net.ukr.grygorenko_d;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File englishIn = new File("English.in");
		File words = new File("Words.txt");

		Translator translator = new Translator();
		translator.createVocabulary(words);

		translator.translate(englishIn);
		while (!translator.getNotTranslated().isEmpty()) {
			String input = verify();
			if (input.equalsIgnoreCase("y")) {
				translator.updateVocabulary(words);
			} else
				break;
		}
		System.out.println("Translation complete.");
	}

	private static String verify() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Some words were not translated. Would you like to update vocabylary? (Y/N)");
		String input = scan.nextLine();
		if (input.equalsIgnoreCase("y")) {
			System.out.println("Begin vocabulary update.");
		} else if (input.equalsIgnoreCase("n")) {
			System.out.println("Skipping vocabulary update.");
		} else {
			System.out.println("Input not recognized. Vocabulary will not be updated.");
		}
		scan.close();
		return input;

	}

}
