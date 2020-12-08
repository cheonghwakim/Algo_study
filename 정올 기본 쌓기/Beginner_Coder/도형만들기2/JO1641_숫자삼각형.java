package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1641_숫자삼각형 {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(n < 0 || n > 100 || n % 2 == 0 || m < 0 || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		if(m == 1) {
			int dir = 0, num = 0;
			for (int i = 0; i < n; i++) {
				if(i % 2 == 0) dir = 0;
				else dir = 1;
				
				for (int j = 0; j <= i; j++) {
					if(dir == 0) sb.append(++num).append(" ");
					else sb.append(++num + i - j*2).append(" ");
				}
				sb.append("\n");
			}
		} else if(m == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < (n - i)*2 - 1 + i; j++) {
					if(j < i) sb.append(" ").append(" ");
					else sb.append(i).append(" ");
				}
				sb.append("\n");
			}
		} else {
			int end = 0;
			for (int i = 0; i < n; i++) {
				if(i <= n / 2) end = i;
				else end = n - i - 1;
				
				for (int j = 0; j <= n / 2; j++) {
					sb.append(j + 1).append(" ");
					if(j == end) break;
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
