package ojleet;

import java.util.Stack;

public class ReverseWords {

	/**
	 * @param args
	 * @author Cristiano
	 */
	public static void main(String[] args) {
		new ReverseWords();
	}

	public ReverseWords() {
		System.out.println(this.reverseWords("Teste de reverse words"));
	}

	public String reverseWords(String s) {
		Stack<String> stack = new Stack<String>();
		String tokens[] = s.split(" ");
		int length = tokens.length;
		String reverseStr = "";

		for (int i = 0; i < length; i++) {

			if (tokens[i].equals(""))
				continue;
			stack.push(tokens[i]);
		}

		while (!stack.isEmpty()) {

			String temp = stack.pop();
			if (reverseStr == "") {
				reverseStr = reverseStr.concat(temp);
			} else {
				reverseStr = reverseStr.concat(" ");
				reverseStr = reverseStr.concat(temp);
			}
		}

		return reverseStr;
	}

}
