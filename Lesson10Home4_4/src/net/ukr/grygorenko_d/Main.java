/*
 * Реализуйте программу которая сопоставит каждой букве ее
представление в виде ASCII - art, например
     *
    * *
   *   *
А *******
 *       *
*         *
Ваша программа должна дать возможность вывода произвольного
текста на экран в виде его ASCII-art представления.
 */
package net.ukr.grygorenko_d;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		DrawText dt = new DrawText();
		File font = new File("ANSI Shadow.txt");
		dt.createMap(font);
		
		String message = "Java OOP";
		dt.draw(message);
	}

}
