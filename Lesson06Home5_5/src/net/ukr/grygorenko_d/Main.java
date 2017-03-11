/*
 * Реализуйте программу которая с периодичностью 1 сек,
будет проверять состояние заданного каталога. Если в этом
каталоге появиться новый файл или исчезнет, то выведет
сообщение об этом событии. Программа должна работать в
параллельном потоке выполнения.
 */
package net.ukr.grygorenko_d;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File path = new File("c:\\Temp");
		Scanner scan = new Scanner(System.in);
		FilesMonitor fm = new FilesMonitor(path, new MyDirectoryWatcher());
		Thread thr = new Thread(fm);
		thr.setDaemon(true);
		System.out.println("Folder monitor started.");
		thr.start();
		while(true){
			String input = scan.nextLine();
			if(input.equalsIgnoreCase("exit")){
				break;
			}
		}
		scan.close();
		System.out.println("Program terminated by user.");
	}
}
