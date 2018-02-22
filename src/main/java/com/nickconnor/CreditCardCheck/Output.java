package com.nickconnor.CreditCardCheck;

import java.util.Scanner;

/**
 * Hello MK!
 *
 */
public class Output {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean active = true;

		while (active) {
			System.out.println("Enter a credit card number (enter a blank line to quit): ");
			String creditCardNumber = null;
			while (creditCardNumber == null) {
				String userInput;
				userInput = scanner.nextLine();
				if (userInput.isEmpty()) {
					System.exit(0);
				} else if (userInput.length() != 16) {
					System.out.print("Please enter a valid CC Number --> ");
				} else {
					creditCardNumber = userInput;
				}
			}
			CreditCard creditCard = new CreditCard(creditCardNumber);
			System.out.println("Check digit should be: " + creditCard.getCalculatedCheckDigit());
			System.out.println("Check digit is: " + creditCard.getCheckDigit());
			String printStatement = creditCard.checkValidity() ? "Number is valid" : "Number is not valid";
			System.out.println(printStatement);
			System.out.println("----------------------");

		}
	}
}
