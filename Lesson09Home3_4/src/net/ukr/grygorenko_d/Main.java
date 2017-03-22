/*
 * Считайте из файла текст на английском языке, вычислите
относительную частоту повторения каждой буквы и выведите на
экран результат в порядке убывания относительной частоты
повторения.
 */
package net.ukr.grygorenko_d;

import java.io.File;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		CharaOperations charOps = new CharaOperations();
		charOps.setUp();
		File source = new File("Source\\Text.txt");
		String text = charOps.extractWords(source);
		for (char c : text.toCharArray()) {
			charOps.check(c);
		}

		Collections.sort(charOps.getStatistics(), (Chara ch1, Chara ch2) -> (-1) * (ch1.getCount() - ch2.getCount()));

		for (Chara ch : charOps.getStatistics()) {
			System.out.println(ch);
		}
	}

}
