package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929_소수구하기 {
	static int M, N;
	static boolean[] prime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder string = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		prime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) { // 초기화
			prime[i] = true;
		}
		
		for (int i = 2; i*i <= N; i++) { 
			if(!prime[i]) continue;
			
			for (int j = i*i; j <= N; j += i) {
				prime[j] = false;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(prime[i]) 
				string.append(i).append("\n");
		}
		
		System.out.println(string);
	}
}
