package com.atreceno.it.javanese.chp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultipleTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void loop() {
		Multiple multiple = new Multiple();
		multiple.loop(101);
	}

	@Test
	public void business() {
		Multiple multiple = new Multiple();
		Assert.assertTrue(multiple.business(2).equals("2"));
		Assert.assertTrue(multiple.business(6).equals(
				Multiple.MULTIPLE_OF_THREE));
		Assert.assertTrue(multiple.business(10).equals(
				Multiple.MULTIPLE_OF_FIVE));
		Assert.assertTrue(multiple.business(30).equals(
				Multiple.MULTIPLE_OF_FIFTEEN));
	}

	@Test
	public void view() {
		Multiple multiple = new Multiple();
		multiple.view(Multiple.MULTIPLE_OF_FIFTEEN);
		Assert.assertEquals(Multiple.MULTIPLE_OF_FIFTEEN + "\n",
				outContent.toString());

	}

}
