package com.atreceno.it.javanese.codility;

/**
 * Write a function that given a zero-indexed array A consisting of N integers
 * containing daily prices of a stock share for a period of N consecutive days,
 * returns the maximum possible profit from one transaction during this period.
 * The function should return 0 if it was impossible to gain any profit.
 * 
 * @author atreceno
 * 
 */
public class MaxProfit {

	/**
	 * Function that returns the maximum possible profit from one transaction
	 * during this period.
	 * 
	 * @param nums
	 *            Given a zero-indexed array A consisting of N integers
	 *            containing daily prices of a stock share for a period of N
	 *            consecutive days
	 * @return the maximum possible profit from one transaction during this
	 *         period.
	 */
	public int solution(int[] nums) {
		int min = nums.length == 0 ? 0 : nums[0];
		int maxdiff = 0;
		for (int num : nums) {
			int diff = num - min;
			if (diff < 0) {
				min = num;
			} else if (diff > maxdiff) {
				maxdiff = diff;
			}
		}
		return maxdiff;
	}

}
