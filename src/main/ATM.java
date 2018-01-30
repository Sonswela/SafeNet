package main;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Bills register = new Bills();
		String user = input.nextLine();
		while (!(user.equalsIgnoreCase("Q"))) {
			String temp = user;
			user = user.substring(0, 1);
			user = user.toUpperCase();
			if (user.equals("R")) {
				register.restock();
			} else if (user.equals("W")) {
				temp = temp.substring(temp.indexOf("$") + 1);
				register.withdraw(Integer.parseInt(temp));
				register.denominations();
			} else if (user.equals("I")) {
				temp = temp.substring(temp.indexOf("$") + 1);
				while (temp.contains("$")) {
					String num = temp.substring(0, temp.indexOf("$") - 1);
					System.out.println(num + " - " + register.getBill(register.reverseConvert(Integer.parseInt(num))));
					temp = temp.substring(temp.indexOf("$") + 1);
				}
				System.out.println(temp + " - " + register.getBill(register.reverseConvert(Integer.parseInt(temp))));
			} else if (user.equals("T")) {
				System.out.println(register.getTotal());
			} else {
				System.out.println("Failure: Invalid Command");
			}
			user = input.nextLine();

		}
		System.out.println("Quit application");
	}

}
