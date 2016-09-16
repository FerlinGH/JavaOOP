package net.ukr.grygorenko_d;

import java.util.ArrayList;

public class Administration {
	private String adminName;

	public Administration(String adminName) {
		super();
		this.adminName = adminName;
	}

	public Administration() {
		super();
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void addStudent(Dekanat d, Student student){
		d.addStudent(student);
	}
	public void showStudent(Dekanat d, Student student){
		d.showStudent(student);
	}
	public void findStudent(Dekanat d, String name, int marker){
		d.findStudent(name, marker);
	}
	public void callOfDyty(Voenkom v){
		ArrayList<Student> toSummon = v.callOfDyty();
		for (Student student : toSummon) {
			System.out.println(student);
		}
	}
	

}
