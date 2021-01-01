package jungol.Beginner_Coder.자료처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO1221_후위표기법1 {
	static int M;
	static Stack<Integer> stack = new Stack<>(); 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			String input = st.nextToken();
			
			int num1, num2;
			switch(input) {
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					num2 = stack.pop();
					num1 = stack.pop();
					stack.push(num1 - num2);
					break;
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					num2 = stack.pop();
					num1 = stack.pop();
					stack.push(num1 / num2);
					break;
				default:
					stack.push(Integer.parseInt(input));
			}
		}
		System.out.println(stack.pop());
	}
}