package com.atreceno.it.javanese.chp;

/**
 * The challenge is to implement a program that prints numbers from 1 to N,
 * where N is less than or equal to 100. If the number is multiple of 3, prints
 * "xThree", if it is multiple of 5, prints "xFive". And if it is multiple of
 * 15, prints "xFifteen". Do a proper test.
 * 
 * @author atreceno
 * 
 */
public class Multiple {

	final static String MULTIPLE_OF_THREE = "xThree";
	final static String MULTIPLE_OF_FIVE = "xFive";
	final static String MULTIPLE_OF_FIFTEEN = "xFifteen";

	public static void main(String[] args) {
		Multiple multiple = new Multiple();
		multiple.loop(30);
	}

	public void loop(int max) {
		if (max > 100) {
			throw new IllegalArgumentException("max is greater than 100");
		}
		for (int i = 1; i <= max; i++) {
			view(business(i));
		}
	}

	/**
	 * This function implements the business logic.
	 * 
	 * @param number
	 *            The input of the function.
	 * @return a <code>String</code> with the result according to the business
	 *         logic.
	 */
	public String business(int number) {

		if (number % 15 == 0) {
			return MULTIPLE_OF_FIFTEEN;
		} else if (number % 5 == 0) {
			return MULTIPLE_OF_FIVE;
		} else if (number % 3 == 0) {
			return MULTIPLE_OF_THREE;
		} else {
			return String.valueOf(number);
		}
	}

	public void view(String value) {
		System.out.println(value);
	}

}
