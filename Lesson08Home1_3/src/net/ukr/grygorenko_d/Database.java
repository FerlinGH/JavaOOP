package net.ukr.grygorenko_d;

import java.io.Serializable;

public class Database implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dataName;
	private Group[] groups;

	public Database(String dataName, Group[] groups) {
		super();
		this.dataName = dataName;
		this.groups = groups;
	}

	public Database(String dataName) {
		super();
		this.dataName = dataName;
		this.groups = new Group[0];
	}

	public void addGroup(Group gr) {
		Group[] groups2 = new Group[groups.length + 1];
		System.arraycopy(groups, 0, groups2, 0, groups.length);
		groups2[groups.length] = gr;
		groups = groups2;
	}

	@Override
	public String toString() {
		System.out.println("Database " + dataName + " contains:");
		for (Group gr : groups) {
			System.out.println(gr);
		}
		System.out.println("End of database.");
		return "";
	}

}
