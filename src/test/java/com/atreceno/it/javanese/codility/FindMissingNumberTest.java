package com.atreceno.it.javanese.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMissingNumberTest {

	@Test
	public void testSolution() {
		FindMissingNumber fmn = new FindMissingNumber();
		int n = 1000000;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i + 2;
		}
		assertEquals(1, fmn.solution(a));
		assertEquals(4, fmn.solution(new int[] { 2, 3, 1, 5 }));
		assertEquals(2, fmn.solution(new int[] { 1 }));
		assertEquals(1, fmn.solution(new int[] { 2 }));
	}

	@Test
	public void testSolution2() {
		FindMissingNumber fmn = new FindMissingNumber();
		int n = 1000000;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i + 2;
		}
		assertEquals(1, fmn.solution2(a));
		assertEquals(4, fmn.solution2(new int[] { 2, 3, 1, 5 }));
		assertEquals(2, fmn.solution2(new int[] { 1 }));
		assertEquals(1, fmn.solution2(new int[] { 2 }));
	}

}
