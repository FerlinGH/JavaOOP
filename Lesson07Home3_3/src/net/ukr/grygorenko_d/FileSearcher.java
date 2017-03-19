package net.ukr.grygorenko_d;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileSearcher {
	private String filename;
	private int threadsAmount;
	private List<Callable<Integer>> tasks = new ArrayList<>();

	public FileSearcher(String filename, int threadsAmount) {
		super();
		this.filename = filename;
		this.threadsAmount = threadsAmount;
		
	}

	public FileSearcher() {
		super();
	}

	public void startFrom(File directory){
		createTasks(directory);
		System.out.println("Total tasks: " + tasks.size());
		ExecutorService execSer = Executors.newFixedThreadPool(threadsAmount);
		List<Future<Integer>> results = null;
		try {
			results = execSer.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int found = 0;
		for (Future<Integer> future : results) {
			try {
				if (future.get() != null) {
					found += future.get();
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Search completed: " + found + " file(s) found");
		execSer.shutdown();
	}
	
	public void createTasks(File directory) {
		List<File> contents = new ArrayList<>();
		File[] dirArray = directory.listFiles();
		for (File file : dirArray) {
			if (file.exists() && file.isFile()){
				contents.add(file);
			}else if (file.exists() && file.isDirectory()){
				createTasks(file);
			}
			
		}
		if (!contents.isEmpty()) {
			tasks.add(new SearchContent(contents, filename));
		}
	}
		
}
