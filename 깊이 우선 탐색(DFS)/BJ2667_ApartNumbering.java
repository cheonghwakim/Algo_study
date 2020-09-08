package com.ssafy.bj;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2667_ApartNumbering {
	static int N;
	static int[][] space;
	static boolean[][] visited;
	static int[] aparts = new int[25*25];
	static int ApartNum;
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		space = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
            String input = sc.next();
			for (int j = 0; j < N; j++) {
				space[i][j] = input.charAt(j) - '0';
			}
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if(!visited[x][y] && space[x][y] == 1) {
					ApartNum++;
					dfs(x, y);
				}
			}
		}

		Arrays.sort(aparts);
		System.out.println(ApartNum);
		for (int i = 0; i < aparts.length; i++) {
			if(aparts[i] == 0) {
			} else {
				System.out.println(aparts[i]);
			}
		}
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		aparts[ApartNum]++;
		int nx, ny;
		
		for (int i = 0; i < 4; i++) {
			nx = x + dirs[i][0];
			ny = y + dirs[i][1];
			
			if(isIn(nx, ny)) {
				if(!visited[nx][ny] && space[nx][ny] == 1)
					dfs(nx, ny);
			}
		}
	}
	
	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && ny >= 0 && nx < N && ny < N)
			return true;
		return false;
	}

}
