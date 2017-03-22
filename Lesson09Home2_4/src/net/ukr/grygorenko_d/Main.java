/*
 * Модифицируйте класс группа для более удобных методов работы
с динамическими массивами.
 */

package net.ukr.grygorenko_d;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Group group = new Group();
		group.createGroup();

		File backupFile = new File("backup.dat");
		try {
			backupFile.createNewFile();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		group.saveGroup(backupFile);

		Group loadedGroup = new Group();
		loadedGroup.loadGroup(backupFile);
		for (Student st : loadedGroup.getGroupList()) {
			System.out.println(st);
		}
		

	}
}
