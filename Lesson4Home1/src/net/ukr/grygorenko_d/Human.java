package net.ukr.grygorenko_d;

public class Human {
	public String name;
	public String gender;
	public int age;

	public Human(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		try {
			if (gender.equals("male") || gender.equals("female")) {
				this.gender = gender;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Error setting Gender: must be male or female only! Default value (male) used instead.");
			this.gender = "male";
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
