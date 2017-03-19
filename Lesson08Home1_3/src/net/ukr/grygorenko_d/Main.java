/*
 * Используя стандартный методы сериализации создайте мини базу
данных для работы с группами студентов (возможность записи и чтения
базы из файла по запросу пользователя).
 */
package net.ukr.grygorenko_d;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		Group gr1 = new Group("GR1");
		gr1.addStudent("Ron", 23, 2);
		gr1.addStudent("Sean", 22, 2);
		gr1.addStudent("Davis", 22, 2);

		Group tx9 = new Group("TX9");
		tx9.addStudent("Kolya", 20, 1);
		tx9.addStudent("Vasya", 20, 1);
		tx9.addStudent("Petya", 21, 1);

		Group kp2 = new Group("KP2");
		kp2.addStudent("Trus", 30, 5);
		kp2.addStudent("Balses", 32, 5);
		kp2.addStudent("Byvalyi", 35, 5);

		Database db = new Database("SmallDatabase");
		db.addGroup(gr1);
		db.addGroup(tx9);
		db.addGroup(kp2);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backup"))) {
			oos.writeObject(db);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Database db2 = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("backup"))) {
			db2 = (Database) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println(db2);

	}

}
