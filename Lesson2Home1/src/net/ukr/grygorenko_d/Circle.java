package net.ukr.grygorenko_d;

public class Circle extends Shape {

	private Point point1;
	private Point point2;

	public Circle(Point point1, Point point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
	}

	public Circle() {
		super();
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	@Override
	public String toString() {
		return "Circle [point1=" + point1 + ", point2=" + point2 + "]";
	}

	@Override
	public double getArea() {
		double rad = getDistance(point1, point2);
		return (Math.PI * Math.pow(rad, 2));
	}

	@Override
	public double getPerimetr() {
		double rad = getDistance(point1, point2);
		return (2 * Math.PI * rad);
	}

}
