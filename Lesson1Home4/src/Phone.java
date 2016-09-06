public class Phone {
	
	private String number;

	public Phone(String number) {
		super();
		this.number = number;
		Network.numberBase.add(number);
	}

	public Phone() {
		super();
	}

	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone [number=" + number + "]";
	}

	

}
