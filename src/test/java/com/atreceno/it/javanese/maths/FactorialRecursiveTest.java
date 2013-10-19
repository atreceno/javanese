package com.atreceno.it.javanese.maths;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class FactorialRecursiveTest {

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void testCalculate() {
		FactorialRecursive factorial = new FactorialRecursive();
		Assert.assertEquals(1, factorial.calculate(0));
		Assert.assertEquals(24, factorial.calculate(4));
		Assert.assertEquals(120, factorial.calculate(5));
		Assert.assertEquals(479001600, factorial.calculate(12));
		Assert.assertEquals(new BigInteger("1"),
				factorial.calculate(new BigInteger("0")));
		Assert.assertEquals(new BigInteger("120"),
				factorial.calculate(new BigInteger("5")));
		Assert.assertEquals(new BigInteger("479001600"),
				factorial.calculate(new BigInteger("12")));
		Assert.assertEquals(new BigInteger(
				"10333147966386144929666651337523200000000"), factorial
				.calculate(new BigInteger("35")));
	}

}
