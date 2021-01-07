package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2817_로또 {
	static int K, arr[], result[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		arr = new int[K];
		result = new int[6];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		System.out.println(sb);
	}

	private static void comb(int cnt, int cur) {
		if(cnt == 6) {
			
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = cur; i < arr.length; i++) {
			result[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
}