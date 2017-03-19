/*
 * Реализуйте программу многопоточного копирования файла
блоками, с выводом прогресса на экран.
 */
package net.ukr.grygorenko_d;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		File source = new File("Source\\OOP.pdf");
		File destDir = new File("Destination");
		destDir.mkdir();
		System.out.println(source.getName());
		File destination = new File(destDir + "\\" + source.getName());

		List<Runnable> tasks = new ArrayList<>();
		ExecutorService execSer = Executors.newFixedThreadPool(2);
		
		FileOperations fo = new FileOperations();
		tasks.add(new ReadFile(fo, source));
		tasks.add(new WriteFile(fo, destination));
		
		for (Runnable task : tasks) {
			execSer.execute(task);
		}
		
		execSer.shutdown();

	}

}
