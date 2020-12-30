package jungol.Beginner_Coder.자료처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1146_선택정렬 {
	static int N, arr[], min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(min > arr[i]) min = arr[i];
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N; j++) {
				if(arr[j] == min) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			
			min = Integer.MAX_VALUE;
			for (int j = i + 1; j < N; j++) {
				if(min > arr[j]) 
					min = arr[j];
			}
			
			for (int j = 0; j < N; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
