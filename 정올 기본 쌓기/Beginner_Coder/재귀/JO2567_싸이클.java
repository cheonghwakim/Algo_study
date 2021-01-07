package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2567_싸이클 {
	static int N, P, cnt, visited[];
//	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		visited = new int[N * N];
		
		visited[N] = 1;
		recur(N);
		System.out.println(cnt);
	}

	private static void recur(int n) {
		
		int next = n * N % P;

		if(visited[next] >= 2) return;
		
		if(visited[next] == 1)
			cnt++;
		
		visited[next]++;
		recur(next);
	}
}