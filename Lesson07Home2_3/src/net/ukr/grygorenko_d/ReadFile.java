package net.ukr.grygorenko_d;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile implements Runnable {
	private FileOperations fo;
	private File source;

	public ReadFile(FileOperations fo, File source) {
		super();
		this.fo = fo;
		this.source = source;
	}

	public ReadFile() {
		super();
	}

	@Override
	public void run() {
		try (FileInputStream fis = new FileInputStream(source)) {
			byte[] buffer = new byte[204800];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) > 0) {
				byte[] readed = new byte[buffer.length];
				System.arraycopy(buffer, 0, readed, 0, bytesRead);
				fo.readFromFile(readed, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		fo.setDone(true);
		fo.readFromFile(null, 0);

	}

}