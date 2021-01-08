package jungol.Intermediate_Coder.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO1809_탑 {
	static int N, answer[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		answer = new int[N];
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek()[1] < num) {
				stack.pop();
			}
			
			if(!stack.isEmpty() && stack.peek()[1] > num) 
				answer[i] = stack.peek()[0] + 1;
			
			stack.push(new int[] {i, num});
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}