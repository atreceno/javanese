package com.atreceno.it.javanese.attic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author atreceno
 */
public class TruncateListMain {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		// Fill in the list with random values
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			list.add(new Integer(random.nextInt(10)));
		}

		// Show the values before removing anything
		System.out.print("Input list: \t");
		for (Integer num : list) {
			System.out.print(num + ", ");
		}

		TruncateList tlist = new TruncateList();
		tlist.truncate(list, 5);

		// Show the final values
		System.out.print("\nOutput list:\t");
		for (Integer num : list) {
			System.out.print(num + ", ");
		}

	}

}
