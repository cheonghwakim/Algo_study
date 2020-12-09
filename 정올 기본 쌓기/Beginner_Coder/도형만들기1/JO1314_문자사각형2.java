package jungol.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1314_문자사각형2 {
	static int n;
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		char ch = 65;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(ch > 90) ch = 65;
				if(i % 2 == 0)
					map[j][i] = ch++;
				else
					map[n - j - 1][i] = ch++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
