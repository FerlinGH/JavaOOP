package net.ukr.grygorenko_d;

import java.util.ArrayList;
import java.util.List;

public class Blacklist {
	private List<Class> blacklist;

	public Blacklist(List<Class> blacklist) {
		super();
		this.blacklist = blacklist;
	}

	public Blacklist() {
		super();
		blacklist = new ArrayList<>();
	}

	public List<Class> getBlacklist() {
		return blacklist;
	}

	public void toBlacklist(Object obj) {
		Class temp = obj.getClass();
		if (isBlacklisted(temp)) {
			System.out.println("This class " + temp.getSimpleName() + " is already blacklisted.");
		} else {
			blacklist.add(temp);
			System.out.println("Class " + temp.getSimpleName() + " successfuly blacklisted.");
		}
	}

	public void fromBlacklist(Object obj) {
		Class temp = obj.getClass();
		if (isBlacklisted(temp)) {
			blacklist.remove(temp);
			System.out.println("Class " + temp.getSimpleName() + " removed from blacklist.");
		} else {
			System.out.println("Class " + temp.getSimpleName() + " is not in blacklist.");
		}
	}

	public boolean isBlacklisted(Class cls) {
		if (blacklist.contains(cls)) {
			return true;
		} else {
			return false;
		}
	}

}
