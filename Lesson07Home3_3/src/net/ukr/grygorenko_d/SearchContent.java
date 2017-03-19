package net.ukr.grygorenko_d;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

public class SearchContent implements Callable<Integer> {
	private List<File> contents;
	private String filename;

	public SearchContent(List<File> contents, String filename) {
		super();
		this.contents = contents;
		this.filename = filename;
	}

	public SearchContent() {
		super();
	}

	@Override
	public Integer call() {
		int found = 0;
		for (File file : contents) {
			if (file != null) {
				if (file.getName().equalsIgnoreCase(filename)) {
					try {
						System.out.println("Found: " + file.getCanonicalPath());
						found++;
					} catch (IOException e) {
						System.out.println("Error accessing file.");
						e.printStackTrace();
					}

				} 
			}
		}
		return found;

	}

}
