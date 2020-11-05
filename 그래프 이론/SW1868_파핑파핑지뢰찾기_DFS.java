package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1868_파핑파핑지뢰찾기_DFS {
	static int[][] num, dirs = { {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1} };
	static char[][] map;
	static boolean[][] visited;
	static int N, T, result;
	
	public static void dfs(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(!visited[nx][ny] && num[nx][ny] > 0)
					visited[nx][ny] = true;
				else if(!visited[nx][ny] && num[nx][ny] == 0) {
					visited[nx][ny] = true;
					dfs(nx,ny);
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
             
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                char[] string = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = string[j];
                }
            }

			num = new int[N][N];
			visited = new boolean[N][N];
			int area = 0;
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '*') {
						num[i][j] = -1;
						visited[i][j] = true;
						continue;
					}
					int cnt = 0;
					for(int k = 0; k < 8; k++) {
						int nx = i + dirs[k][0];
						int ny = j + dirs[k][1];
						if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
							if(map[nx][ny] == '*') cnt++;
						}
					}
					num[i][j] = cnt;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0;  j < N; j++) {
					if(num[i][j] == 0 && !visited[i][j]) {
						area++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) area++;
				}
			}
			answer.append("#").append(tc).append(" ").append(area).append("\n");
		}
        System.out.println(answer);
	}
}