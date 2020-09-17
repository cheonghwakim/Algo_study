package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 시간 초과
// 백준 1495 기타리스트 https://www.acmicpc.net/problem/1495
public class BOJ1495_기타리스트 {
	static int N, S, M, max = 0;
	static int[] volume;
	static boolean flag = false;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		volume = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}
		
		max = volume[N - 1];
		for (int i = 1; i <= N; i++) {
			comb(S, 0, 0, i);
		}
		
		if(flag)
			System.out.println(-1);
		else
			System.out.println(max);
	}
	
	static void comb(int p, int cur, int cnt, int r) {
		if(p < 0 || p > M) {
			flag = true;
			return;
		}
		if(cnt == r) {
			max = Math.max(max, p);
			return;
		}
		
		if(p + volume[cur] <= M) 
			comb(p + volume[cur], cur + 1, cnt + 1, r);

		
		if(p - volume[cur] >= 0)
			comb(p - volume[cur], cur + 1, cnt + 1, r);
		
		comb(p, cur + 1, cnt + 1, r);
	}

}
