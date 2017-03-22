/*
 * 1) Написать метод, который создаст список, положит в него 10
элементов, затем удалит первые два и последний, а затем выведет
результат на экран.
 */
package net.ukr.grygorenko_d;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			lst.add(i);
		}
		// al = al.subList(2, (al.size() - 1)); 	Variant
		lst.remove(0);
		lst.remove(0);
		lst.remove(lst.size() - 1);

		System.out.println(lst);
	}

}
