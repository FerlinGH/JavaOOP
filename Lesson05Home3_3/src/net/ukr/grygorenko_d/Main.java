/*
 * 1. Усовершенствуйте класс описывающий группу студентов
добавив возможность сохранения группы в файл
2. Реализовать обратный процесс — т.е. считать данные о
группе из файла и на их основе создать объект типа группа.
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
		for (Student st : loadedGroup.getGroupArray()) {
			System.out.println(st);
		}

	}
}
