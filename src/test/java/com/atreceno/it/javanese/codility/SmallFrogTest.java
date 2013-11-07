package com.atreceno.it.javanese.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmallFrogTest {

	@Test
	public void testSolution() {
		SmallFrog sf = new SmallFrog();
		assertEquals(3, sf.solution(10, 85, 30));
		assertEquals(256, sf.solution(10, 777, 3));
		assertEquals(1, sf.solution(10, 40, 30));
		assertEquals(0, sf.solution(10, 10, 30));
	}

	@Test
	public void testSolution2() {
		SmallFrog sf = new SmallFrog();
		assertEquals(3, sf.solution2(10, 85, 30));
		assertEquals(256, sf.solution2(10, 777, 3));
		assertEquals(1, sf.solution2(10, 40, 30));
		assertEquals(0, sf.solution2(10, 10, 30));
	}

	@Test
	public void testSolution3() {
		SmallFrog sf = new SmallFrog();
		assertEquals(3, sf.solution3(10, 85, 30));
		assertEquals(256, sf.solution3(10, 777, 3));
		assertEquals(1, sf.solution3(10, 40, 30));
		assertEquals(0, sf.solution3(10, 10, 30));
	}

	@Test
	public void testSolution4() {
		SmallFrog sf = new SmallFrog();
		assertEquals(3, sf.solution4(10, 85, 30));
		assertEquals(256, sf.solution4(10, 777, 3));
		assertEquals(1, sf.solution4(10, 40, 30));
		assertEquals(0, sf.solution4(10, 10, 30));
	}

}
