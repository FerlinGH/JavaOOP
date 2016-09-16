package net.ukr.grygorenko_d;

import java.util.ArrayList;

public class Group implements Dekanat, Voenkom{
	ArrayList<Student> groupArray = new ArrayList<>(10);

	public Group(ArrayList<Student> groupArray) {
		super();
		this.groupArray = groupArray;
	}

	public Group() {
		super();
	}

	public ArrayList<Student> getGroupArray() {
		return groupArray;
	}

	public void setGroupArray(ArrayList<Student> groupArray) {
		this.groupArray = groupArray;
	}

	public void setGroup(Student...students){
		for (Student student : students) {
			groupArray.add(student);
			System.out.println(student);
		}
		
	}
	public void addStudent(Student student) {
		try {
			if (groupArray.size() < 10) {
				groupArray.add(student);
				System.out.println("Student " + student.getName() + " was added to the group, which size is "
						+ groupArray.size() + " now.");
			} else {
				throw new MyException();
			}
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

	public void showStudent(Student student) {
		boolean isInGroup = groupArray.contains(student);
		if (isInGroup) {
			for (int i = 0; i < groupArray.size(); i++) {
				if (groupArray.get(i).equals(student)) {
					System.out.println("Student " + groupArray.get(i).getName() + " is enlisted by No."
							+ (1 + groupArray.indexOf(groupArray.get(i))));
					System.out.println("Student [name = " + student.getName() + ", gender = " + student.getGender()
							+ ", age = " + student.getAge() + ", faculty=" + student.getFaculty() + ", group="
							+ student.getGroup() + ", rate=" + student.getRate() + "]");
				}
			}
		} else {
			System.out.println("No such student in the group");
		}
	}

	public void findStudent(String name, int marker) {
		boolean isInGroup = false;
		for (Student student : groupArray) {
			if (student.getName() == name) {
				// System.out.println("Found the student.");
				isInGroup = true;
				if (marker == 0) {
					showStudent(student);
					break;
				} else {
					removeStudent(student);
					break;
				}
			}
		}
		if (!isInGroup) {
			System.out.println("No such student in the group.");
		}
	}

	public void removeStudent(Student student) {
		groupArray.remove(student);
		System.out.println("Student " + student.getName() + " was removed from the group, which size is "
				+ groupArray.size() + " now.");
	}
	
	public ArrayList<Student> callOfDyty(){
		ArrayList<Student> toSummon = new ArrayList<>();
			for (Student student : groupArray) {
				if((student.getGender().equals("male")) && (student.getAge()>=18)){
					toSummon.add(student);
				}
			}
		return toSummon;
	}

}
