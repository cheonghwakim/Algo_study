package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준2178 미로탐색 https://www.acmicpc.net/problem/2178
public class BOJ2178_미로탐색 {
	static int N, M;
	static int[][] map, dirs = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
	static boolean[][] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String string = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(string.split("")[j]);
			}
		}
		
		visited[0][0] = true;
//		bfs();
		dfs(0, 0, 1);
		
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					map[nx][ny] = map[x][y] + 1;
					q.offer(new int[] {nx, ny});
				}

			}				
		}
		System.out.println(map[N - 1][M - 1]);
	}
	
	static void dfs(int x, int y, int distance) {		
		if(x == N - 1 && y == M - 1) {
			System.out.println(distance);
			return;
		}

		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) // 범위 체크
				continue;	
			
			if(!visited[nx][ny] && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(nx, ny, distance + 1);
			}
		}
		

	}

}
