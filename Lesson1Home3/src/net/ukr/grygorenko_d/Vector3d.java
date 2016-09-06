package net.ukr.grygorenko_d;

public class Vector3d {
	private double x;
	private double y;
	private double z;

	public Vector3d(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d() {
		super();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Vector3d [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public void processNewVector3d(double x2, double y2, double z2) {
		System.out.printf("Recieved Vector3d [%.2f, %.2f, %.2f]" + System.lineSeparator(), x2, y2, z2);
		System.out.println();
		System.out.println("The sum of vectors is " + getVectorSum(x2, y2, z2));
		System.out.println("Scalar multiply of vectors is " + getVectorScalMult(x2, y2, z2));
		System.out.println("Vector multyply of vectors is " + getVectorVectMult(x2, y2, z2));
		System.out.println();
	}

	public String getVectorSum(double x2, double y2, double z2) {
		double x = getX() + x2;
		double y = getY() + y2;
		double z = getZ() + z2;
		return ("(" + x + ", " + y + ", " + z + ")");
	}

	public double getVectorScalMult(double x2, double y2, double z2) {
		double x = getX() * x2;
		double y = getY() * y2;
		double z = getZ() * z2;
		return (x + y + z);
	}

	public String getVectorVectMult(double x2, double y2, double z2) {
		double x = getY() * z2 - getZ() * y2;
		double y = getZ() * x2 - getX() * z2;
		double z = getX() * y2 - getY() * x2;
		return ("(" + x + ", " + y + ", " + z + ")");
	}

}
