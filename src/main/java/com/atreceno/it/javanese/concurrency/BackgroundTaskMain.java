package com.atreceno.it.javanese.concurrency;

/**
 * @author atreceno
 * 
 *         Problem: You have a task that needs to be run outside of your main
 *         thread.
 */
public class BackgroundTaskMain {

	public static void doSomethingInBackground() {
		for (int i = 0; i < 5; i++) {
			System.out.println("My name is: "
					+ Thread.currentThread().getName() + "\tIteracion: " + i);
		}
	}

	public static void main(String[] args) {
		Thread backgroundThread = new Thread(new Runnable() {
			@Override
			public void run() {
				doSomethingInBackground();
			}
		}, "bgth");
		backgroundThread.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("My name is: "
					+ Thread.currentThread().getName() + "\tIteration: " + i);
		}
	}

}
