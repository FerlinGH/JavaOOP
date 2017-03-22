package net.ukr.grygorenko_d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharaOperations {

	private List<Character> vocabulary = new ArrayList<>();
	private List<Character> locations = new ArrayList<>();
	private List<Chara> statistics = new ArrayList<>();

	public CharaOperations(List<Character> vocabulary, List<Character> locations, List<Chara> statistics) {
		super();
		this.vocabulary = vocabulary;
		this.locations = locations;
		this.statistics = statistics;
	}

	public CharaOperations() {
		super();
	}

	public List<Chara> getStatistics() {
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
		if (vocabulary.contains(c)) { // only for characters in vocabulary
			if (locations.contains(c)) { // new entry in statistics?
				statistics.get(locations.indexOf(c)).increment();
			} else {
				locations.add(c);
				statistics.add(new Chara(c));
			}
		}
	}

}
