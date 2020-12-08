package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1523_별삼각형1 {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(n < 0 || n > 100 || m < 0 || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		if(m == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
		} else if(m == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			
		} else {
			for (int i = 1; i <= n; i++) { // n * 2 - 1이 제일 큰 수
				for (int j = 0; j < n + i - 1; j++) { // 개수는  i*2 + 1ro
					if(j < n - i)
						sb.append(" ");
					else
						sb.append("*");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
