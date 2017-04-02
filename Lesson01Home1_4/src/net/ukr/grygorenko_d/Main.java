/*
 * Описать класс «Cat» (в качестве образца можно взять домашнего питомца).
Наделить его свойствами и методами. Создать несколько экземпляров объектов этого
класса. Использовать эти объекты.
 */
package net.ukr.grygorenko_d;

public class Main {

	public static void main(String[] args) {
		Cat catOne = new Cat("Barsik", 8, 4);
		Cat catTwo = new Cat("Maksik", 13, 3);
		Cat catThree = new Cat("Murzik", 24, 2);

		catOne.voice(catOne.getWeight());
		catTwo.voice(catTwo.getWeight());
		catThree.voice(catThree.getWeight());

		catOne.setEnergy(catOne.feed(catOne.getEnergy(), (1 + (int) (Math.random() * 3)), catOne.getName()));
		catTwo.setEnergy(catTwo.feed(catTwo.getEnergy(), (1 + (int) (Math.random() * 2)), catTwo.getName()));
		catThree.setEnergy(catThree.feed(catThree.getEnergy(), (1 + (int) (Math.random() * 2)), catThree.getName()));

		catOne.play(catOne.getName(), catOne.getEnergy());
		catTwo.play(catTwo.getName(), catTwo.getEnergy());
		catThree.play(catThree.getName(), catThree.getEnergy());
	}

}
