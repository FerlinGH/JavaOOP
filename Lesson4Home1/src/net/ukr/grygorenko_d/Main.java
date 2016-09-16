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

1. Усовершенствуйте класс Group добавив возможность
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

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Group group = new Group();
		Student st1 = new Student();
		System.out.println("Enter student's name:");
		st1.setName(scan.nextLine());
		System.out.println("Now enter student's gender (male/female):");
		st1.setGender(scan.nextLine());
		System.out.println("Now enter student's age:");
		st1.setAge(scan.nextInt());
		scan.nextLine();
		System.out.println("Now enter student's faculty:");
		st1.setFaculty(scan.nextLine());
		System.out.println("Now enter student's group:");
		st1.setGroup(scan.nextLine());
		st1.setRate(4 + Math.random());
		scan.close();
		Student st2 = new Student("Paul", "male", 23, "Biology", "Gr1", (4 + Math.random()));
		Student st3 = new Student("Mike", "male", 35, "Justice", "Gr1", (4 + Math.random()));
		Student st4 = new Student("Julia", "female", 15, "History", "Gr2", (4 + Math.random()));
		Student st5 = new Student("Helen", "female", 20, "Justice", "Gr2", (4 + Math.random()));
		Student st6 = new Student("Justin", "male", 17, "Physics", "Gr3", (4 + Math.random()));
		Student st7 = new Student("Alise", "female", 21, "History", "Gr4", (4 + Math.random()));
		Student st8 = new Student("Bob", "male", 19, "Agriculture", "Gr2", (4 + Math.random()));
		Student st9 = new Student("Phillip", "male", 17, "Math", "Gr1", (4 + Math.random()));
		Student st10 = new Student("Anna", "female", 19, "Biology", "Gr4", (4 + Math.random()));
		Student st11 = new Student("Patrick", "male", 24, "Geography", "Gr1", (4 + Math.random()));
		group.setGroup(st1,st2,st3,st4,st5,st6,st7,st8,st9,st10);
		Administration adm = new Administration();
		adm.addStudent(group, st11);
		adm.findStudent(group, "Julia", 0);
		adm.findStudent(group, "Jeremy", 1);
		adm.findStudent(group, "Julia", 1);
		adm.findStudent(group, "Julia", 0);
		adm.addStudent(group,st11);
		System.out.println();
		adm.callOfDyty(group);
	}
	
	

}
