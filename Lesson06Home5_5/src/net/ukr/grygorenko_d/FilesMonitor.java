package net.ukr.grygorenko_d;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FilesMonitor implements Runnable {
	private File directory;
	private ArrayList<String> content;
	private DirectoryWatcher dw;

	public FilesMonitor(File directory, ArrayList<String> content, DirectoryWatcher dw) {
		super();
		this.directory = directory;
		this.content = content;
		this.dw = dw;
	}

	public FilesMonitor(File directory, DirectoryWatcher dw) {
		super();
		this.directory = directory;
		this.dw = dw;
		this.content = getContent();
	}

	public FilesMonitor() {
		super();
	}

	private final ArrayList<String> getContent() {
		ArrayList<String> tmpList = new ArrayList<>();
		File[] tmpArray = directory.listFiles();
		for (File file : tmpArray) {
			if (file.isFile()) {
				tmpList.add(file.getName());
			}
		}
		return tmpList;
	}

	public boolean isContentChanged() {
		ArrayList<String> tempContent = getContent();
		if (content.size() == tempContent.size()) {
			for (int i = 0; i < content.size(); i++) {
				if (content.get(i).equalsIgnoreCase(tempContent.get(i))) {
					continue;
				} else {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	public void detectEvent() {
		ArrayList<String> newContent = getContent();
		if (content.size() < newContent.size()) {
			fileAdded(newContent);
		} else if (content.size() > newContent.size()) {
			fileRemoved(newContent);
		} else {
			fileRenamed(newContent);
		}
	}

	public void fileAdded(ArrayList<String> newContent) {
		ArrayList<String> addedFiles = new ArrayList<>();
		for (String str : newContent) {
			if (!content.contains(str)) {
				addedFiles.add(str);
			}
		}
		for (int i = 0; i < addedFiles.size(); i++) {
			dw.onFileAdded(addedFiles.get(i));
		}
		content = newContent;
	}

	public void fileRemoved(ArrayList<String> newContent) {
		ArrayList<String> removedFiles = new ArrayList<>();
		for (String str : content) {
			if (!newContent.contains(str)) {
				removedFiles.add(str);
			}
		}
		for (int i = 0; i < removedFiles.size(); i++) {
			dw.onFileRemoved(removedFiles.get(i));
		}
		content = newContent;
	}

	public void fileRenamed(ArrayList<String> newContent) {
		ArrayList<String> newNamesList = new ArrayList<>();
		for (int i = 0; i < newContent.size(); i++) {
			String str = newContent.get(i);
			if (!content.contains(str)) {
				newNamesList.add(str);
			} else {
				content.remove(str);
			}
		}
		Collections.sort(content);
		for (int i = 0; i < newNamesList.size(); i++) {
			String oldName = content.get(i);
			String newName = newNamesList.get(i);
			dw.onFileRenamed(oldName, newName);
		}
		content = newContent;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		while (!thr.isInterrupted()) {
			if (isContentChanged()) {
				detectEvent();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
		}

	}

}
