package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1671_색종이 {
	static int N, dirs[][] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static boolean[][] attached = new boolean[100][100];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken()); 
			int h = Integer.parseInt(st.nextToken()); 
		
			for (int j = h; j < h + 10; j++) {
				for (int k = w; k < w + 10; k++) {
					attached[k][j] = true;
				}
			}
		}
		
		int line = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(attached[i][j]) {
					
					for (int d = 0; d < dirs.length; d++) {
						int nx = i + dirs[d][0];
						int ny = j + dirs[d][1];
						
						if(nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || !attached[nx][ny])
							line++;
					}
				}
			}
		}
		System.out.println(line);
	}
}
