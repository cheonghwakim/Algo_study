package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504_괄호의값 {
	static Stack<String> stack = new Stack<>();
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] gwalhoes = br.readLine().toCharArray();
		
		int value = 0;
		for (int i = 0; i < gwalhoes.length; i++) {

			if(gwalhoes[i] == '(' || gwalhoes[i] == '[')
				stack.push(Character.toString(gwalhoes[i]));
			
			else if (gwalhoes[i] == ')') {
//				stack.pop();
//				stack.push("2");
				
				// 안에 만약 숫자가 있다면 숫자는 하나밖에 없을거야 그럼 *하면 됨
				// 숫자 없으면 걍 2나 3 넣고
				while(true) {
					String tmp = stack.pop();
					
					if(tmp.equals("[")) {
						System.out.println(0);
						return;
					} else if(tmp.equals("(")) {
						stack.push("2");
					} else {
						value = Integer.parseInt(tmp)*2;
						if(stack.pop().equals("("))
							stack.push(String.valueOf(value));
						else {
							System.out.println(0);
							return;
						}	
					}
				}
			} else if (gwalhoes[i] == ']') {
				while(true) {
					String tmp = stack.pop();
					
					if(tmp.equals("(")) {
						System.out.println(0);
						return;
					} else if(tmp.equals("[")) {
						stack.push("3");
					} else {
						value = Integer.parseInt(tmp)*3;
						if(stack.pop().equals("["))
							stack.push(String.valueOf(value));
						else {
							System.out.println(0);
							return;
						}		
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			answer += Integer.parseInt(stack.pop());
		}

		System.out.println(answer);
	}

}
