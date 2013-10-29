package com.atreceno.it.javanese.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UpdateConcurrentHashMap {

	private static List<Thread> threadList = new ArrayList<Thread>();
	private static Random random = new Random();

	public static void main(String[] args) {
		System.out.println("Start");
		ConcurrentMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();

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

	/**
	 * Only updates the Map if key does not exist
	 * 
	 * @param i
	 * @param map
	 */
	private static void startUpdateThread(final int i,
			final ConcurrentMap<Integer, String> map) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while (!Thread.interrupted()) {

					map.putIfAbsent(random.nextInt(1000), UUID.randomUUID()
							.toString() + " " + i);
				}
			}
		});
		thread.setName("tango-" + i);
		threadList.add(thread);
		thread.start();
	}

}
