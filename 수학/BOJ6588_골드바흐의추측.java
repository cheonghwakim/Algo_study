package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ6588_골드바흐의추측 {
	static int n, N = 1000000;
	static boolean[] prime = new boolean[N + 1];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder string = new StringBuilder();
		
		
		for (int i = 2; i < prime.length; i++) { // 초기화
			prime[i] = true;
		}
		
		// 2부터 숫자를 키워가며 배수들 제외(false할당)
		for (int i = 2; i*i <= N; i++) {
			if(!prime[i]) continue;
			
			for (int j = i*i; j <= N; j += i)
				prime[j] = false;
		}
			
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			boolean flag = false;
			// 이중 for문으로 비교하면 시간초과!
			for (int i = 3; i <= n/2; i++) {
				if(prime[i] && prime[n - i]) {
					string.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
					flag = true;
					break;
				}	
				else continue;
			}
			
			if(!flag)
				string.append("Goldbach's conjecture is wrong.\n");
		}
		System.out.println(string);
	}

}
