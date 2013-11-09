package com.atreceno.it.javanese.attic;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Converter from decimal to Roman numeral.
 * 
 * @author atreceno
 * 
 */
public class RomanConverter {

	/**
	 * Declare and then initialize a map.
	 */
	private static final Map<String, Integer> ROMAN_DEC = new LinkedHashMap<String, Integer>();
	static {
		ROMAN_DEC.put("M", 1000);
		ROMAN_DEC.put("CM", 900);
		ROMAN_DEC.put("D", 500);
		ROMAN_DEC.put("CD", 400);
		ROMAN_DEC.put("C", 100);
		ROMAN_DEC.put("XC", 90);
		ROMAN_DEC.put("L", 50);
		ROMAN_DEC.put("XL", 40);
		ROMAN_DEC.put("X", 10);
		ROMAN_DEC.put("IX", 9);
		ROMAN_DEC.put("V", 5);
		ROMAN_DEC.put("IV", 4);
		ROMAN_DEC.put("I", 1);
	}

	/**
	 * A different way of initializing a map.
	 */
	private final static TreeMap<Integer, String> DEC_ROMAN = new TreeMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(1000, "M");
			put(900, "CM");
			put(500, "D");
			put(400, "CD");
			put(100, "C");
			put(90, "XC");
			put(50, "L");
			put(40, "XL");
			put(10, "X");
			put(9, "IX");
			put(5, "V");
			put(4, "IV");
			put(1, "I");
		}
	};

	/**
	 * Iterating the map with for-each loop.
	 * 
	 * @param num
	 *            number to convert.
	 * @return the number converted to Roman numeral.
	 */
	public String solution(int num) {
		StringBuffer result = new StringBuffer();
		for (Map.Entry<String, Integer> e : ROMAN_DEC.entrySet()) {
			while (num / e.getValue() > 0) {
				result.append(e.getKey());
				num -= e.getValue();
			}
		}
		return result.toString();
	}

	/**
	 * Iterating over a collection of Map.Entry<K,V> (using iterator).
	 * 
	 * @param num
	 *            number to convert.
	 * @return the number converted to Roman numeral.
	 */
	public String solution2(int num) {
		StringBuffer result = new StringBuffer();
		for (Iterator<Map.Entry<String, Integer>> entries = ROMAN_DEC
				.entrySet().iterator(); entries.hasNext();) {
			Map.Entry<String, Integer> e = entries.next();
			while (num / e.getValue() > 0) {
				result.append(e.getKey());
				num -= e.getValue();
			}
		}
		return result.toString();
	}

	/**
	 * Iterating over a collection of K (using iterator).
	 * 
	 * @param num
	 *            number to convert.
	 * @return the number converted to Roman numeral.
	 */
	public String solution3(int num) {
		StringBuffer result = new StringBuffer();
		for (Iterator<String> keys = ROMAN_DEC.keySet().iterator(); keys
				.hasNext();) {
			String key = keys.next();
			Integer value = ROMAN_DEC.get(key);
			while (num / value > 0) {
				result.append(key);
				num -= value;
			}
		}
		return result.toString();
	}

	/**
	 * Using recursive solution.
	 * 
	 * @param num
	 *            number to convert.
	 * @return the number converted to Roman numeral.
	 */
	public String solution4(int num) {
		Integer k = DEC_ROMAN.floorKey(num);
		return k == num ? DEC_ROMAN.get(k) : DEC_ROMAN.get(k)
				+ solution4(num - k);
	}

}
