package com.atreceno.it.javanese.maths;

import java.math.BigInteger;

/**
 * Hello world!
 * 
 */
public class FactorialRecursive {

	/**
	 * Calculates the factorial of a given number using recursion.
	 * 
	 * @param num
	 * @return factorial of a number
	 */
	public int calculate(int num) {
		if (num == 0) {
			return 1;
		} else {
			return num * calculate(num - 1);
		}
	}

	public BigInteger calculate(BigInteger num) {
		if (num.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		} else {
			return num.multiply(calculate(num.subtract(BigInteger.ONE)));
		}
	}

}
