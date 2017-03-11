package net.ukr.grygorenko_d;

public interface DirectoryWatcher {
	public void onFileAdded(String filename);

	public void onFileRemoved(String filename);

	public void onFileRenamed(String oldName, String newName);

}
