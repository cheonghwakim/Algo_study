package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1026_보물 {
	static int N, a[], b[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		a = new int[N];
		b = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += a[i] * b[N - i - 1];
		}
		System.out.println(sum);
	}
}