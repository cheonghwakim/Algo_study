package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1997_떡먹는호랑이 {
	static int D, K, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] A1 = new int[D + 1], A2 = new int[D + 1];
		A1[1] = 1;
		A2[2] = 1;
		for (int i = 3; i <= D; i++) {
			A1[i] += A1[i - 1] + A1[i - 2];
			A2[i] += A2[i - 1] + A2[i - 2];
		}
		
		int day1 = 0, day2 = 0;
		
		// 이차 방정식 해 구하기
		for (int i = 1; ; i++) {
			int res = K - A1[D] * i;
			
			if(res % A2[D] == 0) {
				day1 = i;
				day2 = res / A2[D];
				break;
			}
		}
		sb.append(day1).append("\n").append(day2).append("\n");
		System.out.println(sb);
	}
}
