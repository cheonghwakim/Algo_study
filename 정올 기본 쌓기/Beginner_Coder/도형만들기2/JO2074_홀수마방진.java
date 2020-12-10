package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO2074_홀수마방진 {
	static int n, map[][], dirs[][] = { {-1, -1}, {1, 0} };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		int x = 0, y = n / 2, num = 1, dir = 0;
		
		while(true) {
			
			if(num > n*n) break;
				
			map[x][y] = num++;
			
			if((num - 1) % n == 0)
				dir = 1;
			else 
				dir = 0;
			
			x += dirs[dir][0];
			y += dirs[dir][1];
			
			if(x < 0) 
				x = n - 1;
			else if(y < 0)
				y = n - 1;
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
