package jungol.Intermediate_Coder.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class JO1141_불쾌한날 {
	static int N, num;
	static long answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N + 1; i++) {
			
			if(i == N)
				num = Integer.MAX_VALUE;
			else
				num = Integer.parseInt(br.readLine());
			
			if(!stack.isEmpty()) {
				while (!stack.isEmpty() && stack.peek() <= num) {
					stack.pop();
					answer += stack.size();
				}
			}
			stack.push(num);
		}
		
		System.out.println(answer);
	}
}