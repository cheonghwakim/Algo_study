package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// **
public class JO1021_장난감조립 {
	static int N, M, needs[][], part[];
	static boolean[] isBasic;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 1 ~ N - 1: 기본부품, 중간부품, N: 완제품
		M = Integer.parseInt(br.readLine()); // 관계 개수
		StringBuilder sb = new StringBuilder();
		
		isBasic = new boolean[N + 1];
		part = new int[N + 1];
		needs = new int[N + 1][N + 1]; // [제품번호][0] : 필요부품, [제품번호][1] : 필요 개수
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int no = Integer.parseInt(st.nextToken());
			needs[no][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			isBasic[no] = true;
		}
		
		make(N);
		
		for (int i = 1; i < N; ++i) {
			if(!isBasic[i])
				sb.append(i).append(" ").append(part[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void make(int n) {
		if(!isBasic[n])
			part[n]++;
		
		else {
			for (int i = 1; i <= N; ++i) {
				if(needs[n][i] != 0) {
					for (int j = 1; j <= needs[n][i]; ++j) {
						make(i);
					}
				}
			}
		}
	}
}