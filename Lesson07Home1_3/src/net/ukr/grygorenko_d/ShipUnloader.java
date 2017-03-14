package net.ukr.grygorenko_d;

public class ShipUnloader implements Runnable {
	private String name;

	public ShipUnloader(String name) {
		super();
		this.name = name;
	}

	public ShipUnloader() {
		super();
	}

	@Override
	public void run() {
		System.out.println("Ship " + name + " arrives to the port.");
		System.out.println("Ship " + name + " is moored at the berth.");
		System.out.println("Ship " + name + " starts unloading its cargo.");
		for (int i = 1; i <= 10; i++) {
			System.out.println("Crate " + i + " is being unloaded from ship " + name + ": " + (10 - i) + " more to go.");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ship " + name + " has finished unloading its cargo.");
		System.out.println("Ship " + name + " is moored off the berth.");
		System.out.println("Ship " + name + " has left the port!");

	}
}
