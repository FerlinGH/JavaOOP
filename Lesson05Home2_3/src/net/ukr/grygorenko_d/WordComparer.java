package net.ukr.grygorenko_d;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WordComparer {
	private String[] firstArray;
	private String[] secondArray;
	File resultfile;

	public WordComparer(String[] firstArray, String[] secondArray, File resultfile) {
		super();
		this.firstArray = firstArray;
		this.secondArray = secondArray;
		this.resultfile = resultfile;
	}

	public WordComparer() {
		super();
	}

	public void compareFiles() {
		ArrayList<String> uniqueWords = new ArrayList<>();
		for (String fromFirst : firstArray) {
			for (String fromSecond : secondArray) {
				if (fromSecond.equals(fromFirst)) {
					if (uniqueWords.contains(fromSecond)) {
						continue;
					} else {
						uniqueWords.add(fromSecond);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String word : uniqueWords) {
			sb.append(word + " ");
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultfile))) {
			bw.write(sb.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
