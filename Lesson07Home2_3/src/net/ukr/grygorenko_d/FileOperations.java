package net.ukr.grygorenko_d;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations {

	private File source;
	private byte[] buffer = null;
	private int bytesRead = 0;
	private long totalCopied = 0;
	private boolean isReading = true;
	private boolean isDone = false;

	public FileOperations(File source) {
		super();
		this.source = source;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public synchronized void readFromFile(byte[] buffer, int bytesRead) {
		this.buffer = buffer;
		this.bytesRead = bytesRead;
		isReading = false;

		notifyAll();
		if (!isDone) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void writeFile(File file) {
		try (FileOutputStream fos = new FileOutputStream(file)) {
			while (bytesRead > 0) {
				fos.write(buffer, 0, bytesRead);
				totalCopied += bytesRead;
				isReading = true;
				notifyAll();
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void showProgress() {
		long percent = (totalCopied * 100) / source.length();
		if (isDone) {
			System.out.println("File copied successfully.");
		} else if (isReading) {
			System.out.println("Copying file... " + percent + "% completed.");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
