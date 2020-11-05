package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026_적록색약 {
	static int N, cntO, cntX, dirs[][] = { {-1, 0} , {1, 0}, {0, -1}, {0, 1} };
	static char[][] map;
	static boolean[][] visited_O, visited_X;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		visited_O = new boolean[N][N];
		visited_X = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] string = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = string[j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited_X[i][j]) { // 적록색약 없는 사람
					visited_X[i][j] = true;
 					dfs(i, j, 0, map[i][j]);	
 					cntX++;
				}
				if(!visited_O[i][j]) { // 적록색약 있는 사람
					visited_O[i][j] = true;
					dfs(i, j , 1, map[i][j]);
					cntO++;
				}
			}
		}
		System.out.println(cntX + " " + cntO);
		
	}

	private static void dfs(int i, int j, int idx, char color) {
		
		for (int d = 0; d < dirs.length; d++) {
			int nx = i + dirs[d][0];
			int ny = j + dirs[d][1];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			
			if(idx == 0 && !visited_X[nx][ny] && map[nx][ny] == color) {
				visited_X[nx][ny] = true;
				dfs(nx, ny, idx, color);
			}
			
			if(idx == 1 && !visited_O[nx][ny]) {
				if(((color == 'R' || color == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) || (color == 'B' && map[nx][ny] == 'B')) {
					visited_O[nx][ny] = true;
					dfs(nx, ny, idx, color);
				}
			}
		}
		return;
	}

}
