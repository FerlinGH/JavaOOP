package net.ukr.grygorenko_d;

import java.util.HashMap;
import java.util.Map;

public class ArrayToMap {

	public static <K, V> Map<K, Integer> createMap(K[] array) {
		Map<K, Integer> map = new HashMap<K, Integer>();
		for (K cell : array) {
			Integer count = map.get(cell);
			map.put(cell, count == null ? 1 : count + 1);
		}
		return map;
	}

	public static <K> void showStatistic(Map<K, Integer> map) {
		map.forEach((key, value) -> System.out.println("Entry " + key + ": " + value + " time(s)."));
	}

}
