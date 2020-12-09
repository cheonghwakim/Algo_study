package jungol.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2046_숫자사각형4 {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(m == 1)
					sb.append(i).append(" ");
				
				else if(m == 2) {
					if(i % 2 == 1)
						sb.append(j).append(" ");
					else
						sb.append(n - j + 1).append(" ");
				
				} else {
					sb.append(i*j).append(" ");
				}
				
			}
			sb.append("\n");
		}	
		System.out.println(sb);
	}
}
