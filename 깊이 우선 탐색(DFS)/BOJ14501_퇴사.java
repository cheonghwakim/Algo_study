package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 14501 퇴사 https://www.acmicpc.net/problem/14501
public class BOJ14501_퇴사 {
	static int N, max;
	static ArrayList<Integer> jisok = new ArrayList<>();
	static ArrayList<Integer> cost = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			jisok.add(Integer.parseInt(st.nextToken()));
			cost.add(Integer.parseInt(st.nextToken()));
		}
		dfs(0, 0);	
		System.out.println(max);
	}
	
	static void dfs(int day, int sum) {
		if(day >= N) {
			if(day == N)
				max = Math.max(max, sum);
			return;
		}

//		if(day + jisok.get(day) <= N)
		dfs(day + jisok.get(day), sum + cost.get(day)); // 그 날에 상담을 하는 경우
		dfs(day + 1, sum); // 그 날 상담을 하지 않고 넘어가는 경우
	}

}
