package assignment1;
import java.util.Scanner;

public class User {
	String Username, Password;

	// creating arraylist

	void authenticate(Scanner scanner) {
		System.out.print("Hello User Please Enter Username:");
		Username = scanner.nextLine();
		System.out.print("Hello User Please Enter Passowrd:");
		Password = scanner.nextLine();
		System.out.println("Thank You for Authentication");
		System.out.println("Now You Can Buy Anything Here :)");
	}

}
