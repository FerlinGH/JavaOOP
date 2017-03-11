package net.ukr.grygorenko_d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier implements Runnable {
	private File file;
	private File destination;

	public FileCopier(File file, File destination) {
		super();
		this.file = file;
		this.destination = destination;
	}

	public FileCopier() {
		super();
	}

	public void copyFiles() {
		try (FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(destination + "//" + file.getName())) {
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, bytesRead);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		copyFiles();

	}

}
