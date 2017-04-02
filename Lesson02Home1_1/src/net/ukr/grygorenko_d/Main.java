/*
 * 1. Создайте абстрактный класс Shape в котором есть два
абстрактных метода double getPerimetr() и double getArea().
2. Создайте класс Point в котором есть два свойства double x
double y.
3. Создайте классы которые описывают как минимум 3
геометрические фигуры (они должны быть подклассами
Shape), при этом они в качестве свойств должны содержать
классы Point.
4. Создайте класс доска. Доска поделена на 4 части в каждую
часть доски можно положить одну из фигур. У доски должны
быть методы которые помещают и удаляют фигуру с доски.
Также должен быть метод который выводит информацию о
всех фигурах лежащих на доске и их суммарную площадь.
5. * Нарисуйте UML диаграмму проекта
 */
package net.ukr.grygorenko_d;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(3, 0);
		Point point3 = new Point(3, 4);
		Point point4 = new Point(0, 4);

		Shape circle = new Circle(point1, point2);
		Shape tri = new Triangle(point1, point2, point3);
		Shape quad = new Quadrangle(point1, point2, point3, point4);

		Board board = new Board();
		board.addShape(circle);
		board.addShape(tri);
		board.addShape(quad);
		board.addShape(circle);
		board.addShape(circle);
		System.out.println();
		board.getBoardStatus();
		System.out.println();
		board.removeShape(tri);
		board.removeShape(tri);
		System.out.println();
		board.getBoardStatus();

	}

}
