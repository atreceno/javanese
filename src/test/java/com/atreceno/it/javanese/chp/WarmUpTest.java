package com.atreceno.it.javanese.chp;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class WarmUpTest {

	@Test
	public void isLeapYear() {
		WarmUp af = new WarmUp();
		Assert.assertTrue(af.isLeapYear(2000));
		Assert.assertFalse(af.isLeapYear(2014));
	}

	@Test
	public void duplicate() {
		WarmUp af = new WarmUp();
		Assert.assertTrue(af.duplicate2(new int[] { 0, 0, 1, 2, 3, 4 }) == 0);
		Assert.assertTrue(af.duplicate2(new int[] { 0, 1, 1, 2, 3, 4 }) == 1);
		Assert.assertTrue(af.duplicate2(new int[] { 0, 1, 2, 2, 3, 4 }) == 2);
		Assert.assertTrue(af.duplicate2(new int[] { 0, 1, 2, 3, 3, 4 }) == 3);
		Assert.assertTrue(af.duplicate2(new int[] { 0, 1, 4, 4, 3, 2 }) == 4);
	}

	@Test
	public void fibonacci() {
		WarmUp af = new WarmUp();
		af.fibonacci(0);
		Assert.assertEquals(0, af.fibonacci2(0));
		Assert.assertEquals(1, af.fibonacci2(1));
		Assert.assertEquals(1, af.fibonacci2(2));
		Assert.assertEquals(2, af.fibonacci2(3));
		Assert.assertEquals(3, af.fibonacci2(4));
		Assert.assertEquals(5, af.fibonacci2(5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void fibanacciException() {
		WarmUp af = new WarmUp();
		af.fibonacci(-1);
	}

	@Test
	public void reverse() {
		WarmUp af = new WarmUp();
		Assert.assertEquals("C B A", af.reverse2("A B C"));
		Assert.assertEquals("D C B A", af.reverse2("A B C D"));
	}

	@Test
	public void histogram() {
		WarmUp af = new WarmUp();
		Assert.assertTrue(Arrays.equals(new int[] { 1, 0, 0, 2, 2, 1, 0 },
				af.histogram(6, new int[] { 3, 3, 0, 5, 4, 4 })));
	}

	@Test
	public void isWellFormed() {
		WarmUp af = new WarmUp();
		Assert.assertTrue(af.isWellFormed("ab{c[( d)efg]}hij()"));
		Assert.assertFalse(af.isWellFormed("ab{c[( defg]}hij"));
		Assert.assertFalse(af.isWellFormed("ab{c[( d)efg]}hij("));
	}
}
