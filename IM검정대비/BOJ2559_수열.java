package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 2559 수열 https://www.acmicpc.net/problem/2559
public class BOJ2559_수열 {
	static int N, K, max = - Integer.MAX_VALUE;
	static int[] temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += temp[i];
		}
		max = sum;
		
		for (int i = 0; i < N - K; i++) {
			sum -= temp[i];
			sum += temp[i + K];			
			if(max < sum)
				max = sum;
		}

		System.out.println(max);
	}
}
