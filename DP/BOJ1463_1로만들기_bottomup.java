package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1463 1로 만들기 https://www.acmicpc.net/problem/1463
// top-down 방식으로 하면 stack overflow남 (왜 통과된지는 모르겠음)
public class BOJ1463_1로만들기_bottomup {
	static int n;
	static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		memo = new int[n + 1];
		memo[1] = 0;
		for (int i = 2; i <= n; i++) { 
			memo[i] = memo[i - 1] + 1; 
			if(i % 2 ==0) memo[i] = Math.min(memo[i], memo[i / 2] + 1); // memo[2] = 1;
			if(i % 3 ==0) memo[i] = Math.min(memo[i], memo[i / 3] + 1); // memo[3] = 1;
		}
		System.out.println(memo[n]);
	}
}
