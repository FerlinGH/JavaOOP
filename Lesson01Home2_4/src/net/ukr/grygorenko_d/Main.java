/*
 * Описать класс «Triangle». В качестве свойств возьмите длинны сторон
треугольника. Реализуйте метод который будет возвращать площадь этого
треугольника. Создайте несколько объектов этого класса и протестируйте их.
 */
package net.ukr.grygorenko_d;

public class Main {

	public static void main(String[] args) {
		Triangle triOne = new Triangle(29, 34.5, 10);
		Triangle triTwo = new Triangle(3, 4, 5);
		Triangle triThree = new Triangle(34, 26, 12.7);
		triOne.getArea();
		triTwo.getArea();
		triThree.getArea();
	}
}
