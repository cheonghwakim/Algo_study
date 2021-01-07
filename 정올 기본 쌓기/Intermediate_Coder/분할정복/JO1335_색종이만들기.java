package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// **
public class JO1335_색종이만들기 {
	static int N, map[][], answer[] = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(N, 0, 0);
		StringBuilder sb = new StringBuilder();
		sb.append(answer[0]).append("\n").append(answer[1]);
		System.out.println(sb);
	}

	private static void dfs(int size, int x, int y) {

		if(isSame(size, x, y))
			return;
		
		dfs(size / 2, x, y); // 1사분면
		dfs(size / 2, x + size / 2, y); // 3사분면
		dfs(size / 2, x, y + size / 2); // 2사분면
		dfs(size / 2, x + size / 2, y + size / 2); // 4사분면
	}

	private static boolean isSame(int size, int x, int y) {
		
		// 왜 y부터 하면 안되지...?
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(map[x][y] != map[i][j])
					return false;
			}
		}
		
		answer[map[x][y]]++;
		return true;
	}
}