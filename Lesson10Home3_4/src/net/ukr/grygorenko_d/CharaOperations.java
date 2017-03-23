package net.ukr.grygorenko_d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharaOperations {

	private List<Character> vocabulary = new ArrayList<>();
	private Map<Character, Integer> statistics = new HashMap<>();

	public CharaOperations(List<Character> vocabulary, Map<Character, Integer> statistics) {
		super();
		this.vocabulary = vocabulary;
		this.statistics = statistics;
	}

	public CharaOperations() {
		super();
	}

	public Map<Character, Integer> getStatistics() {
		return statistics;
	}

	public void setUp() {
		for (char c = 'a'; c <= 'z'; c++) { // low letters
			vocabulary.add(c);
		}
		for (char c = 'A'; c <= 'Z'; c++) { // capital letters
			vocabulary.add(c);
		}
	}

	public String extractWords(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String readedLine = "";
			while ((readedLine = bf.readLine()) != null) {
				sb.append(readedLine + " ");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}

	public void check(Character c) {
		if (vocabulary.contains(c)) {
			Integer count = getStatistics().get(c);
			getStatistics().put(c, count == null ? 1 : count + 1);
		}
	}

}
