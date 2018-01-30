package main;

import java.util.Scanner;
import java.io.*;
public class ATM {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("Input.txt");
		Scanner input = new Scanner(file);
		Bills register = new Bills();
		
		System.out.println("Hello Welcome to your friendly neighborhood ATM");
		System.out.println("What would you like to do today?");
		System.out.println("R - to restock the machine");
		System.out.println("W $(dollar amount) - withdraw that amount");
		System.out.println("I $(type of bill) - check how many of that bill is in the machine");
		System.out.println("Q - quit");
		

		while (input.hasNextLine()) {
			String user = input.nextLine();
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
			/*System.out.println("Hello Welcome to your friendly neighborhood ATM");
			System.out.println("What would you like to do today?");
			System.out.println("R - to restock the machine");
			System.out.println("W $(dollar amount) - withdraw that amount");
			System.out.println("I $(type of bill) - check how many of that bill is in the machine");
			System.out.println("Q - quit");*/
			

		}
		
		System.out.println("Quit application");
		input.close();
	}

}
