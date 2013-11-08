package com.atreceno.it.javanese.codility;

/**
 * A zero-indexed array A consisting of N different integers is given. The array
 * contains integers in the range [1..(N + 1)], which means that exactly one
 * element is missing. Your goal is to find that missing element.
 * 
 * <p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N).</li>
 * <li>expected worst-case space complexity is O(1).</li>
 * </ul>
 * </p>
 * 
 * @author atreceno
 * 
 */
public class FindMissingNumber {

	/**
	 * This solution uses two <code>long</code> primitive types.
	 * 
	 * @param a
	 *            array containing integers in the range [1..(N + 1)].
	 * @return the missing number
	 */
	public int solution(int[] a) {
		long n = a.length;
		long result = (n + 1) * (n + 2) / 2;
		for (int i = 0; i < n; i++) {
			result -= a[i];
		}
		return (int) result;
	}

	/**
	 * This solution only uses <code>int</code> primitive types.
	 * 
	 * @param a
	 *            array containing integers in the range [1..(N + 1)].
	 * @return the missing number
	 */
	public int solution2(int[] a) {
		int n = a.length;
		int result = n + 1;
		for (int i = 0; i < n; i++) {
			result = result + i + 1 - a[i];
		}
		return result;
	}

}
