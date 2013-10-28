package com.atreceno.it.javanese.concurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class UpdateHashMap {

	static List<Thread> threadList = new ArrayList<Thread>();

	public static void main(String[] args) {
		System.out.println("Start");
		Map<Integer, String> map = new HashMap<Integer, String>(1000);

		/* Fill in the map with 1000 values */
		// for (int i = 0; i < 1000; i++) {
		// map.put(i, "Some Foo");
		// }

		/* Modify the map with N threads */
		for (int i = 0; i < 2; i++) {
			startUpdateThread(i, map);
		}
		for (Thread thread : threadList) {
			System.out.println(thread.getName());
		}

		/* Read the map with main thread */
		for (int i = 0;; i++) {
			System.out.println("Reading " + i + " times");
			for (Map.Entry<Integer, String> entry : map.entrySet()) {
				entry.toString();
				// System.out.println("Key:" + entry.getKey() + "\tValue:"
				// + entry.getValue());
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static void startUpdateThread(final int i,
			final Map<Integer, String> map) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while (!Thread.interrupted()) {
					Random random = new Random();
					map.put(random.nextInt(1000), UUID.randomUUID().toString()
							+ " " + i);
				}
			}
		});
		thread.setName("tango-" + i);
		threadList.add(thread);
		thread.start();
	}

}
