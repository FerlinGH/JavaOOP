/*
 * Решить задачу подсчета повторяющихся элементов в массиве с
помощью HashMap.
 */
package net.ukr.grygorenko_d;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		CharaOperations charOps = new CharaOperations();
		charOps.setUp();
		File source = new File("Source\\Text.txt");
		String text = charOps.extractWords(source);
		for (char c : text.toCharArray()) {
			charOps.check(c);
		}

		List<Map.Entry<Character, Integer>> sortedStatistics = new ArrayList<>(charOps.getStatistics().entrySet());
		Collections.sort(sortedStatistics, (e1, e2) -> (-1) * (e1.getValue() - e2.getValue()));

		for (Map.Entry<Character, Integer> entry : sortedStatistics) {
			System.out.println("Character " + entry.getKey() + ": " + entry.getValue() + " time(s).");
		}

	}

}
