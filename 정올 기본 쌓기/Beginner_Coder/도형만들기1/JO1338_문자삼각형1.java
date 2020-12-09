package jungol.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1338_문자삼각형1 {
	static int n, dirs[] = {1, -1};
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		map = new char[n][n];
		
		int end = 0;
		for (int i = 1; i <= n; i++) {
			end += i;
		}
		
		int x = 0, y = n - 1, num = 0, cnt = 0;
		char ch = 'A';
		while(true) {
			if(cnt == end)
				break;
			
			if(ch > 90) ch = 65;
			if(x < 0 || y < 0 || x >= n || y >= n) {
				x = num++;
				y = n;
			}
			else {
				map[x][y] = ch++;
				cnt++;
			}
			
			x++;
			y--;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 0) sb.append(" ").append(" ");
				else 
					sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
