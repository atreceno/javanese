package com.atreceno.it.javanese.codility;

import java.util.Stack;

/**
 * You are given two non-empty zero-indexed arrays A and B consisting of N
 * integers. Arrays A and B represent N voracious fish in a river, ordered
 * downstream along the flow of the river. The fish are numbered from 0 to N−1,
 * fish number P is represented by A[P] and B[P], and if P < Q, then fish P is
 * initially upstream of fish Q. Initially, each fish has a unique position.
 * Array A contains the sizes of the fish. All its elements are unique. Array B
 * contains the directions of the fish. Given two non-empty zero-indexed arrays
 * A and B consisting of N integers, write a function that returns the number of
 * fish that will stay alive.
 * 
 * @author atreceno
 * 
 */
public class FishSurvivor {

	/**
	 * Given two non-empty zero-indexed arrays A and B consisting of N integers,
	 * this function returns the number of fish that will stay alive.
	 * 
	 * @param a
	 *            array representing the size.
	 * @param b
	 *            array representing the direction.
	 * @return the number of fish that will stay alive.
	 */
	public int solution(int[] a, int[] b) {
		int survivors = 0;
		Stack<Integer> ones = new Stack<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (b[i] == 0) {
				if (ones.size() == 0) {
					survivors++;
				} else { // Duel
					while (!ones.empty()) {
						if (a[i] > ones.peek()) { // "One" dies
							ones.pop();
						} else { // "Zero" dies
							break;
						}
					}
					if (ones.empty()) { // "Zero" survives
						survivors++;
					}
				}
			} else {
				ones.push(a[i]);
			}
		}
		return survivors + ones.size();
	}

	/**
	 * Solution found in StackExchange (This solution is wrong!)
	 * 
	 * @see <a href="http://codereview.stackexchange.com">StackExchange</a>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	@Deprecated
	public int solution2(int[] A, int[] B) {
		int alive = 0;
		int i = 0, n = A.length;
		Stack<School> down = new Stack<School>();
		down.push(new School());
		while (i < n && B[i] == UP) {
			alive++;
			i++;
		}
		while (i < n) {
			if (B[i] == DOWN) {
				School top = down.peek();
				if (A[i] >= top.largest) {
					top.count++;
					top.largest = A[i];
				} else {
					down.push(new School(A[i]));
				}
			} else {
				School top = down.pop();
				while (top.largest < A[i] && !down.empty()) {
					top = down.pop();
				}
				if (top.largest < A[i]) {
					alive++;
					down.push(new School());
				} else {
					down.push(top);
				}
			}
			i++;
		}
		while (!down.empty()) {
			alive += down.pop().count;
		}
		return alive;
	}

	private class School {
		public int count;
		public int largest;

		public School() {
			this.count = 0;
			this.largest = 0;
		}

		public School(int size) {
			this.count = 1;
			this.largest = size;
		}
	}

	private final int UP = 1, DOWN = 0;

	/**
	 * Solution found in StackExchange (This solution is wrong!)
	 * 
	 * @see <a href="http://codereview.stackexchange.com">StackExchange</a>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	@Deprecated
	public int solution3(int[] A, int[] B) {
		int n = A.length;
		if (n < 1 || n > 100000)
			return -1;
		int alive = n;
		Stack<Integer> down = new Stack<Integer>();
		boolean[] lives = new boolean[n];
		for (int i = 0; i < n; i++)
			lives[i] = true;
		for (int i = 0, k = i + 1; i < n - 1; i++) {
			if (B[i] == 0)
				continue;
			for (; k < n; k++) {
				if (B[i] == B[k] && B[i] == 1)
					down.push(k);
				if (A[i] > A[k] && B[i] != B[k] && B[i] == 1 && lives[k]) {
					alive--;
					lives[k] = false;
				} else if (A[i] < A[k] && B[i] != B[k] && B[i] == 1 && lives[i]) {
					alive--;
					lives[i] = false;
					while (!down.empty() && i != down.peek()) {
						i = down.pop();
						if (A[i] < A[k] && lives[i]) {
							alive--;
							lives[i] = false;
						} else if (A[i] > A[k] && lives[k]) {
							alive--;
							lives[k] = false;
							break;
						}
					}
				}
			}
		}
		return alive;
	}

}
