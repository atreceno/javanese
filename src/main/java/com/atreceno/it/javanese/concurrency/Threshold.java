package com.atreceno.it.javanese.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Requirements: 1. Given a list of integers, remove the elements of the list
 * below a threshold. 2. Null and thread safe.
 * 
 * @author atreceno
 * 
 */
public class Threshold {

	private List<Integer> list;
	private int threshold;

	public Threshold(int threshold, List<Integer> list) {
		if (list == null)
			throw new IllegalArgumentException("list is null");
		this.list = list;
		this.threshold = threshold;
	}

	public void truncate() {
		// for(int i = list.size() - 1; i > 0; i--) {
		// if (list.get(i) < threshold)
		// list.remove(i);
		// }
		synchronized (list) {
			for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
				if (it.next() < threshold) {
					it.remove();
				}
			}
		}
	}

	public void audit() {
		// for(int i = 0; i< list.size(); i++) {
		// if (list.get(i) < threshold)
		// System.out.println("ALERT!");
		// }
		synchronized (list) {
			for (Integer value : list)
				if (value < threshold)
					System.out.println("ALERT!");
		}
	}

	public void print() {
		System.out.println(list);
		System.out.println(threshold);
	}

	public static void main(String[] args) {

		// Initialize the list
		List<Integer> myList = Collections
				.synchronizedList(new ArrayList<Integer>(Arrays.asList(7, -2,
						0, 8)));
		for (int i = 0; i < 100; i++) {
			myList.add(new Random().nextInt(100));
		}

		// Construct the class (Careful with UnsupportedOperationException)
		Threshold t = new Threshold(90, myList);

		// N truncate threads
		for (int i = 0; i < 4; i++) {
			t.truncateThread(i);
		}

		// N audit threads
		for (int i = 0; i < 4; i++) {
			t.auditThread(i);
		}

	}

	private void truncateThread(int i) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					truncate();
				}
			}

		}, "truncate-" + i);
		t.start();
	}

	private void auditThread(int i) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					audit();
				}
			}
		}, "audit-" + i);
		t.start();
	}

}
