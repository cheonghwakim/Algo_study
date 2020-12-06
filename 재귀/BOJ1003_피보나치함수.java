package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003_피보나치함수 {
	static int T, memo[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		memo = new int[41][2]; // [][0: 0의 개수, 1: 1의 개수]
		memo[0][0] = 1;
		memo[0][1] = 0;
		memo[1][0] = 0;
		memo[1][1] = 1;
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			fibonacci(n);
		
			sb.append(memo[n][0]).append(" ").append(memo[n][1]).append(" ").append("\n");
		}
		System.out.println(sb);
		
	}
	
	static int[] fibonacci(int n) {
		if(n == 0) {
			return memo[n];
		} else if (n == 1) {
			return memo[n];
		} else {
			if(memo[n][0] != 0 || memo[n][1] != 0) return memo[n];
			
			memo[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			memo[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
			return memo[n];
		}
	}

}
