package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2578 빙고 https://www.acmicpc.net/problem/2578
public class BOJ2578_빙고 {
	static int[][] space;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		space = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				set(Integer.parseInt(st.nextToken()));
				cnt++;
				
				if(bingo()) {
					System.out.println(cnt);
					return;
				}
			}
			
		}
	}
	
	private static void set(int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(space[i][j] == n)
					space[i][j] = 0;
			}
		}
	}
	private static boolean bingo() {
		int result = 0;
		
		// 가로 방향으로 탐색
		for (int i = 0; i < 5; i++) {
			int tmp = 0;
			for (int j = 0; j < 5; j++) {
				if(space[i][j] != 0)
					break;
				else if(space[i][j] == 0)
					tmp++;
			}
			if(tmp == 5) result++;
		}
		
		// 세로 방향으로 탐색
		for (int i = 0; i < 5; i++) {
			int tmp = 0;
			for (int j = 0; j < 5; j++) {
				if(space[j][i] != 0)
					break;
				else if(space[j][i] == 0)
					tmp++;
			}
			if(tmp == 5) result++;
		}
		
		// 대각선 (/)
		int tmp = 0;
		for (int j = 0; j < 5; j++) {
			if(space[j][j] == 0)
				tmp++;
		}
		if(tmp == 5) result++;
		
		// 대각선 (\)
		tmp = 0;
		for (int j = 0; j < 5; j++) {
			if(space[0 + j][4 - j] == 0)
				tmp++;
		}
		if(tmp == 5) result++;

		if(result >= 3) return true;
		return false;
	}

}
