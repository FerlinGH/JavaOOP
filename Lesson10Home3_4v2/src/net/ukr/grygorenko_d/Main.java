/*
 *  Решить задачу подсчета повторяющихся элементов в массиве с помощью HashMap.
 *  (На входе массив любого типа, на выходе карта каждым элементом которого 
 *  является пара вида - элемент и сколько раз он встретился в массиве.)
 */
package net.ukr.grygorenko_d;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Integer[] integerArray = { 1, 4, 3, 6, 4, 4, 1, 2, 7, 4, 0, 1, 2, 5, 3, 5, 4 };
		Map<Integer, Integer> integerMap = ArrayToMap.createMap(integerArray);
		System.out.println("Array of Integers:");
		ArrayToMap.showStatistic(integerMap);
		System.out.println();

		Character[] charArray = { 'a', 'f', 'r', 'v', 'a', 'b', 'c', 'a', 'n', 't', 'u', 'b', 'x', 'c' };
		Map<Character, Integer> charMap = ArrayToMap.createMap(charArray);
		System.out.println("Array of Characters:");
		ArrayToMap.showStatistic(charMap);
		System.out.println();

		String[] stringArray = { "two", "tea", "to", "two", "two" };
		Map<String, Integer> stringMap = ArrayToMap.createMap(stringArray);
		System.out.println("Array of Strings.");
		ArrayToMap.showStatistic(stringMap);
		System.out.println();

	}

}
