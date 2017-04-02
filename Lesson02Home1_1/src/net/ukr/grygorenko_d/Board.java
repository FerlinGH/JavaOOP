package net.ukr.grygorenko_d;

public class Board {
	private static Shape[] board = new Shape[4];

	public Board() {
		super();
	}

	public void addShape(Shape shape) {
		boolean isPlaced = false;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == null) {
				board[i] = shape;
				isPlaced = true;
				break;
			}
		}
		if (isPlaced) {
			System.out.printf("Your %s is on the board now" + System.lineSeparator(), shape.getClass().getSimpleName());
		} else {
			System.out.printf("Cannot place your %s" + System.lineSeparator(), shape.getClass().getSimpleName());
		}
	}

	public void removeShape(Shape shape) {
		boolean isRemoved = false;
		for (int i = 0; i < board.length; i++) {
			if (board[i] != null) {
				if (board[i].equals(shape)) {
					board[i] = null;
					isRemoved = true;
					break;
				}
			} else {
				continue;
			}
		}
		if (isRemoved) {
			System.out.printf("Your %s was removed from the board" + System.lineSeparator(),
					shape.getClass().getSimpleName());
		} else {
			System.out.printf("Cannot locate your %s" + System.lineSeparator(), shape.getClass().getSimpleName());
		}

	}

	public void getBoardStatus() {
		System.out.println("Currently on the board:");
		double area = 0;
		for (Shape shape : board) {
			System.out.println(shape);
			if (shape != null) {
				area += shape.getArea();
			} else {
				continue;
			}
		}
		System.out.println("Total area of all shapes is " + area);
	}

}
