package com.atreceno.it.javanese.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class IterateConcurrentCollection {

	public static void main(String[] args) {
		System.out.println("Start");
		List<String> list = Collections
				.synchronizedList(new ArrayList<String>());

		/* Update the list with N threads */
		for (int i = 0; i < 2; i++) {
			updateThreadList(i, list);
		}

		/* Read the list with the main thread */
		for (int i = 0;; i++) {
			System.out.println("Read: " + i + " \tList has " + list.size()
					+ " elements");
			synchronized (list) {
				for (String value : list) {
					if (value.contains("131313")) {
						System.out.println("Say it!");
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void updateThreadList(int i, final List<String> list) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("My name is: "
						+ Thread.currentThread().getName());
				while (!Thread.interrupted()) {
					list.add(UUID.randomUUID().toString() + "/"
							+ Thread.currentThread().getName());
				}
			}
		}, "tango" + i);
		thread.start();
	}

}
