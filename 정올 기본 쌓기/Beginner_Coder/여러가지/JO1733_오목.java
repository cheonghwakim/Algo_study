package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1733_오목 {
	static int[][] map, dirs = { {0, 1}, {1, 1}, {1, 0}, {1, -1} };
	static boolean[][][] visited;
	static boolean[] omok;
	static boolean isTrue = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		map = new int[19][19];
		visited = new boolean[19][19][4];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				
				// 바둑알이 있는 곳이면 탐색
				if(map[i][j] == 1 || map[i][j] == 2) {
					// 세 방향으로 탐색
					for (int d = 0; d < dirs.length; d++) {
						
						if(!visited[i][j][d]) {
							omok = new boolean[6];
							omok[0] = true;
							dfs(i, j, map[i][j], d, 1);
							
							if(isTrue) {
								if(d == 3)
									sb.append(map[i][j]).append("\n").append(i + 5).append(" ").append(j - 3);
								else
									sb.append(map[i][j]).append("\n").append(i + 1).append(" ").append(j + 1);
	
								System.out.println(sb);
								return;
							}
						}
					}
				}
			}
		}
		System.out.println(0);
	}

	private static void dfs(int i, int j, int color, int dir, int cnt) {
		if(cnt == 6) {
			
			for (int k = 0; k < 6; k++) {
				if((k != 5 && !omok[k]) || (k == 5 && omok[k]))
					return;
			}
			
			isTrue = true;
			return;
		}
		
		int nx = i + dirs[dir][0];
		int ny = j + dirs[dir][1];
		
		if(nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && map[nx][ny] != color) {
			visited[nx][ny][dir] = false;
			omok[cnt] = false;
			dfs(nx, ny, color, dir, cnt + 1);
		}
		else if (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && map[nx][ny] == color) {
			visited[nx][ny][dir] = true;
			omok[cnt] = true;
			dfs(nx, ny, color, dir, cnt + 1);
		}
		else {
			omok[cnt] = false;
			dfs(nx, ny, color, dir, cnt + 1);
		}
	}
}