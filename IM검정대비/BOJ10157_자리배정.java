package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10157 자리배정 https://www.acmicpc.net/problem/10157
public class BOJ10157_자리배정 {
	static int R, C, K, cnt;
	static int[][] map, dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		K = Integer.parseInt(br.readLine());
		if(K > C*R) {
			System.out.println(0);
			return;
		}
		// 문제에서는 맨 아래부터 위로 갈 수록 좌표값이 커짐
		// 아래 -> 오른쪽 -> 위 -> 왼쪽 순으로  (그 좌표값은 +1, +1)
		int dir = 0;
		int x = 0, y = 0;
		map[0][0] = 1;
		cnt = 1;
		while(true) {
			if(cnt == K) {
				System.out.println((y + 1) + " " + (x + 1));
				break;
			}
			map[x][y] = cnt++;
			int nx = x + dirs[dir][0];
			int ny = y + dirs[dir][1];
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != 0) {
				dir++;
				dir = dir%4;
				nx = x + dirs[dir][0];
				ny = y + dirs[dir][1];
			}	
			x = nx;
			y = ny;	
		}
	}

}
