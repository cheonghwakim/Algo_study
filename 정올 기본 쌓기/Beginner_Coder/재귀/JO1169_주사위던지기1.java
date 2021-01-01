package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1169_주사위던지기1 {
	static int N, M, result[];
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[N];
		isSelected = new boolean[7];
		
		if(M == 1)
			permRedu(sb, 0); // 중복순열
		else if(M == 2)
			combRedu(sb, 0, 1); // 증복조합 (순서X result에서 중복 가능)
		else
			perm(sb, 0); // 순열
	
		System.out.println(sb);
	}

	private static void permRedu(StringBuilder sb, int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			result[cnt] = i;
			permRedu(sb, cnt + 1);
		}
	}
	
	private static void combRedu(StringBuilder sb, int cnt, int cur) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = cur; i <= 6; i++) {
			result[cnt] = i;
			combRedu(sb, cnt + 1, i);
		}
	}

	private static void perm(StringBuilder sb, int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			result[cnt] = i;
			perm(sb, cnt + 1);
			isSelected[i] = false;
		}
	}
}