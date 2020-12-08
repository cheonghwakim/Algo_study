package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1337_달팽이삼각형 {
	static int n, x, y, map[][], dirs[][] = { {1, 1}, {0, -1}, {-1, 0} };
	static boolean[][] checked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		map = new int[n][n];
		checked = new boolean[n][n];
		int end = 0;
		for (int i = 1; i <= n; i++) {
			end += i;
		}
		int num = 0, dir = 0, cnt = 0;
		while(true) {
			
			if(cnt == end) break;
			
			if(num == 10) num = 0;
			if(x < 0 || y < 0 || x >= n || y >= n || checked[x][y]) {
				x -= dirs[dir % 3][0];
				y -= dirs[dir % 3][1];
				dir++;
			} else {
				map[x][y] = num++;
				checked[x][y] = true;
				cnt++;
			}
			
			x += dirs[dir % 3][0];
			y += dirs[dir % 3][1];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	
}
