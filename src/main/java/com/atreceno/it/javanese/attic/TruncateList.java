package com.atreceno.it.javanese.attic;

import java.util.List;

public class TruncateList {

	/**
	 * Remove values below a threshold from a list of Integers
	 * 
	 * @param list
	 * @param threshold
	 */
	public void truncate(List<Integer> list, int threshold) {

		if (list == null) {
			return;
		}

//		for (int i = 0; i < list.size(); i++) {
//			Integer value = list.get(i);
//			if (value < threshold) {
//				list.remove(i);
//				i--;
//			}
//		}
		
		// Remove the values below a threshold
		for (int i = list.size() -1 ; i >= 0; i--) {
			Integer value = list.get(i);
			if (value < threshold) {
				list.remove(i);
			}
		}

	}

}
