/*
 * Создайте класс контейнер - стек (класс в который можно добавлять и
удалять объекты других классов, только в вершину стека) в который
можно сохранять объекты произвольного типа. Должен быть метод
добавления элемента в стек,получение с удалением элемента из стека, и
просто получение элемента из вершины из стека. Должна быть
реализована работа с «черным списком» классов (смотри ниже). Если
объект который добавляется в стек принадлежит классу из черного
списка, то добавление такого объекта запрещено.

	Для описанного выше стека создайте класс «Черный список» в котором
будут описаны классы объектов которые нельзя добавлять в стек.
Должна быть возможность добавления классов в черный список, проверка
объекта — на то что класс к которому он принадлежит принадлежит или
не принадлежит к классам в черном списке.
 */
package net.ukr.grygorenko_d;

public class Main {

	public static void main(String[] args) {
		MyStack ms = new MyStack();

		Long lg = new Long(12L);
		Float fl = new Float(3.15F);
		Integer integer = new Integer(1);
		Double doubl = new Double(2.3);

		ms.toBlacklist(doubl);
		ms.toBlacklist(integer);

		ms.push(lg);
		System.out.println(ms);
		ms.push(fl);
		System.out.println("First elenemt is " + ms.peek());
		System.out.println("Trying to add a blacklisted class.");
		ms.push(integer);
		System.out.println("Trying to remove the head of a stack.");
		ms.pop();
		System.out.println(ms);
		System.out.println("Removing from the blacklist.");
		ms.fromBlacklist(integer);
		ms.push(integer);
		System.out.println(ms);

	}

}
