package jungol.Beginner_Coder.자료처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class JO2858_쇠막대기 {
	static int stick, answer;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int i = 0;
		while(i < input.length()) {
			if(input.charAt(i) == '(' && input.charAt(i + 1) != ')') {
				stack.push('(');
				stick++;
			} else if(input.charAt(i) == '(' && input.charAt(i + 1) == ')') {// 레이저
				answer += stick;
				i++;
			}
			else if(input.charAt(i) == ')') {
				stack.pop();
				answer += 1;
				stick--;
			}
			i++;
		}
		
		System.out.println(answer);
	}
}