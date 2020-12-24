package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874_스택수열 {
	static int n, nums[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int num = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(num++);
		sb.append("+").append("\n");
		
		int idx = 0;
		while(idx < n) {
			
			if(stack.isEmpty() || nums[idx] >= stack.peek()) {
				while(num <= nums[idx]) {
					stack.push(num++);
					sb.append("+").append("\n");
				}
				stack.pop();
				sb.append("-").append("\n");
			
			} else {
				System.out.println("NO");
				return;
			}
			idx++;
		}
		System.out.println(sb);
	}

}
