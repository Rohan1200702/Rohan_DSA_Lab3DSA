package com.gl.balancebrackets.main;

import java.util.*;

public class BalancedBrackets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression");
		String exp = sc.nextLine();
		if (checkBalancedExpression(exp))
			System.out.println("The given expression is Balanced");
		else
			System.out.println("The given expression is not Balanced");
	}

	public static boolean checkBalancedExpression(String input) {
		// create an empty stack
		char popChar = ' ';
		Stack<Character> stack = new Stack<Character>();
		// iterate input expression
		for (int i = 0; i < input.length(); i++) {
			// check whether current is '(', '[' or '{'
			if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
				// push current to stack
				stack.push(input.charAt(i));
				continue;
			}
			// to pop element from stack and if it is '}', ']' or ')',
			// return false
			else if (input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')') {
				// if stack is empty, return false
				if (stack.isEmpty()) {
					return false;
				}
				popChar = stack.pop();
				switch (popChar) {
				case '(':
					if (input.charAt(i) != ')')
						return false;
					break;
				case '{':
					if (input.charAt(i) != '}')
						return false;
					break;
				case '[':
					if (input.charAt(i) != ']')
						return false;
					break;
				}
			}
		}
		return (stack.isEmpty());
	}
}
