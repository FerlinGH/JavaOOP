/*
 * Существуют три корабля. На каждом из них 10 ящиков груза.
Они одновременно прибыли в порт в котором только два
дока. Скорость разгрузки 1 ящик в 0.5 сек. Напишите
программу которая управляя кораблями позволит им
правильно разгрузить груз.
 */
package net.ukr.grygorenko_d;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		List<Runnable> tasks = new ArrayList<>();
		tasks.add(new ShipUnloader("Fast"));
		tasks.add(new ShipUnloader("Quick"));
		tasks.add(new ShipUnloader("Rapid"));
		
		ExecutorService execSer = Executors.newFixedThreadPool(2);
		
		for (Runnable task : tasks) {
			execSer.execute(task);
		}
		
		execSer.shutdown();

	}

}
