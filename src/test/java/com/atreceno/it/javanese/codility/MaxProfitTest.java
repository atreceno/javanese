package com.atreceno.it.javanese.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxProfitTest {

	@Test
	public void testSolution() {
		MaxProfit mp = new MaxProfit();
		assertEquals(0, mp.solution(new int[] {}));
		assertEquals(3, mp.solution(new int[] { 1, 2, 3, 4 }));
		assertEquals(0, mp.solution(new int[] { 4, 3, 2, 1 }));
		assertEquals(9, mp.solution(new int[] { 7, 5, 9, 6, 13, 3, 5, 12 }));
	}

}
