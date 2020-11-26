package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ8972_미친아두이노2 {
	static int[][] map, dirs = { {0, 0}, {1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 0}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1} };
	static int R, C;
	static Position JongSu;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder string = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		Queue<Position> q = new LinkedList<>();
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(tmp[j] == 'I') {
					JongSu = new Position(i, j);
					map[i][j] = -1;
				}
				if(tmp[j] == 'R') {
					q.add(new Position(i, j));
					map[i][j] = 1;
				}
			}
		}
		char[] move = br.readLine().toCharArray();
			
		// 종수 먼저 움직이고
		// 미친 아두이노 움직이고
		for (int i = 0; i < move.length; i++) {
			int distance = move[i] - '0'; // 종수가 움직일 방햠
			map[JongSu.x][JongSu.y] = '.';
			JongSu.x += dirs[distance][0];
			JongSu.y += dirs[distance][1];
			map[JongSu.x][JongSu.y] = 'I';
			
			if(map[JongSu.x][JongSu.y] == 'R') { // 종수랑 아두이노랑 만나면 return
				System.out.println("kraj " + (i + 1));
				return;
			}
			
			
			
			// 아두이노 움직이기
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Position cur = q.poll();
				map[cur.x][cur.y] = '.';
				
				int dir = getDirection(JongSu.x, JongSu.y, cur.x, cur.y);
				int nx = cur.x + dirs[dir][0];
				int ny = cur.y + dirs[dir][1];
				
				if(map[nx][ny] == 'R')
					map[nx][ny] = '.';
				
				if(map[nx][ny] == 'I') {
					System.out.println("kraj " + (i + 1));
					return;
				}
				
				map[nx][ny] = 'R';
				q.add(new Position(nx, ny));
			}			
			
			print(i);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				string.append(map[i][j]);
			}
			string.append("\n");
		}
			
		System.out.println(string);
	}
	
	private static void print(int i) {
		System.out.print(i + "============================");
		for (int k = 0; k < R; k++) {
			for (int h = 0; h < C; h++) {
				System.out.print(map[k][h]);
			}
			System.out.println();
		}
		System.out.println("-=---------------------------------");		
	}

	private static int getDirection(int r1, int s1, int r2, int s2) {
		int min = Integer.MAX_VALUE;
		int direction = 0;
		for (int d = 1; d <= 9; d++) {
			int nr2 = r2 + dirs[d][0];
			int ns2 = s2 + dirs[d][1];
			
			if(nr2 < 0 || ns2 < 0 || nr2 >= R || ns2 >= C)
				continue;
			
			int distance = Math.abs(r1 - nr2) + Math.abs(s1 - ns2);
			if(min > distance) {
				min = distance;
				direction = d;
			}
		}
		return direction;
	}
	
//	private static ArrayList<Integer> getDirection(int r1, int s1, int r2, int s2) {
//		int min = Integer.MAX_VALUE;
//		int[] direction = new int[9];
//		for (int d = 1; d <= 8; d++) {
//			int nr2 = r2 + dirs[d][0];
//			int ns2 = s2 + dirs[d][1];
//			
//			int distance = Math.abs(r1 - nr2) + Math.abs(s1 - ns2);
//			direction[d] = distance;
//			if(min > distance)
//				min = distance;
//		}
//		
//		ArrayList<Integer> directions = new ArrayList<>();
//		for (int i = 1; i <= 8; i++) {
//			if(min == direction[i])
//				directions.add(i);
//		}
//		return directions;
//	}
	
	static class Position{
		int x, y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
