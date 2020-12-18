package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2303_숫자게임 {
	static int N, max, answer, num[] = new int[5], result[] = new int[3];
	static boolean[] visited = new boolean[5];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0, i);
			
		}
		
		System.out.println(answer);
		
	}

	private static void comb(int cnt, int cur, int idx) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += num[result[i]];
			}
			
			if(max <= sum % 10) {
				max = sum % 10;
				answer = idx + 1;
			}
			
			return;
		}
		
		for (int i = cur; i < 5; i++) {
			result[cnt] = i;
			comb(cnt + 1, i + 1, idx);
		}
	}
}
