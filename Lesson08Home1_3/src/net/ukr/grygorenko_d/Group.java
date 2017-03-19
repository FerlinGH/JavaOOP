package net.ukr.grygorenko_d;

import java.io.Serializable;

public class Group implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Student[] groupArray;
	private String groupname;

	public Group(Student[] groupArray, String groupname) {
		super();
		this.groupArray = groupArray;
		this.groupname = groupname;
	}

	public Group(String groupname) {
		super();
		this.groupname = groupname;
		this.groupArray = new Student[0];
	}

	public Group() {
		super();
	}

	public void addStudent(String name, int age, int course) {
		Student[] groupArray2 = new Student[groupArray.length + 1];
		System.arraycopy(groupArray, 0, groupArray2, 0, groupArray.length);
		groupArray2[groupArray.length] = new Student(name, age, course);
		groupArray = groupArray2;
	}

	@Override
	public String toString() {
		System.out.println("Group " + groupname + ": ");
		for (Student st : groupArray) {
			System.out.println(st);
		}
		return "";
	}

}
