package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1490_다음조합 {
	static int N, K, arr[], result[];
	static boolean flag, exist;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[K];
		comb(0, 1);
		
		if(!exist)
			System.out.println("NONE");
		else
			System.out.println(sb);
	}

	private static void comb(int cnt, int cur) {
		if(cnt == K) {
			
			if(flag) {
				exist = true;
				for (int i = 0; i < K; i++) {
					sb.append(result[i]).append(" ");
				}
				sb.append("\n");
				flag = false;
			}
			
			for (int i = 0; i < K; i++) {
				if(result[i] != arr[i])
					return;
			}
			
			flag = true;
			return;
		}
		
		for (int i = cur; i <= N; i++) {
			result[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
}
