package com.atreceno.it.javanese.maths;

import java.math.BigInteger;

public class Benchmark {

	public static void main(String[] args) {

		FactorialRecursive factorialRecursive = new FactorialRecursive();

		FactorialIteration factorialIteration = new FactorialIteration();
		System.out.println("iteration");
		for (int i = 0; i < 50; i++) {
			long start = System.nanoTime();
			factorialIteration.calculate(new BigInteger(String.valueOf(i)));
			long end = System.nanoTime();
			System.out.println(i + " - " + (end - start)/1000 + "ms");
		}

		System.out.println("recursive");
		for (int i = 0; i < 50; i++) {
			long start = System.nanoTime();
			factorialRecursive.calculate(new BigInteger(String.valueOf(i)));
			long end = System.nanoTime();
			System.out.println(i + " - " + (end - start)/1000 + "ms");
		}

	}

}
