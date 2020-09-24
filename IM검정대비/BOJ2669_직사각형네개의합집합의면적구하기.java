package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 2669 직사각형 네개의 합집합의 면적 구하기 https://www.acmicpc.net/problem/2669
public class BOJ2669_직사각형네개의합집합의면적구하기 {
	static int N, cnt, xmax, ymax;
	static int[] x, y, x2, y2;
 	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		x = new int[4];
		y = new int[4];
		x2 = new int[4];
		y2 = new int[4];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			x2[i] = Integer.parseInt(st.nextToken());
			y2[i] = Integer.parseInt(st.nextToken());
			if(xmax < x2[i])
				xmax = x2[i];
			if(ymax < y2[i])
				ymax = y2[i];
		}

		map = new int[xmax][ymax];
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < x2[i] - x[i]; k++) {
				for (int j = 0; j < y2[i] - y[i]; j++) {
					map[x[i] + k][y[i] + j] = 1;
				}
			}
		}

		
		for (int i = 0; i < xmax; i++) {
			for (int j = 0; j < ymax; j++) {
				if(map[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}

