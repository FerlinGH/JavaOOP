/*
 * Шелдон, Леонард, Воловиц, Кутрапалли и Пенни стоят в очереди
за «двойной колой». Как только человек выпьет такой колы он
раздваивается и оба становятся в конец очереди, что бы выпить еще
стаканчик. Напишите программу которая выведет на экран
состояние очереди в зависимости от того сколько стаканов колы
выдал аппарат с чудесным напитком. Например если было выдано
только два стакана, то очередь выглядит как:
[Volovitc, Kutrapalli, Penny,Sheldon,Sheldon,Leonard,Leonard]
 */

package net.ukr.grygorenko_d;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the amount of Nuka-Cola available:");
		int i = scan.nextInt();
		scan.close();

		Deque<String> que = new ArrayDeque<>();
		String[] users = { "Sheldon", "Leonard", "Volovitc", "Kutrapalli", "Penny" };
		Collections.addAll(que, users);

		for (int j = 0; j < i; j++) {
			String temp = que.removeFirst();
			que.addLast(temp);
			que.addLast(temp);
		}

		System.out.println(que);
	}
}
