/*
 * Описать класс «Vector3d» (т.е. он должен описывать вектор в 3-х мерной,
декартовой системе координат). В качестве свойств этого класса возьмите
координаты вектора. Для этого класса реализовать методы сложения, и скалярного и
векторного произведения векторов. Создайте несколько объектов этого класса и
протестируйте их.
 */
package net.ukr.grygorenko_d;

public class Main {

	public static void main(String[] args) {
		Vector3d vec = new Vector3d(3, 6, 2);
		System.out.println("Working with " + vec.toString());
		vec.processNewVector3d(4, 6, 8);
		vec.processNewVector3d(13, 32, 20);
		vec.processNewVector3d(10, -4, 2);

	}

}
