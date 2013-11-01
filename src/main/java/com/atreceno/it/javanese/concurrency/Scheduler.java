package com.atreceno.it.javanese.concurrency;

public class Scheduler {

	private static final int NUM_OF_THREADS = 3;
	private static final int SLEEP_MILLIS = 1000;

	public static void main(String[] args) {
		System.out.println("Start");
		Scheduler scheduler = new Scheduler();

		SimpleThread[] threads = new SimpleThread[NUM_OF_THREADS];
		for (int i = 0; i < NUM_OF_THREADS; i++) {
			threads[i] = scheduler.new SimpleThread(i);
		}

		int i = 0;
		while (true) {

			System.out.println(Thread.currentThread().getName()
					+ ":  \tNotifying thread " + i);
			synchronized (threads[i]) {
				threads[i].notify();
			}
			try {
				Thread.sleep(SLEEP_MILLIS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i = ++i % NUM_OF_THREADS;
		}

	}

	public class SimpleThread extends Thread {

		private int value;

		public SimpleThread(int value) {
			this.value = value;
			this.setName("tango" + value);
			start();
		}

		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":\t"
							+ value + " ");
				}
			}
		}

	}

}
