package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805_나무자르기 {
	static int N;
	static long M, height[], max, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		height = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Long.parseLong(st.nextToken());
			max = max < height[i] ? height[i] : max;
		}
		
		long start = 1;
		long end = max;
		long middle;
		
		while(start <= end) {
			
			middle = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if(height[i] - middle > 0)
					sum += height[i] - middle;
			}
			
			if(sum < M)
				end = middle - 1;
			else if(sum >= M) {
				start = middle + 1;
				answer = answer < middle ? middle : answer;
			}
			
		}
		
		System.out.println(answer);
	}

}
