package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2133 타일 채우기 https://www.acmicpc.net/problem/2133
public class BOJ2133_타일채우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		if(n > 1 && n % 2 == 0) {
			dp[0] = 1; dp[2] = 3;
			
			for(int i = 4; i < n+1; i+=2) {
				dp[i] = dp[2]*dp[i-2];
				for(int j = 4; j <= i; j+=2)
					dp[i] += 2*dp[i-j];
			}
		}
		System.out.println(dp[n]);
	}
}
