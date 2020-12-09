package jungol.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1856_숫자사각형2 {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= m; j++) {
				if(i % 2 == 0)
					sb.append(num++).append(" ");
				else
					sb.append(num++ + m - 2*j + 1).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
