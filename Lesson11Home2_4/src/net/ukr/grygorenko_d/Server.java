package net.ukr.grygorenko_d;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private int port;
	private static int count = 1;

	public Server(int port) {
		super();
		this.port = port;
	}

	public Server() {
		super();
	}

	public void startServer() {

		try (ServerSocket servSoc = new ServerSocket(port)) {
			System.out.println("Waiting for a client...");
			Socket incoming = servSoc.accept();
			System.out.println("Client connected!");
			try (Scanner scan = new Scanner(incoming.getInputStream());
					PrintWriter out = new PrintWriter(incoming.getOutputStream(), true)) {
				boolean exit = false;
				out.println("Welcome to Server! Type something to get system info (or \"exit\" to quit).");
				while (!exit) {
					String request = scan.nextLine();
					if (request.equalsIgnoreCase("exit")) {
						exit = true;
						System.out.println("User disconnected.");
						continue;
					} else {
						System.out.printf("Recieved request: %s. Sending system's info." + System.lineSeparator(),
								request);
						out.println("Request No. " + count++);
						out.println("Operation system: " + System.getProperty("os.name") + ", version "
								+ System.getProperty("os.version"));
						out.println("Username: " + System.getProperty("user.name"));
						out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
						out.println("Memory in use by JVM: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
						out.println("Total memory for JVM: " + Runtime.getRuntime().totalMemory());

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
