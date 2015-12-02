package friday.calculator.parser;

import java.util.Stack;

import friday.calculator.token.Token;

public class PostfixHelperMethods {
	public static String appender(String str, int index) {
		if (Token.isDigit(str.charAt(index)) || str.charAt(index) != '-') {
			return " ";
		}
		char current = str.charAt(index);
		String s = String.valueOf(current);
		if (current == '-') {
			index++;
			current = str.charAt(index);
			s += String.valueOf(current);
		}
		while (++index < str.length() && Token.isDigit(current) || current == '.') {
			current = str.charAt(index);
			s += current;
		}
		if (!Token.isDigit(s.charAt(s.length() - 1))) {
			return s.substring(0, s.length() - 1);
		}
		return s;
	}

	public static String appendNumbers(String str, int index) {
		char current = str.charAt(index);
		String s = String.valueOf(current);
		while (++index < str.length() && Token.isDigit(current) || current == '.') {
			current = str.charAt(index);
			s += current;
		}
		if (!Token.isDigit(s.charAt(s.length() - 1))) {
			return s.substring(0, s.length() - 1);
		}
		return s;
	}

	public static StringBuilder appendOperator(Stack<Character> operators, char currentToken, StringBuilder postfix) {
		char stackToken = operators.peek();
		if (!Token.isBracket(currentToken) && Token.priority(currentToken) <= Token.priority(stackToken)) {
			while (!operators.isEmpty() && Token.priority(operators.peek()) >= Token.priority(currentToken)) {
				postfix.append(" " + operators.pop());
			}
		}
		return postfix;
	}
}