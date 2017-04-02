import java.util.ArrayList;

public class Network {
	static ArrayList<String> numberBase = new ArrayList<>();

	public Network() {
		super();
	}
	
	public boolean checkNumber (String number){
		if (!Network.numberBase.contains(number)){
			return true;
		}else{
			System.out.println("Number already exists!");
		}return false;
	}
	
	public void callNumber(String dialer, String number) {
		for (String string : numberBase) {
			System.out.println(string);
		}
		if (dialer.equals(number)) {
			System.out.println("Error! You cannot dial to yourself!");
		} else{
			if (Network.numberBase.contains(number)) {
				System.out.printf("Abonent %s is dialing %s... ", dialer, number);
				System.out.print("waiting for the abonent to pick-up..." + System.lineSeparator());
			} else {
				System.out.println("Error! Abonent not found!");
			} 
		}

	}
}
