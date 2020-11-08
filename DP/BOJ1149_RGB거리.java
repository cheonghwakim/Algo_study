package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_RGB거리 {
	static int N;
	static int[] R, G, B, D[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = new int[N + 1];
		G = new int[N + 1];
		B = new int[N + 1];
		
		D = new int[N + 1][3];
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 1; i <= N; i++) {
			D[i][0] = Math.min(D[i - 1][1], D[i - 1][2]) + R[i];
			D[i][1] = Math.min(D[i - 1][0], D[i - 1][2]) + B[i];
			D[i][2] = Math.min(D[i - 1][0], D[i - 1][1]) + G[i];
		}
		
		int min = 1000*N;
		for (int i = 0; i < 3; i++) {
			if(min > D[N][i]) min = D[N][i];
		}
		
		System.out.println(min);
	}

}
