package net.ukr.grygorenko_d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordExtractor {

	public static String[] extractWords(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String readedLine = "";
			while ((readedLine = bf.readLine()) != null) {
				sb.append(readedLine.toLowerCase() + " ");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return sb.toString().split("[-+ ,;:.!?]");
	}

}
