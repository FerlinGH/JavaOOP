package net.ukr.grygorenko_d;

public abstract class Shape {
	public abstract double getArea();

	public abstract double getPerimetr();

	public double getDistance(Point point1, Point point2) {
		double a = Math.pow(point2.getX() - point1.getX(), 2);
		double b = Math.pow(point2.getY() - point1.getY(), 2);
		return (Math.sqrt(a + b));
	};
}
