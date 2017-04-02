package net.ukr.grygorenko_d;

public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(double sideA, double sideB, double sideC) {
		super();
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public Triangle() {
		super();
	}

	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	@Override
	public String toString() {
		return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + "]";
	}

	public void getArea() {
		double p = (getSideA() + getSideB() + getSideC()) / 2.0;
		double area = Math.sqrt(p * (p - getSideA()) * (p - getSideB()) * (p - getSideC()));
		String str = "";
		str += "Area of " + toString() + " = " + area;
		System.out.println(str);

	}

}
