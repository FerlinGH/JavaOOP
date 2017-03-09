/*
 * Напишите программу которая скопирует файлы (с заранее
определенным расширением — например только doc) из
каталога источника в каталог приемник.
 */
package net.ukr.grygorenko_d;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File sourceDir = new File("Source"); // already exists with some files;
		File destDir = new File("Destination");
		destDir.mkdir();
		System.out.println("Source directory contains:");
		for (String entry : sourceDir.list()) {
			System.out.println(entry);
		}
		System.out.println();

		FileSelector fileSel = new FileSelector(sourceDir, "txt");
		File[] toCopy = fileSel.selectFiles();
		System.out.println("Files to be copied:");
		for (File f : toCopy) {
			System.out.println(f);
		}
		System.out.println();
		
		FileCopier filecopy = new FileCopier(toCopy, destDir);
		filecopy.copyFiles();
		System.out.println("Destination derectory contains:");
		for (String entry : destDir.list()) {
			System.out.println(entry);
		}

	}

}
