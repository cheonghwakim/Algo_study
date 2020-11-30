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
		
		int value;
		for (int i = 0; i < gwalhoes.length; i++) {
		value = 0;
			if(gwalhoes[i] == '(' || gwalhoes[i] == '[')
				stack.push(Character.toString(gwalhoes[i]));
			
			else if (gwalhoes[i] == ')') {
				if(stack.peek().equals("(")) {
					stack.pop();
					stack.push("2");
				}else {
					// 안에 만약 숫자가 있다면 계속 더해
					// 숫자 없으면 걍 2나 3 넣고
					while(!stack.isEmpty()) {
						String tmp = stack.pop();
						
						if(tmp.equals("[") || tmp.equals(")") || tmp.equals("]")) {
							System.out.println(0);
							return;
						} else if(tmp.equals("(")) {
							stack.push(String.valueOf(value*2));
							break;
						}
						value += Integer.parseInt(tmp);	
					}
					if(stack.isEmpty()) {
						System.out.println(0);
						return;
					}
				}
			} else if (gwalhoes[i] == ']') {
				if(stack.peek().equals("[")) {
					stack.pop();
					stack.push("3");
				}else {
					// 안에 만약 숫자가 있다면 계속 더해
					// 숫자 없으면 걍 2나 3 넣고
					while(!stack.isEmpty()) {
						String tmp = stack.pop();
						
						if(tmp.equals("(") || tmp.equals(")") || tmp.equals("]")) {
							System.out.println(0);
							return;
						} else if(tmp.equals("[")) {
							stack.push(String.valueOf(value*3));
							break;
						}
						value += Integer.parseInt(tmp);	
					}
					if(stack.isEmpty()) {
						System.out.println(0);
						return;
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			String pop = stack.pop();
			
			if(pop.equals("(") || pop.equals("[") || pop.equals(")") || pop.equals("]")){
				System.out.println(0);
				return;
			}
			answer += Integer.parseInt(pop);
		}

		System.out.println(answer);
	}

}
