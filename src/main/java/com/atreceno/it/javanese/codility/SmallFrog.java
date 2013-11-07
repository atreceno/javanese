package com.atreceno.it.javanese.codility;

public class SmallFrog {

	public int solution(int x, int y, int d) {
		int n = 0;
		while (x < y) {
			x += d;
			n++;
		}
		return n;
	}

	public int solution2(int x, int y, int d) {
		int n;
		for (n = 0; x < y; x += d) {
			n++;
		}
		return n;
	}

	public int solution3(int x, int y, int d) {
		int result;
		long start = System.nanoTime();
		result = (y - x) % d == 0 ? (y - x) / d : (y - x) / d + 1;
		System.out.println((System.nanoTime() - start) + "ns");
		return result;

	}

	public int solution4(int x, int y, int d) {
		int result;
		long start = System.nanoTime();
		result = (int) Math.ceil((double) (y - x) / (double) d);
		System.out.println((System.nanoTime() - start) + "ns");
		return result;
	}

}
