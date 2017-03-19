package net.ukr.grygorenko_d;

import java.util.Arrays;

public class MyStack {
	private Object[] myStack;
	private Blacklist bl;

	public MyStack(Object[] myStack, Blacklist bl) {
		super();
		this.myStack = myStack;
		this.bl = bl;
	}

	public MyStack() {
		super();
		myStack = new Object[0];
		bl = new Blacklist();

	}

	public void toBlacklist(Object obj) {
		bl.toBlacklist(obj);
	}

	public void fromBlacklist(Object obj) {
		bl.fromBlacklist(obj);
	}

	public void push(Object obj) {
		Class tmp = obj.getClass();
		if (!bl.isBlacklisted(tmp)) {
			Object[] myStack2 = new Object[myStack.length + 1];
			System.arraycopy(myStack, 0, myStack2, 1, myStack.length);
			myStack2[0] = obj;
			myStack = myStack2;
			System.out.println("Oblect " + obj + "( " + obj.getClass().getSimpleName() + ") was added to the stack.");
		} else {
			System.out.println("Object's class (" + obj.getClass().getSimpleName() + ") is blacklisted, cannot add!");
		}
	}

	public Object peek() {
		return myStack[0];
	}

	public Object pop() throws StackIsEmpty {
		if (myStack.length > 0) {
			Object[] myStack2 = new Object[myStack.length - 1];
			System.arraycopy(myStack, 1, myStack2, 0, myStack.length - 1);
			Object temp = myStack[0];
			myStack = myStack2;
			return temp;
		} else {
			throw new StackIsEmpty("Cannot pop an element - stack is empty!");
		}

	}

	@Override
	public String toString() {
		System.out.print("MyStack [");
		for (Object obj : myStack) {
			System.out.print(obj + "(" + obj.getClass().getSimpleName() + "), ");
		}
		System.out.println(" ]");
		return "";
	}

}
