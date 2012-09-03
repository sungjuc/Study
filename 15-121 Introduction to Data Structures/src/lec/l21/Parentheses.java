package lec.l21;

import lec.l20.LLStack;

public class Parentheses {

	public static void main(String[] args) {
		String valid = "((()()))";
		String invalid = ")()(";
		System.out.println(valid + " : " + Parentheses.isLegal1(valid));
		System.out.println(invalid + " : " + Parentheses.isLegal1(invalid));
		System.out.println(valid + " : " + Parentheses.isLegal2(valid));
		System.out.println(invalid + " : " + Parentheses.isLegal2(invalid));

		String valid2 = "()[]";
		String invalid2 = "([)]";
		System.out.println(valid2 + " : " + Parentheses.isLegal(valid2));
		System.out.println(invalid2 + " : " + Parentheses.isLegal(invalid2));
	}

	public static boolean isLegal1(String s){
		int openCount = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("("))
				openCount++;
		}

		return openCount * 2 == s.length();
	}

	public static boolean isLegal2(String s){
		int openCount = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("("))
				openCount++;
			else
				openCount--;

			if (openCount < 0)
				return false;
		}

		return openCount == 0;
	}

	public static boolean isLegal3(String s){
		int openCount = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("(") || s.substring(i, i + 1).equals("["))
				openCount++;
			else
				openCount--;

			if (openCount < 0)
				return false;
		}

		return openCount == 0;
	}

	public static boolean isLegal(String s) {
		LLStack<String> stack = new LLStack<String>();
		for (int i = 0; i< s.length(); i++) {
			String subs = s.substring(i, i + 1);
			if (subs.equals("(") || subs.equals("[")) {
				stack.push(subs);
			} else if(stack.isEmpty())
				return false;
			else {
				if ((subs.equals(")") && !stack.pop().equals("(")) ||
				   (subs.equals("]") && !stack.pop().equals("["))){
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}