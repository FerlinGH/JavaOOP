package net.ukr.grygorenko_d;

public class Student extends Human {
	private String faculty;
	private int course;
	private int gradebook;

	public Student(String name, String gender, int age, String faculty, int course, int gradebook) {
		super(name, gender, age);
		this.faculty = faculty;
		this.course = course;
		this.gradebook = gradebook;
	}

	public Student(String name, String gender, int age) {
		super(name, gender, age);
	}

	public String getFaculty() {
		return faculty;
	}

	public int getCourse() {
		return course;
	}

	public int getGradebook() {
		return gradebook;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + course;
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + gradebook;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (course != other.course)
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (gradebook != other.gradebook)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Student [%s, %s, %d, %s, %d, %d]", getName(), getGender(), getAge(), faculty, course,
				gradebook);

	}

}
