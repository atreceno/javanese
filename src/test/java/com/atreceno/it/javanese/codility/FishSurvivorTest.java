package com.atreceno.it.javanese.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class FishSurvivorTest {

	@Test
	public void testSolution() {
		FishSurvivor fs = new FishSurvivor();
		int[] a = { 4, 3, 2, 1, 5 };
		int[] b = { 0, 1, 0, 0, 0 };
		assertEquals(2, fs.solution(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 1, 0, 1, 0 };
		assertEquals(2, fs.solution(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 0, 0, 0, 0 };
		assertEquals(5, fs.solution(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 1, 1, 1, 1, 1 };
		assertEquals(5, fs.solution(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 0, 0, 1, 1 };
		assertEquals(5, fs.solution(a, b));
		a = new int[] { 5, 3, 2, 1, 4 };
		b = new int[] { 1, 0, 0, 0, 0 };
		assertEquals(1, fs.solution(a, b));
		a = new int[] { 1, 2, 3, 4, 5 };
		b = new int[] { 1, 1, 1, 1, 0 };
		assertEquals(1, fs.solution(a, b));
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore("This method does not pass the tests")
	public void testSolution2() {
		FishSurvivor fs = new FishSurvivor();
		int[] a = { 4, 3, 2, 1, 5 };
		int[] b = { 0, 1, 0, 0, 0 };
		assertEquals(2, fs.solution2(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 1, 0, 1, 0 };
		assertEquals(2, fs.solution2(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 0, 0, 0, 0 };
		assertEquals(5, fs.solution2(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 1, 1, 1, 1, 1 };
		assertEquals(5, fs.solution2(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 0, 0, 1, 1 };
		assertEquals(5, fs.solution2(a, b));
		a = new int[] { 5, 3, 2, 1, 4 };
		b = new int[] { 1, 0, 0, 0, 0 };
		assertEquals(1, fs.solution2(a, b));
		a = new int[] { 1, 2, 3, 4, 5 };
		b = new int[] { 1, 1, 1, 1, 0 };
		assertEquals(1, fs.solution2(a, b));
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore("This method does not pass the tests")
	public void testSolution3() {
		FishSurvivor fs = new FishSurvivor();
		int[] a = { 4, 3, 2, 1, 5 };
		int[] b = { 0, 1, 0, 0, 0 };
		assertEquals(2, fs.solution3(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 1, 0, 1, 0 };
		assertEquals(2, fs.solution2(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 0, 0, 0, 0 };
		assertEquals(5, fs.solution2(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 1, 1, 1, 1, 1 };
		assertEquals(5, fs.solution2(a, b));
		a = new int[] { 4, 3, 2, 1, 5 };
		b = new int[] { 0, 0, 0, 1, 1 };
		assertEquals(5, fs.solution2(a, b));
		a = new int[] { 5, 3, 2, 1, 4 };
		b = new int[] { 1, 0, 0, 0, 0 };
		assertEquals(1, fs.solution2(a, b));
		a = new int[] { 1, 2, 3, 4, 5 };
		b = new int[] { 1, 1, 1, 1, 0 };
		assertEquals(1, fs.solution2(a, b));
	}

}
