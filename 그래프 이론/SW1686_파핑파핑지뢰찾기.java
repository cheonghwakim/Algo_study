package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class SW1686_파핑파핑지뢰찾기 {
    static int T, N, result;
    static char[][] map;
    static boolean[][] visited;
    static int[][] numMap, dirs = { {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1} };
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
             
            map = new char[N][N];
            numMap = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                char[] string = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = string[j];
                    if(map[i][j] == '*') {
                        numMap[i][j] = -1;
                        visited[i][j] = true;
                    }
                }
            }
             
            // 1. 8방 탐색해서 .인 곳에 숫자 넣어줌
            // 2. bfs로 탐색하면서 0만나면 0인 거 다 큐에 넣어줘서 한 번에 8방 해버림
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '*')
                        continue;
                     
                    for (int d = 0; d < dirs.length; d++) {
                        int nx = i + dirs[d][0];
                        int ny = j + dirs[d][1];
                         
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                            continue;
                         
                        if(map[nx][ny] == '*')
                            numMap[i][j]++;
                    }
                }
            }
             
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(numMap[i][j] == 0 && !visited[i][j]) {
                        q.add(new int[] {i, j});
                         
                        while(!q.isEmpty()) {
                            int x = q.peek()[0];
                            int y = q.poll()[1];
                             
                            for (int d = 0; d < dirs.length; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                 
                                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
                                    continue;
                                 
                                visited[nx][ny] = true;
                                if(numMap[nx][ny] == 0)
                                    q.add(new int[] {nx, ny});
                            }
                        }
                        result++;
                    }
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(numMap[i][j] != -1 && numMap[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        result++;
                    }
                }
            }
             
            answer.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }
 
}
