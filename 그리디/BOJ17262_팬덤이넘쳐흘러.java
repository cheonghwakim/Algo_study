package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17262_팬덤이넘쳐흘러 {
	static int N, startMax, endMin = Integer.MAX_VALUE, answer;
	static boolean[] time = new boolean[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			startMax = Math.max(startMax, start);
			endMin = Math.min(endMin, end);
		}
		
		answer = Math.max(startMax - endMin, answer);

		System.out.println(answer);
	}
}