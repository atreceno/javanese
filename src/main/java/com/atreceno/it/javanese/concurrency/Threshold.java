package com.atreceno.it.javanese.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
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
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			if (it.next() < this.threshold) {
				it.remove();
			}
		}
	}

	public void audit() {
		for (Integer value : this.list)
			if (value < this.threshold)
				System.out.println("ALERT!");
	}

	public void print() {
		System.out.println(this.list);
		System.out.println(this.threshold);
	}

	public static void main(String[] args) {

		/*
		 * new Threshold(3, Arrays.asList(2, 5, 2, 1, 7)) will throw an
		 * UnsupportedOperationException
		 */

		// Initialize the list
		List<Integer> myList = new ArrayList<Integer>(Arrays.asList(2, 5, 2, 1,
				7, -2, 0, 8));
		for (int i = 0; i < 1000; i++) {
			myList.add(new Random().nextInt(100));
		}

		Threshold t = new Threshold(90, myList);

		// N truncate threads
		for (int i = 0; i < 1; i++) {
			t.truncateThread(i);
		}

		// N audit threads
		for (int i = 0; i < 1; i++) {
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
