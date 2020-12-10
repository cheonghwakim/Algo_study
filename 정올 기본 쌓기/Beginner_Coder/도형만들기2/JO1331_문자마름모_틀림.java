package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1331_문자마름모_틀림 {
	static int n, dirs[][] = { {1, -1}, {1, 1}, {-1, 1}, {-1, -1}, {0, -1} };
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[2*n - 1][2*n - 1];
		
		char ch = 'A';
		int x = -1, y = n, dir = 0, cnt = 0;
		
		while(true) {
			
			if(cnt > n*n) break;
			
			if(ch > 90) ch = 65;
			
			x += dirs[dir % 5][0];
			y += dirs[dir % 5][1];
			
			if(x < 0 || y < 0 || x >= 2*n - 1 || y >= 2*n - 1 || map[x][y] != 0) {
				x -= dirs[dir % 5][0];
				y -= dirs[dir % 5][1];
				dir++;
			} else {
				map[x][y] = ch++;
				cnt++;
			}
				
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
