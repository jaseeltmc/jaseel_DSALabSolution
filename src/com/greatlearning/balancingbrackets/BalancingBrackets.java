package com.greatlearning.balancingbrackets;

import java.util.Stack;

public class BalancingBrackets {

	public static boolean hasBalanceBrackets(String str) {
		Stack<Character> stack = new Stack<>();
		char[] ch = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			char c = ch[i];
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {

				if (stack.isEmpty()) {
					return false;
				}
				if (c == ')') {
					char temp = stack.pop();
					if (temp != '(') {
						return false;
					}
				} else if (c == ']') {
					char temp = stack.pop();
					if (temp != '[') {
						return false;
					}

				} else if (c == '}') {
					char temp = stack.pop();
					if (temp != '{') {
						return false;
					}

				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	static void checkBalanceBrackets(String str) {

		boolean ans = hasBalanceBrackets(str);
		if (ans == true) {
			System.out.println("GIven string is having balanced brackets");
		} else {
			System.out.println("Given string is not having balanced brackets");
		}
	}

	public static void main(String[] args) {

		String inputString;

		inputString = "([[{}]])";
		checkBalanceBrackets(inputString);

		System.out.println();

		inputString = "([[{}]]))";
		checkBalanceBrackets(inputString);

	}

}
