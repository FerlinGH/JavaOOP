package net.ukr.grygorenko_d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DrawText {
	private Map<Character, String[]> map = new HashMap<>();

	public DrawText(String message, Map<Character, String[]> map) {
		super();
		this.map = map;
	}

	public DrawText() {
		super();
	}

	public void createMap(File font) {
		try (BufferedReader bf = new BufferedReader(new FileReader(font))) {
			for (char c = 'A'; c <= 'Z'; c++) {
				StringBuilder sb = new StringBuilder();
				String str = "";
				while (!(str = bf.readLine()).equals("***")) {
					sb.append(str + System.lineSeparator());
				}
				map.put(c, sb.toString().split(System.lineSeparator()));

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(String message) {
		char[] letters = message.toUpperCase().toCharArray();
		int height = map.get((Character) 'A').length;
		for (int i = 0; i < height; i++) {
			StringBuilder sb = new StringBuilder();
			for (Character letter : letters) {
				if (map.containsKey(letter)) {
					sb.append((map.get(letter))[i] + " ");
				} else {
					sb.append("     ");
				}

			}
			System.out.print(sb.toString() + System.lineSeparator());
		}
	}

}
