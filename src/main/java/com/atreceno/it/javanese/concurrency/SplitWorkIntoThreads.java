package com.atreceno.it.javanese.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SplitWorkIntoThreads {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		SplitWorkIntoThreads split = new SplitWorkIntoThreads();
		split.start();
	}

	private void start() throws InterruptedException {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		/* There are 10 tasks to work on */
		for (int i = 0; i < 3; i++) {
			final int j = i;
			queue.add(new Runnable() {

				@Override
				public void run() {
					doSomething(j);
				}
			});
		}
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 1000,
				TimeUnit.MILLISECONDS, queue);
		executor.prestartAllCoreThreads();
		executor.shutdown();
		executor.awaitTermination(100000, TimeUnit.MILLISECONDS);

		System.out.println("End");
	}

	private double doSomething(int i) {
		System.out.println("Thread " + Thread.currentThread().getName()
				+ " is working on task #" + i);
		double result = 1;
		for (int j = 0; j < 100; j++) {
			result *= Math.sqrt(i + j);
		}
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + Thread.currentThread().getName()
				+ " finished task #" + i);
		return result;
	}
}
