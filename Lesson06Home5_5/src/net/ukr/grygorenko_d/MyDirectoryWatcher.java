package net.ukr.grygorenko_d;

import java.text.SimpleDateFormat;

public class MyDirectoryWatcher implements DirectoryWatcher {
	private SimpleDateFormat sdf;

	public MyDirectoryWatcher(SimpleDateFormat sdf) {
		super();
		this.sdf = sdf;
	}

	public MyDirectoryWatcher() {
		super();
		this.sdf = new SimpleDateFormat("hh:mm:ss");
	}

	@Override
	public void onFileAdded(String filename) {
		System.out.print(sdf.format(System.currentTimeMillis()));
		System.out.println(" EVENT: New file " + filename + " ADDED.");

	}

	@Override
	public void onFileRemoved(String filename) {
		System.out.print(sdf.format(System.currentTimeMillis()));
		System.out.println(" EVENT: File " + filename + " REMOVED.");

	}

	@Override
	public void onFileRenamed(String oldName, String newName) {
		System.out.print(sdf.format(System.currentTimeMillis()));
		System.out.println(" EVENT: File " + oldName + " RENAMED to " + newName);

	}

}
