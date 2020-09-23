package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 17070 파이프 옮기기 1 https://www.acmicpc.net/problem/17070
public class BOJ17070_파이프옮기기1 {
	static int N, cnt;
	static int[][] map, dirs = { {0, 1}, {1, 0}, {1, 1} }; // 오른쪽, 아래, 오른쪽 아래 대각선 방향
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[0][0] = 2; 
		map[0][1] = 2;
		
		dfs(0, 1, 0);
		System.out.println(cnt);
	}
	
	// dir: 0 가로, 1 세로, 2 대각선
	static void dfs(int i, int j, int dir) {
		if(i == N - 1 && j == N - 1) {
			cnt++;
			return;
		}

		if(dir == 0) { // 가로방향이면
			if(j + 1 < N && map[i][j + 1] == 0)
				dfs(i, j + 1, 0);
		
		} else if(dir == 1) { // 세로 방향이면
			if(i + 1 < N && map[i + 1][j] == 0)
				dfs(i + 1, j, 1);
		
		} else { // 대각선 방향이면 
			if(j + 1 < N && map[i][j + 1] == 0)
				dfs(i, j + 1, 0);
			if(i + 1 < N && map[i + 1][j] == 0)
				dfs(i + 1, j, 1);
		}
		
		if(i + 1 < N && j + 1 < N && map[i + 1][j + 1] == 0 && map[i + 1][j] == 0 && map[i][j + 1] == 0)
			dfs(i + 1, j + 1, 2);

	}

}
