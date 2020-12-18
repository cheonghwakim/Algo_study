package jungol.Beginner_Coder.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1740_소수 {
	static int M, N, answer, min;
	static boolean[] isComposit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		isComposit = new boolean[N + 1];
		isComposit[0] = true;
		
		for (int i = 2; i <= N; i++) {
			if(isComposit[i]) continue;
			
			for (int j = i * 2; j <= N; j += i) {
				isComposit[j] = true;
			}
		}
		
		
		for (int i = M; i <= N; i++) {
			if(!isComposit[i] && i != 1) {
				if(min == 0)
					min = i;

				answer += i;
			}
		}
		
		if(min == 0) System.out.println(-1);
		else {
			sb.append(answer).append("\n").append(min).append("\n");
			System.out.println(sb);
		}
	}

}
