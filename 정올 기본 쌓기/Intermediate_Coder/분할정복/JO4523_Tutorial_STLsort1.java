package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO4523_Tutorial_STLsort1 {
	static int N, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		Arrays.sort(arr, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) + 1);
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.append("\n");
		
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}