package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO3560_색종이만들기2 {
	static int N, map[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(N, 0, 0);
		System.out.println(sb);
	}

	private static void dfs(int n, int x, int y) {
		if(isSame(n, x, y))
			return;
		
		dfs(n / 2, x, y);
		dfs(n / 2, x, y + n / 2);
		dfs(n / 2, x + n / 2, y);
		dfs(n / 2, x + n / 2, y + n / 2);
	}

	private static boolean isSame(int n, int x, int y) {
		
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if(map[x][y] != map[i][j]) {
					sb.append("X");
					return false;
				}
			}
		}
		
		sb.append(map[x][y]);
		return true;
	}
}