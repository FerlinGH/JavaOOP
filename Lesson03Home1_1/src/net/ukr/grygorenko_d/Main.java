/*
 * 1)Создайте класс описывающий человека (создайте метод
выводящий информацию о человеке)
2)На его основе создайте класс студент (переопределите
метод вывода информации)
3)Создайте класс группа — который содержит массив из 10
объектов класса студент. Реализуйте методы добавления,
удаления студента и метод поиска студента по фамилии. В
случае попытки добавления 11 студента создайте
собственное исключение и обработайте его. Определите
метод toString() для группы так, что бы он выводил список
студентов в алфавитном порядке.
4) * Нарисуйте UML диаграмму проекта
 */

package net.ukr.grygorenko_d;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Group group = new Group();
		group.createGroup();
		group.add(new Student("Bob", "male", 19, "Agriculture", 5, 112453));
		try {
			group.add(new Student("Justin", "male", 17, "Physics", 2, 104857));
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
		}

		group.remove("mike");
		group.remove("Cornelius");

		Arrays.sort(group.getGroupArray(), new Comparator<Student>() {
			@Override
			public int compare(Student st1, Student st2) {
				if ((st1 != null) && (st2 == null)) {
					return -1;
				} else if ((st1 == null) && (st2 != null)) {
					return 1;
				} else if ((st1 == null) && (st2 == null)) {
					return 0;
				} else
					return st1.getName().compareTo(st2.getName());
			}
		});

		for (Student st : group.getGroupArray()) {
			System.out.println(st);
		}
	}
}
