package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1329_별삼각형3 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		if(N < 0 || N % 2 == 0 || N > 100) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		for (int i = 0; i <= N / 2; i++) {
			for (int j = 0; j <= i*3; j++) {
				if(j < i)
					sb.append(" ");
				else
					sb.append("*");
			}
			sb.append("\n");
		}
		
		for (int i = N / 2 + 1; i < N; i++) {
			for (int j = 0; j <= (N - i - 1) * 3; j++) {
				if(j < N - i - 1)
					sb.append(" ");
				else
					sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
