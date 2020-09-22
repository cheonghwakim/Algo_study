package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1495 기타리스트 https://www.acmicpc.net/problem/1495
public class BOJ1495_기타리스트DP {
	static int N, S, M;
	static boolean flag = false;
	static int[] volume;
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		volume = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			volume[i + 1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new boolean[N + 1][M + 1];
		dp[0][S] = true;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if(!dp[i - 1][j])
					continue;
				
				if(j + volume[i] <= M) {
					dp[i][j + volume[i]] = true;
				}
				if(j - volume[i] >= 0)
					dp[i][j - volume[i]] = true;
			}
		}
		
		for (int i = M; i >= 0; i--) {
			if(dp[N][i]) {
				flag = true;
				System.out.println(i);
				break;
			}
		}
		
		if(!flag)
			System.out.println(-1);
		
	}

}
