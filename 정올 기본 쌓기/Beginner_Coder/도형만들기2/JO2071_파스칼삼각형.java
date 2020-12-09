package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2071_파스칼삼각형 {
	static int n, m;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		if(m == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if(j == 0 || j == i) {
						map[i][j] = 1;
						sb.append(1).append(" ");
					} else {
						map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
						sb.append(map[i][j]).append(" ");
					}
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
		} else if (m == 2) {

			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j <= n - i - 1; j++) {
					if(j == 0 || j == n - i - 1) {
						map[i][j] = 1;
					} else {
						map[i][j] = map[i + 1][j - 1] + map[i + 1][j];
					}
				}
			}
			
			for (int i = 0; i < n; i++) {					
				for (int j2 = 0; j2 < i; j2++) {
					sb.append(" ");
				}
				for (int j = 0; j < n; j++) {
					if(map[i][j] == 0) sb.append("  ");
					else
						sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
		} else {
			
			for (int i = n - 1; i >= 0; i--) {
				for (int j = n - 1; j >= i; j--) {
					if(j == n - 1 || j == i) {
						map[j][i] = 1;	
					} else
						map[j][i] = map[j + 1][i + 1] + map[j][i + 1];
				}
			}
			
			for (int i = 0; i < n; i++) {					
				for (int j = 0; j < n; j++) {
					if(map[i][j] == 0) sb.append("  ");
					else
						sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
		
	}

}
