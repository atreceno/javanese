package com.atreceno.it.javanese.attic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanConverterTest {

	@Test
	public void testSolution() {
		RomanConverter rc = new RomanConverter();
		assertEquals("XIII", rc.solution(13));
		assertEquals("IX", rc.solution(9));
		assertEquals("MCMLXXVI", rc.solution(1976));
	}

	@Test
	public void testSolution2() {
		RomanConverter rc = new RomanConverter();
		assertEquals("XIII", rc.solution2(13));
		assertEquals("IX", rc.solution2(9));
		assertEquals("MCMLXXVI", rc.solution2(1976));
	}

	@Test
	public void testSolution3() {
		RomanConverter rc = new RomanConverter();
		assertEquals("XIII", rc.solution3(13));
		assertEquals("IX", rc.solution3(9));
		assertEquals("MCMLXXVI", rc.solution3(1976));
	}

	@Test
	public void testSolution4() {
		RomanConverter rc = new RomanConverter();
		assertEquals("XIII", rc.solution4(13));
		assertEquals("IX", rc.solution4(9));
		assertEquals("MCMLXXVI", rc.solution4(1976));
	}

}
