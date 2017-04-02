/*
 * Написать сервер, который будет отправлять пользователю
информацию о системе и номер запроса.
 */
package net.ukr.grygorenko_d;

public class Main {

	public static void main(String[] args) {
		Server serv = new Server(20000);

		serv.startServer();

	}

}
