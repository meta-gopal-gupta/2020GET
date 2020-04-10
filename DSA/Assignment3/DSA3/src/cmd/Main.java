package cmd;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VirtualCMD virtualCMD = new VirtualCMD();
		while (true) {
			System.out.print(virtualCMD.path + "> ");
			String command = sc.nextLine();
			virtualCMD.startCommandPrompt(command);
			if (command.equals("exit"))
				break;
		}
		sc.close();
	}
}
