package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651_N과M3 {
	static int N, M, result[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		perm(0);
		
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + 1).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			result[cnt] = i;
			perm(cnt + 1);
		}
	}
}