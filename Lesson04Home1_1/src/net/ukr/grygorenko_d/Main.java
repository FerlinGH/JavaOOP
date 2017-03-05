/*
 * 1. Усовершенствуйте класс Group добавив возможность
интерактивного добавления объекта.
2. Реализуйте возможность сортировки списка студентов
по фамилии.
3. Реализуйте возможность сортировки по параметру
(Фамилия, успеваемость и т. д.).
4. Реализуйте интерфейс Военком которые вернет из группы
массив студентов юношей которым больше 18 лет.
5. Протестируйте ее работу.
 */

package net.ukr.grygorenko_d;

public class Main {

	public static void main(String[] args) {
		Group group = new Group();
		group.createGroup();
		try {
			group.addInteractive();
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
		}

		group.remove("mike");
		group.remove("Cornelius");

		group.sortGroup("faculty");
		System.out.println("Sorted group:");
		for (Student st : group.getGroupArray()) {
			System.out.println(st);
		}

		System.out.println(System.lineSeparator());
		System.out.println("Summoned by Voenkom:");
		Voenkom enlisted = (Voenkom) group;
		Student[] toArmy = enlisted.toArmy();
		for (Student st : toArmy) {
			System.out.println(st);
		}
	}
}
