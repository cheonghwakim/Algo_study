package programmers;

import java.util.Collections;
import java.util.LinkedList;

// https://programmers.co.kr/learn/courses/30/lessons/1836?language=java
// 1:25:??  // 틀림

//https://hyunjiishailey.tistory.com/303 참고해서 한 번 더 풀어보기
public class 프로그래머스_리틀프렌즈사천성 {
	static int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static boolean[] check = new boolean[26];
	static boolean[][] visited;
	static char[][] map;
	static boolean isPossible;
	
	public static void main(String[] args) {
//		int m = 3, n = 3;
//		String[] board = { "DBA", "C*A", "CDB" };
		
		int m = 2, n = 4;
		String[] board = { "NRYN", "ARYA" };
		
//		System.out.println(solution(m, n , board));
		System.out.println(solution(1, 4, new String[] {"AABB"}));
	}
	
	public static String solution (int m, int n, String[] board) {
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Location> locations = new LinkedList<>();
		
		map = new char[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
				if(map[i][j] >= 65 && map[i][j] <= 90 && !check[map[i][j] - 65]) {
					locations.add(new Location(map[i][j], i, j));
					check[map[i][j] - 65] = true;
				}
			}
		}
		Collections.sort(locations);
		
		while(locations.size() > 0) {
			Location cur = locations.remove(0);
			
			boolean isPossible = false;
			
			visited = new boolean[m][n];
			// 만약 블럭이 제거 안 되면 다시 pq에 넣어야 함
			for (int d = 0; d < dirs.length; d++) {
				isPossible = false;
				dfs(cur, cur.x, cur.y, d, 0, m, n);
				if(isPossible) {	
					sb.append(cur.block);
					break;
				}
			}
			
			if(!isPossible)
				locations.add(cur);
		}
		
		String answer = sb.toString();
		return answer;
	}
	
	// cnt => 방향을 바꾼 횟수
	private static void dfs(Location cur, int x, int y, int d, int cnt, int m, int n) {
		visited[x][y] = true;
		
		if(cnt <= 2 && (x != cur.x || y != cur.y) && map[x][y] == cur.block) {
			isPossible = true;
		}
		
		for (int dir = 0; dir < dirs.length; dir++) {
			int nx = x + dirs[dir][0];
			int ny = y + dirs[dir][1];
			
			if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny])
				continue;
			
			if(map[nx][ny] == '.' || map[nx][ny] == cur.block) {	
				if(dir == d) 
					dfs(cur, nx, ny, dir, cnt, m, n);
				else 
					dfs(cur, nx, ny, dir, cnt + 1, m, n);
			}
		}
	}

	public static class Location implements Comparable<Location> {
		char block;
		int x;
		int y;
		
		Location(char block, int x, int y) {
			this.block = block;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Location o) {
			return this.block - o.block;
		}
	}
}
