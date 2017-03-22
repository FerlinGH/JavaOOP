package net.ukr.grygorenko_d;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Group implements Voenkom {
	private List<Student> groupList = new ArrayList<>();

	public Group(List<Student> groupList) {
		super();
		this.groupList = groupList;
	}

	public Group() {
		super();
	}

	public List<Student> getGroupList() {
		return groupList;
	}

	public void setGroupArray(List<Student> groupList) {
		this.groupList = groupList;
	}

	public void createGroup() throws MyException {
		Student stud1 = new Student("Mike", "male", 23, "Art", 2, 375829);
		Student stud2 = new Student("George", "male", 22, "Chemistry", 1, 196748);
		Student stud3 = new Student("Helen", "female", 23, "Physics", 4, 334975);
		Student stud4 = new Student("Markus", "male", 23, "Biology", 1, 295837);
		Student stud5 = new Student("Paul", "male", 24, "Biology", 3, 1058285);
		Student stud6 = new Student("Phillip", "male", 17, "Math", 1, 684299);
		Student stud7 = new Student("Anna", "female", 19, "Biology", 2, 119475);
		Student stud8 = new Student("Julia", "female", 15, "History", 1, 504395);
		Student stud9 = new Student("Patrick", "male", 24, "Geography", 3, 104485);
		this.add(stud1);
		this.add(stud2);
		this.add(stud3);
		this.add(stud4);
		this.add(stud5);
		this.add(stud6);
		this.add(stud7);
		this.add(stud8);
		this.add(stud9);
	}

	public boolean isGroupEmpty() {
		if (groupList.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean isStudentInGroup(Student stud) {
		for (Student st : groupList) {
			if (st.equals(stud)) {
				System.out.println("Student already in group, cannot add!");
				return true;
			}
		}
		return false;
	}

	public void add(Student stud) throws MyException {
		if (groupList.size() < 10) {
			if (!isStudentInGroup(stud)) {
				groupList.add(stud);
				return;
			}
		}

		throw new MyException("Group is full, cannot add!");
	}

	public void addInteractive() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter student's name:");
		String name = scan.nextLine();
		System.out.println("Now enter student's gender (male/female):");
		String gender = scan.nextLine();
		if ((gender.equalsIgnoreCase("male")) || (gender.equalsIgnoreCase("female"))) {
		} else {
			System.out.println("Error! Gender can only be 'male' or 'female'. Setting to 'male'.");
			gender = "male";
		}
		System.out.println("Now enter student's age:");
		int age = scan.nextInt();
		scan.nextLine();
		System.out.println("Now enter student's faculty:");
		String faculty = scan.nextLine();
		System.out.println("Now enter student's course:");
		int course = scan.nextInt();
		scan.nextLine();
		System.out.println("Finally enter student's gradebook number:");
		int gradebook = scan.nextInt();
		scan.close();
		this.add(new Student(name, gender, age, faculty, course, gradebook));
	}

	public void remove(String name) {
		System.out.print("Trying to remove student... ");
		for (int i = 0; i < groupList.size(); i++) {
			if (groupList.get(i).getName().equalsIgnoreCase(name)) {
				groupList.remove(i);
				System.out.println(name + " was found and removed.");
				return;
			}
		}
		System.out.println("Cannot find student " + name + ".");
	}

	public void sortGroup(String param) {
		Collections.sort(groupList, new Comparator<Student>() {

			@Override
			public int compare(Student st1, Student st2) {
				if ((st1 != null) && (st2 == null)) {
					return -1;
				} else if ((st1 == null) && (st2 != null)) {
					return 1;
				} else if ((st1 == null) && (st2 == null)) {
					return 0;
				} else {
					switch (param) {
					case "name":
						return st1.getName().compareTo(st2.getName());
					case "gender":
						return st1.getGender().compareTo(st2.getGender());
					case "age":
						return st1.getAge() - st2.getAge();
					case "faculty":
						return st1.getFaculty().compareTo(st2.getFaculty());
					case "course":
						return st1.getCourse() - st2.getCourse();
					case "gradebook":
						return st1.getGradebook() - st2.getGradebook();
					default:
						System.out.println("Unknown parameter!");
					}

					return 0;
				}
			}
		});

	}

	public void saveGroup(File file) {
		StringBuilder sb = new StringBuilder();
		for (Student student : groupList) {
			sb.append(student.getName() + ";");
			sb.append(student.getGender() + ";");
			sb.append(student.getAge() + ";");
			sb.append(student.getFaculty() + ";");
			sb.append(student.getCourse() + ";");
			sb.append(student.getGradebook() + ";");
			sb.append(System.lineSeparator());

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
				bw.write(sb.toString());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void loadGroup(File file) {
		List<String> readedLine = new ArrayList<>(groupList.size());
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String str = "";
			while( (str = br.readLine()) != null){
				readedLine.add(str);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		for (int i = 0; i < readedLine.size(); i++) {
			String[] values = readedLine.get(i).split(";");
			String name = values[0];
			String gender = values[1];
			int age = Integer.parseInt(values[2]);
			String faculty = values[3];
			int course = Integer.parseInt(values[4]);
			int gradebook = Integer.parseInt(values[5]);
			this.add(new Student(name, gender, age, faculty, course, gradebook));
		}

	}

	@Override
	public List<Student> toArmy() {
		List<Student> toSummon = new ArrayList<>();
		for (Student st : groupList) {
			if ((st.getGender().equals("male")) && (st.getAge() >= 18)) {
				toSummon.add(st);
			}
		}
		return toSummon;

	}

}
