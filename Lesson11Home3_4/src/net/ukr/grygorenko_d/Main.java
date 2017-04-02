/*
 * Напишите программу которая выведет в файл все ссылки
которые содержаться в html документе который будет прислан в
результате запроса на произвольный URL.
 */
package net.ukr.grygorenko_d;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter full HTTP address to parse.");
		String address = scan.nextLine();
		File page = null;

		try {
			page = HtmlParser.getPage(address);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			HtmlParser.extractLinks(page);
		} catch (IOException e) {
			e.printStackTrace();
		}

		scan.close();

	}

}
