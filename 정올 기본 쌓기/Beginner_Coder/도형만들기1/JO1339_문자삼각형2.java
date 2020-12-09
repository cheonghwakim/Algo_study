package jungol.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1339_문자삼각형2 {
	static int n;
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		map = new char[n][n / 2 + 1];
		if(n < 1 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR");
			return;
		}
		
		char ch = 'A';
		for (int j = n / 2; j >= 0; j--) {
			for (int i = j; i < n - j; i++) {
				if(ch > 90) ch = 'A';
				map[i][j] = ch++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2 + 1; j++) {
				if(map[i][j] == 0) sb.append(" ").append(" ");
				else
					sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
