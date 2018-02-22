package com.nickconnor.CreditCardCheck;

public class CreditCard {

	private String creditCardNumber;
	private int checkDigit;
	private int calculatedCheckDigit;
	
	public CreditCard(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
		char checkDigitChar = creditCardNumber.charAt(creditCardNumber.length() - 1);
		this.checkDigit = Character.getNumericValue(checkDigitChar);
	}
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public int getCheckDigit() {
		return checkDigit;
	}
	
	public int getCalculatedCheckDigit() {
		calculateCheckDigit();
		return this.calculatedCheckDigit;
	}

	private void calculateCheckDigit() {
		int thisDigit;
		int[] evenArray = getEvenValues();
		int[] oddArray = getOddValues();
		for (int i = 0; i < evenArray.length; i++) {
			if (evenArray[i] >= 10) {
				evenArray[i] = evenArray[i] - 9;
			}
		}
		int sumValue = sumArrays(evenArray, oddArray);
		this.calculatedCheckDigit = 10 - (sumValue % 10);
	}
	
	private int[] getOddValues() {
		int[] numberArray = new int[7];
		int index = 0;
		for (int i = 1; i <= 13; i = i+2) {
			char temp = creditCardNumber.charAt(i);
			int thisValue = Character.getNumericValue(temp);
			numberArray[index] = thisValue;
			index++;
		}
		return numberArray;
	}
	
	private int[] getEvenValues() {
		int[] numberArray = new int[8];
		int index = 0;
		for (int i = 0; i <= 14; i = i+2) {
			char temp = creditCardNumber.charAt(i);
			int thisValue = Character.getNumericValue(temp);
			numberArray[index] = thisValue * 2;
			index++;
		}
		return numberArray;
	}
	
	private int sumArrays(int[] evenArray, int[] oddArray) {
		int sumValue = 0;
		for (int i = 0; i < evenArray.length; i++) {
			sumValue += evenArray[i];
		}
		for (int i = 0; i < oddArray.length; i++) {
			sumValue += oddArray[i];
		}
		return sumValue;
	}

	public boolean checkValidity() {
		return this.checkDigit == this.calculatedCheckDigit;
	}

	

	
	
}
