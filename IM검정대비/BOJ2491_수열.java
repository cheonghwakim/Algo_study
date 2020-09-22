package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2491 수열 https://www.acmicpc.net/problem/2491
public class BOJ2491_수열 {
	static int N, result;
	static int high = 1, low = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N == 1) result = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Old = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int New = Integer.parseInt(st.nextToken());

			if(Old > New) {
				low++;
				if(result < low) result = low;
				high = 1;
				
			} else if(Old < New) {
				high++;
				if(result < high) result = high;
				low = 1;
				
			} else {
				low++;
				high++;
				if(result < low) result = low;
				if(result < high) result = high;
			}
			Old = New;
		}
		System.out.println(result);
	}

}
