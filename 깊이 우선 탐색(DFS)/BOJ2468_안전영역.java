package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 2468 안전 영역 https://www.acmicpc.net/problem/2468
public class BOJ2468_안전영역 {
	static int N, max, sum;
	static int[][] map, dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j])
					max = map[i][j];
			}
		}
		
		for (int h = max; h >= 0; h--) {
			int cnt = 0;
			boolean[][] visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] > h) {
						dfs(visited, h, i, j);
						cnt++;
					}
				}
			}
			sum = Math.max(sum, cnt);
		}
		System.out.println(sum);
	}
	
	static void dfs(boolean[][] visited, int height, int x, int y) {
		
		visited[x][y] = true;
		
		for (int d = 0; d < dirs.length; d++) {
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];

			if(nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			
			if(!visited[nx][ny]) {
				if(map[nx][ny] > height) {
					visited[nx][ny] = true;
					dfs(visited, height, nx, ny);
				}
			}
		}
		return;
	}
}
