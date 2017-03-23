package net.ukr.grygorenko_d;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Translator {
	private NavigableMap<String, String> vocabulary = new TreeMap<String, String>();
	List<String> notTranslated = new ArrayList<>();

	public List<String> getNotTranslated() {
		return notTranslated;
	}

	public void createVocabulary(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			while ((text = br.readLine()) != null) {
				String[] tmp = text.split(" : ");
				vocabulary.put(tmp[0], tmp[1]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + file.getName() + " not found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void translate(File englishIn) {
		String[] text = readText(englishIn).split("[-+ ,;:.!?]");
		File ukrainianOut = new File("Ukrainian.out");
		try {
			ukrainianOut.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ukrainianOut))) {
			for (String word : text) {
				bw.write(vocabulary.getOrDefault(word, word) + " ");
				if (!vocabulary.containsKey(word)) {
					notTranslated.add(word);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String readText(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String str = "";
			while ((str = br.readLine()) != null) {
				sb.append(str + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public void updateVocabulary(File words) {
		Scanner scan = new Scanner(System.in);
		for (String word : notTranslated) {
			System.out.println("Please enter translation for word \"" + word + "\":");
			String tr = scan.nextLine();
			vocabulary.put(word, tr);
		}
		scan.close();
		try {
			saveVocabulary(words);
		} catch (IOException e) {
			e.printStackTrace();
		}
		notTranslated = new ArrayList<>();
	}

	private void saveVocabulary(File words) throws IOException {
		PrintWriter pw = new PrintWriter(words);
		words.delete();
		words.createNewFile();
		for (Map.Entry<String, String> entry : vocabulary.entrySet()) {
			pw.println(entry.getKey() + " : " + entry.getValue());
		}
		pw.close();
	}

}
