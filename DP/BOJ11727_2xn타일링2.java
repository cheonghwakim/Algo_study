package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 11727 2xn 타일링 2 https://www.acmicpc.net/problem/11727
public class BOJ11727_2xn타일링2 {
	static int n;
	static int[] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		memo = new int[n + 1];
		System.out.println(f(n));
	
	}
	
	static int f(int n) {
		if(n == 1) return memo[1] = 1;
		if(n == 2) return memo[2] = 3;
		
		if(n >= 3 && memo[n] == 0) {
			memo[n] = (f(n - 1) + 2*f(n - 2)) % 10007;
		}
		return memo[n];
	}
}
