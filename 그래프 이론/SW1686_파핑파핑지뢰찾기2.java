package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class SW1686_파핑파핑지뢰찾기2 {
    static int T, N, result;
    static char[][] map;
    static int[][] dirs = { {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1} };
     
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

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '.' && check(i, j)) {
                    	map[i][j] = '#';
                        bfs(i, j);
                        result++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '.') {
                        result++;
                    }
                }
            }
             
            answer.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		
        q.add(new int[] {i, j});
             
        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.poll()[1];
            
            
             
            for (int d = 0; d < dirs.length; d++) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];
                     
                if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                     
 
                if(map[nx][ny] == '.')
                	if(check(nx, ny))
                		q.add(new int[] {nx, ny});
                map[nx][ny] = '#';
            }
        }

	}

	private static boolean check(int i, int j) {
		for (int d = 0; d < dirs.length; d++) {
			int ni = i + dirs[d][0];
			int nj = j + dirs[d][1];
			
			if(ni < 0 || nj < 0 || ni >= N || nj >= N)
				continue;
			
			if(map[ni][nj] == '*')
				return false;
		}
		return true;
	}
 
}
