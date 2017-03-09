package net.ukr.grygorenko_d;

import java.io.File;
import java.io.FilenameFilter;

public class FileSelector {
	private File sourceDir;
	private String extension;

	public FileSelector(File sourceDir, String extension) {
		super();
		this.sourceDir = sourceDir;
		this.extension = extension;
	}

	public FileSelector() {
		super();
	}

	public File[] selectFiles() {
		File[] toCopy = sourceDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(extension);
			}

		});
		return toCopy;

	}
}
