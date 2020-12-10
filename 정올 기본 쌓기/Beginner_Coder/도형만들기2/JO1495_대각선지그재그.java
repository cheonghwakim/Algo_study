package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1495_대각선지그재그 {
	static int n, map[][], dirs[][] = { {1, 0}, {-1, 1}, {0, 1}, {1, -1} };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		int x = 0, y = 0, num = 1, dir = 0;
		map[x][y] = num++;
		while(true) {
			
			if(num > n*n) break;
			
			x += dirs[dir % 4][0];
			y += dirs[dir % 4][1];
			
			
			if(dir % 4 == 0 || dir % 4 == 2) {
				if(x < 0 || y < 0 || x >= n || y >= n) {
					x -= dirs[dir % 4][0];
					y -= dirs[dir % 4][1];
					dirs[0][0] = 0;
					dirs[0][1] = 1;
					dirs[2][0] = 1;
					dirs[2][1] = 0;
					x += dirs[dir% 4][0];
					y += dirs[dir % 4][1];
				}
				map[x][y] = num++;
				dir++;
				continue;
			} else {
				
				if(x < 0 || y < 0 || x >= n || y >= n) {
					x -= dirs[dir % 4][0];
					y -= dirs[dir % 4][1];
					dir++;
				} else
					map[x][y] = num++;
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
