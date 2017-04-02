/*
 * Опишите класс Phone (одним из свойств должен быть его номер). Так же опишите
класс Network (сеть мобильного оператора). Телефон должен иметь метод
регистрации в сети мобильного оператора. Так же у телефона должен быть метод call
(номер другого телефона), который переберет все телефоны зарегистрированные в
сети. Если такой номер найден, то осуществить вызов, если нет вывести сообщение
о неправильности набранного номера.
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String number = "";
		String toDial;
		Network umc = new Network();
		addNumbers();
		System.out.println("Welcome to UMC mobile network!");
		Scanner scan = new Scanner(System.in);
		boolean isValid = false;
		while (!isValid) {
			System.out.println("Enter your phone's number (should look like +380xxxxxxxxx):");
			number = scan.nextLine();
			if (umc.checkNumber(number)) {
				isValid = true;
			} else {
				continue;
			}
		}
		Phone myPhone = new Phone(number);
		System.out.println("Registration succesfull! You can now use UMC network.");
		
		System.out.print("Which number would you like to dial? ");
		System.out.println("(enter like +380xxxxxxxxx)");
		toDial = scan.nextLine();
		umc.callNumber(myPhone.getNumber(), toDial);
		scan.close();
	}
	static void addNumbers(){
		Network.numberBase.add("+380951111111");
		Network.numberBase.add("+380952222222");
		Network.numberBase.add("+380953333333");
		Network.numberBase.add("+380954444444");
		Network.numberBase.add("+380955555555");
		Network.numberBase.add("+380956666666");
		Network.numberBase.add("+380957777777");
	}
	

}
