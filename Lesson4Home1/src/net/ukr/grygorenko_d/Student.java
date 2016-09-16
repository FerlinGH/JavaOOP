package net.ukr.grygorenko_d;

public class Student extends Human {
	private String faculty;
	private String group;
	private double rate;

	public Student(String name, String gender, int age, String faculty, String group, double rate) {
		super(name, gender, age);
		this.faculty = faculty;
		this.group = group;
		this.rate = rate;
	}

	public Student() {
		super();
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return name + "[Gender= " + gender + ", age= " + age + ", faculty=" + faculty + ", group=" + group + ", rate="
				+ rate + "]";
	}

}
