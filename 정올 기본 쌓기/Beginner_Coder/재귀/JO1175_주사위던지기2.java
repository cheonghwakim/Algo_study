package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1175_주사위던지기2 {
	static int N, M, result[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[N];
		// 중복 순열
		permRedu(sb, 0);
		
		System.out.println(sb);
	}

	private static void permRedu(StringBuilder sb, int cnt) {
		if(cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += result[i];
			}
			
			if(sum == M) {
				for (int i = 0; i < N; i++) {
					sb.append(result[i]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			result[cnt] = i;
			permRedu(sb, cnt + 1);
		}
	}

}
