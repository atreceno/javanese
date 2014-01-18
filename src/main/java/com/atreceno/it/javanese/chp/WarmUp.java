package com.atreceno.it.javanese.chp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class WarmUp {

	public boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	public int duplicate(int[] a) {
		int sum = 0;
		int n = a.length - 2;
		for (int i : a) {
			sum += i;
		}
		return sum - (n + 1) * n / 2;
	}

	public int duplicate2(int[] a) {
		int result = a.length - 1;
		for (int i = 0; i < a.length; i++) {
			result += a[i] - i;
		}
		return result;
	}

	public int fibonacci(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n<0");
		} else if (n <= 1) {
			return n;
		}
		int fn = 0;
		int fn2 = 0;
		int fn1 = 1;
		for (int i = 2; i <= n; i++) {
			fn = fn1 + fn2;
			fn2 = fn1;
			fn1 = fn;
		}
		return fn;
	}

	public int fibonacci2(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n<0");
		} else if (n <= 1) {
			return n;
		}
		return fibonacci2(n - 2) + fibonacci2(n - 1);
	}

	public String reverse(String names) {
		String[] a = names.split(" ");
		StringBuffer sb = new StringBuffer();
		for (String name : a) {
			sb.insert(0, " " + name);
		}
		return sb.toString().substring(1);
	}

	public String reverse2(String names) {
		String[] a = names.split(" ");
		Deque<String> deque = new ArrayDeque<String>(Arrays.asList(a));
		StringBuffer sb = new StringBuffer();
		while (deque.peekLast() != null) {
			sb.append(" ").append(deque.removeLast());
		}
		return sb.toString().substring(1);
	}

	public int[] histogram(int m, int[] a) {
		int[] b = new int[m + 1];
		Arrays.fill(b, 0);
		for (int v : a) {
			b[v]++;
		}
		return b;
	}
	
	public boolean isWellFormed(String s) {
		String ROUNDED_BRACKET = "ROUNDED_BRACKET";
		String SQUARE_BRACKET = "SQUARE_BRACKET";
		String CURLY_BRACKET = "CURLY_BRACKET";
		char[] chars = s.toCharArray();
		Deque<String> stack = new ArrayDeque<String>();
		for (char c : chars) {
			switch (c) {
			case '(':
				stack.addFirst(ROUNDED_BRACKET);
				break;
			case '[':
				stack.addFirst(SQUARE_BRACKET);
				break;
			case '{':
				stack.addFirst(CURLY_BRACKET);
				break;
			case ')':
				if (!ROUNDED_BRACKET.equals(stack.removeFirst()))
					return false;
				break;
			case ']':
				if (!SQUARE_BRACKET.equals(stack.removeFirst()))
					return false;
				break;
			case '}':
				if (!CURLY_BRACKET.equals(stack.removeFirst()))
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}
	
}
