package net.ukr.grygorenko_d;

public class Triangle extends Shape {
	private Point point1;
	private Point point2;
	private Point point3;

	public Triangle(Point point1, Point point2, Point point3) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}

	public Triangle() {
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

	public Point getPoint3() {
		return point3;
	}

	public void setPoint3(Point point3) {
		this.point3 = point3;
	}
	

	@Override
	public String toString() {
		return "Triangle [point1=" + point1 + ", point2=" + point2 + ", point3=" + point3 + "]";
	}

	@Override
	public double getArea() {
		double sideA = getDistance(point1, point2);
		double sideB = getDistance(point2, point3);
		double sideC = getDistance(point1, point3);
		double p = getPerimetr() / 2;
		double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
		return area;
	}

	@Override
	public double getPerimetr() {
		double sideA = getDistance(point1, point2);
		double sideB = getDistance(point2, point3);
		double sideC = getDistance(point1, point3);
		return (sideA + sideB + sideC);
	}

}
