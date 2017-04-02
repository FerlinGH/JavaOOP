package net.ukr.grygorenko_d;

public class Cat {
	private String name;
	private double weight;
	private int energy;

	public Cat(String name, double weight, int energy) {
		super();
		this.name = name;
		this.weight = weight;
		this.energy = energy;
	}

	public Cat() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", weight=" + weight + ", energy=" + energy + "]";
	}

	public void voice(double weight) {
		if (weight < 10) {
			System.out.println("Miaw! Miaw!");
			System.out.println("Cute little kitten!" + toString());
			System.out.println();
		} else if (weight < 20) {
			System.out.println("Meow! Meow!");
			System.out.println("Nice funny cat!" + toString());
			System.out.println();
		} else {
			System.out.println("Mowh! Mowh!");
			System.out.println("Big fat cat!" + toString());
			System.out.println();
		}
	}

	public int feed(int energy, int food, String name) {
		switch (food) {
		case 1:
			System.out.printf("Let's feed %s with milk!" + System.lineSeparator(), name);
			return energy += 1;
		case 2:
			System.out.printf("Let's feed %s with Wiskas!" + System.lineSeparator(), name);
			return energy += 2;
		case 3:
			System.out.printf("Let's feed %s with meatballs!" + System.lineSeparator(), name);
			return energy += 3;
		default:
			return 0;
		}
	}

	public void play(String name, int energy) {
		System.out.println();
		System.out.printf("Let's play with our cat %s!" + System.lineSeparator(), name);
		switch (energy) {
		case 4:
			System.out.printf("%s plays with a clew!" + System.lineSeparator(), name);
			break;
		case 5:
			System.out.printf("%s plays run&catch with you!"+ System.lineSeparator(), name);
			break;
		case 6:
		case 7:
			System.out.println("After a good meal your cat is too tired to play!");
			break;
		default:
			System.out.println("Meow!! Meow!!");
			System.out.println("Seems like your cat is still hungry...");

		}
	}

}
