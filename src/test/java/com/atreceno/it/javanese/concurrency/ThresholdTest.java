package com.atreceno.it.javanese.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ThresholdTest {

	@Test
	public final void testTruncate() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(2, 4, 2, 5,
				1, 7, 9));
		Threshold t = new Threshold(6, list);
		t.truncate();
		Assert.assertArrayEquals(new Integer[] { 7, 9 },
				list.toArray(new Integer[0]));
	}

}
