package jungol.Beginner_Coder.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2813_소수의개수 {
	static int M, N, cnt;
	static boolean[] isComposit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	
		isComposit = new boolean[N + 1];
		
		isComposit[0] = true;
		isComposit[1] = true;
		for (int i = 2; i * i <= N; i++) {
			if(isComposit[i]) continue;
			
			for (int j = 2 * i; j <= N; j += i) {
				isComposit[j] = true;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(!isComposit[i]) cnt++;
		}
		
		
		System.out.println(cnt);
	}

}
