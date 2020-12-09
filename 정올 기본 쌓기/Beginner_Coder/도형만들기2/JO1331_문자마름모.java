package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1331_문자마름모 {
	static int n, dirs[][] = { {1, -1}, {1, 1}, {-1, 1}, {-1, -1} };
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[2*n - 1][2*n - 1];
		
		char ch = 'A';
		map[0][n - 1] = ch++;
		int x = 0, y = n - 1;
		int end = n - 1;
		while(true) {
			
			if(end == 0) break;
			
			for (int i = 0; i < 4; i++) {
				if(i == 3) end--;
				for (int j = 0; j < end; j++) {
					if(ch > 90) ch = 65;
					
					x += dirs[i][0];
					y += dirs[i][1];
					map[x][y] = ch++;
				}
				
			}
			if(ch > 90) ch = 65;
			map[x][--y] = ch++;
		}
		
		for (int i = 0; i < 2*n - 1; i++) {
			for (int j = 0; j < 2*n - 1; j++) {
				if(map[i][j] == 0) sb.append("  ");
				else sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
