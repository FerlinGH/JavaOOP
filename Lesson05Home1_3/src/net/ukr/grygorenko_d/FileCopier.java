package net.ukr.grygorenko_d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier {
	private File[] toCopy;
	private File destination;

	public FileCopier(File[] toCopy, File destination) {
		super();
		this.toCopy = toCopy;
		this.destination = destination;
	}

	public FileCopier() {
		super();
	}

	public void copyFiles() {
		for (File file : toCopy) {
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
	}

}
