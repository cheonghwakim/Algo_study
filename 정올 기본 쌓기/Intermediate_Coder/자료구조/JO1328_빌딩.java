package jungol.Intermediate_Coder.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class JO1328_빌딩 {
	static int N, answer[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<int[]> stack = new Stack<>();
		answer = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && stack.peek()[1] < num) {
				answer[stack.pop()[0]] = i + 1;				
			}
			stack.add(new int[] {i, num});
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}
}