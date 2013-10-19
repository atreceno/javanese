package com.atreceno.it.javanese.maths;

import java.math.BigInteger;

/**
 * Hello world!
 * 
 */
public class FactorialIteration {

	/**
	 * Calculates the factorial of a given number using a for loop.
	 * 
	 * @param num
	 * @return factorial of a number
	 */
	public int calculate(int num) {
		int result = 1;
		if (num == 0) {
			return result;
		}
		for (int i = 2; i <= num; i++) {
			result = result * i;
		}
		return result;
	}

	public BigInteger calculate(BigInteger num) {
		if (num.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		BigInteger result = BigInteger.ONE;
		BigInteger i = BigInteger.ONE;
		while (i.compareTo(num) <= 0) {
			result = result.multiply(i);
			i = i.add(BigInteger.ONE);
		}
		return result;
	}

}
