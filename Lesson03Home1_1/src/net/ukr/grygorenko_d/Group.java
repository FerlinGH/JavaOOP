package net.ukr.grygorenko_d;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private Student[] groupArray = new Student[10];

	public Group(Student[] groupArray) {
		super();
		this.groupArray = groupArray;
	}

	public Group() {
		super();
	}

	public Student[] getGroupArray() {
		return groupArray;
	}

	public void setGroupArray(Student[] groupArray) {
		this.groupArray = groupArray;
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
		for (Student st : groupArray) { // assume group is empty
			if (st != null) { // checking each entry for non-null value
				return false; // group is not empty
			}
		}
		return true;
	}

	public boolean isStudentInGroup(Student stud) {
		for (Student st : groupArray) { // check if this student is already in
										// group
			if (st == null) { // will not compare to empty cells
				continue;
			} else {
				if (st.equals(stud)) { // is this student already in this group?
					System.out.println("Student already in group, cannot add!");
					return true;
				}
			}
		}
		return false;
	}

	public void add(Student stud) throws MyException {
		if (isGroupEmpty()) { // is the group really empty?
			groupArray[0] = stud; // group is empty, so just add first student
		} else {
			for (int i = 0; i < groupArray.length; i++) { // group is not empty
				if (groupArray[i] == null) { // can add only to empty (null )
												// cell
					if (!isStudentInGroup(stud)) {
						groupArray[i] = stud; // student not in group, adding to
												// empty cell
						return;
					}
				}
			}
			throw new MyException("Group is full, cannot add!"); // full group,
																	// cannot
																	// add new
																	// student
		}
	}

	public void remove(String name) {
		System.out.print("Trying to remove student... ");
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i] != null && groupArray[i].getName().equalsIgnoreCase(name)) {
				groupArray[i] = null;
				System.out.println(name + " was found and removed.");
				return;
			}
		}
		System.out.println("Cannot find student " + name + ".");
	}

	@Override
	public String toString() {
		Arrays.sort(groupArray, new Comparator<Student>() {
			@Override
			public int compare(Student st1, Student st2) {
				if ((st1 != null) && (st2 == null)) {
					return -1;
				} else if ((st1 == null) && (st2 != null)) {
					return 1;
				} else if ((st1 == null) && (st2 == null)) {
					return 0;
				} else
					return st1.getName().compareTo(st2.getName());
			}
		});
		System.out.println();
		System.out.println("Current group: ");
		for (Student st : groupArray) {
			System.out.println(st);
		}
		return "";
	}

}
