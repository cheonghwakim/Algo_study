package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1463 1로 만들기 https://www.acmicpc.net/problem/1463
public class BOJ1463_1로만들기 {
	static int n;
	static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		memo = new int[n + 1];
		System.out.println(dp(n));
	}
	
	static int dp(int n) {
		if(n == 1) return memo[1] = 0;
		if(n == 2) return memo[2] = 1;
		if(n == 3) return memo[3] = 1;
		if(memo[n] != 0) return memo[n];
		
		memo[n] = dp(n - 1) + 1;
		if(n % 3 == 0) {
			int tmp = dp(n / 3) + 1;
			if(memo[n] > tmp) memo[n] = tmp;
		} 
		if(n % 2 == 0) {
			int tmp = dp(n / 2) + 1;
			if(memo[n] > tmp) memo[n] = tmp;
		} 

		return memo[n];
	}
}
