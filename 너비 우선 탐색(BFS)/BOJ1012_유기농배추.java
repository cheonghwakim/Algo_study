package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ1012 유기농배추 https://www.acmicpc.net/problem/1012
public class BOJ1012_유기농배추 {
	static int T, M, N, K;
	static int map[][], dirs[][] = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
	static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			Queue<int[]> q = new LinkedList<int[]>();
			
			map = new int[M][N];
			visited = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						q.offer(new int[] {i, j});
						while(!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.poll()[1];
			
							for (int d = 0; d < 4; d++) {
								int nx = x + dirs[d][0];
								int ny = y + dirs[d][1];
								
								if(nx < 0 || ny < 0 || nx >= M || ny >= N)
									continue;
								
								if(map[nx][ny] == 1 && !visited[nx][ny]) {
									visited[nx][ny] = true;
									q.offer(new int[] {nx, ny});
								}
							}
						}
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

}
