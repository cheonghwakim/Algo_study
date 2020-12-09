package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1707_달팽이사각형 {
	static int n, map[][], dirs[][] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		int x = 0, y = -1, dir = 0;
		int num = 1;
		while(true) {
			if(num > n * n)
				break;

			x += dirs[dir % 4][0];
			y += dirs[dir % 4][1];
		
			if(x < 0 || y < 0 || x >= n || y >= n || map[x][y] != 0) {
				x -= dirs[dir % 4][0];
				y -= dirs[dir % 4][1];
				dir++;
				
			} else 
				map[x][y] = num++;
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
