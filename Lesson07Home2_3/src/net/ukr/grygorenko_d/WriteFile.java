package net.ukr.grygorenko_d;

import java.io.File;

public class WriteFile implements Runnable {
	private FileOperations fo;
	private File destination;

	public WriteFile(FileOperations fo, File destination) {
		super();
		this.fo = fo;
		this.destination = destination;
	}

	public WriteFile() {
		super();
	}

	public boolean isDone() {
		return fo.isDone();
	}

	@Override
	public void run() {
		while (!isDone()) {
			fo.writeFile(destination);
		}

	}

}
