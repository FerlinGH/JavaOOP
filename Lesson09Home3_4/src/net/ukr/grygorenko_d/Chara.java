package net.ukr.grygorenko_d;

public class Chara {
	private char id;
	private int count;

	public Chara(char id, int count) {
		super();
		this.id = id;
		this.count = count;
	}

	public Chara(char id) {
		this(id, 1);
	}

	public Chara() {
		super();
	}

	public int getCount() {
		return count;
	}

	public char getId() {
		return id;
	}

	public void increment() {
		count++;
	}

	@Override
	public String toString() {
		return "Letter " + getId() + ": " + getCount() + " time(s).";
	}

}
