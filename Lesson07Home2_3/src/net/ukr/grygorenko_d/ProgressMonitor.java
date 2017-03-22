package net.ukr.grygorenko_d;

public class ProgressMonitor implements Runnable {
	private FileOperations fo;

	public ProgressMonitor(FileOperations fo) {
		super();
		this.fo = fo;
	}

	public ProgressMonitor() {
		super();
	}

	public boolean isDone() {
		return fo.isDone();
	}

	@Override
	public void run() {
		while (!isDone()) {
			fo.showProgress();
		}
		System.out.println("File copied successfully.");

	}

}
