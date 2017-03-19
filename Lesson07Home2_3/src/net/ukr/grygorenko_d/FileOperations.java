package net.ukr.grygorenko_d;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations {

	private byte[] buffer = new byte[40960];
	private int bytesRead;
	private long totalCopied = 0;
	private boolean isReading = true;
	private boolean isDone = false;

	public FileOperations(byte[] buffer, int bytesRead, long totalCopied) {
		super();
		this.buffer = buffer;
		this.bytesRead = bytesRead;
		this.totalCopied = totalCopied;
		this.isReading = true;
		this.isDone = false;
	}

	public FileOperations() {
		super();
	}

	public boolean isReading() {
		return isReading;
	}

	public void setReading(boolean isReading) {
		this.isReading = isReading;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	public int getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(int bytesRead) {
		this.bytesRead = bytesRead;
	}

	public long getTotalCopied() {
		return totalCopied;
	}

	public void setTotalCopied(long totalCopied) {
		this.totalCopied = totalCopied;
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
		totalCopied += bytesRead;
		notifyAll();
	}

	public synchronized void writeFile(File file) {
		try (FileOutputStream fos = new FileOutputStream(file)) {
			while (bytesRead > 0) {
				fos.write(buffer, 0, bytesRead);
				isReading = true;
				notifyAll();
				if (!isDone) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					bytesRead = 0;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public synchronized void reportProgress(){ while (isReading == true){ try
	 * { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
	 * 
	 * }
	 */
}
