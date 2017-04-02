package net.ukr.grygorenko_d;

public class Quadrangle extends Shape {
	private Point point1;
	private Point point2;
	private Point point3;
	private Point point4;

	public Quadrangle(Point point1, Point point2, Point point3, Point point4) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.point4 = point4;
	}

	public Quadrangle() {
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

	public Point getPoint4() {
		return point4;
	}

	public void setPoint4(Point point4) {
		this.point4 = point4;
	}

	@Override
	public String toString() {
		return "Quadrangle [point1=" + point1 + ", point2=" + point2 + ", point3=" + point3 + ", point4=" + point4
				+ "]";
	}

	@Override
	public double getArea() {
		Triangle tr1 = new Triangle(point1, point2, point3);
		Triangle tr2 = new Triangle(point1, point3, point4);
		double a1 = tr1.getArea();
		double a2 = tr2.getArea();
		return (a1 + a2);
	}

	@Override
	public double getPerimetr() {
		double sideA = getDistance(point1, point2);
		double sideB = getDistance(point2, point3);
		double sideC = getDistance(point3, point4);
		double sideD = getDistance(point1, point4);
		return (sideA + sideB + sideC + sideD);
	}

}
