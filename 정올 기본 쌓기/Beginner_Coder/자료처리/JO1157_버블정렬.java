package jungol.Beginner_Coder.자료처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1157_버블정렬 {
	static int N, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int j = 0; j < N - 1; j++) {
			for (int i = 1; i < N - j; i++) {
				if(arr[i - 1] > arr[i]) {
					int tmp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = tmp;
				}
			}
			
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
