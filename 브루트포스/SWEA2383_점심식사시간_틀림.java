package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2383_점심식사시간_틀림 {
	static int T, N, dirs[][] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static Object[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder string = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new Object[N][N];
			visited = new boolean[N][N];
			
			int num = 0;
			Queue<Object> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					
					if(input == 1) {
						q.add(new Object(0, i, j, -1, num++));
						visited[i][j] = true;
//						map[i][j] = new Object(0, i, j, 0, 0);
					} else if(input > 1) {
						map[i][j] = new Object(1, i, j, input, 0);
					} 
//					else
//						map[i][j] = new Object(2, i, j, 0, 0); // 아무것도 아님
					
				}
			}
			
			int time = 0;
			while(!q.isEmpty()) {
				int size = q.size(); // 사람들 먼저
				for (int i = 0; i < size; i++) {
					Object cur = q.poll();
					
					if(cur.stair_time < 0) { // 현재 계단에 없으면
						for (int d = 0; d < dirs.length; d++) {
							int nx = cur.x + dirs[d][0];
							int ny = cur.y + dirs[d][1];
							
							if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
								continue;
							
							if(map[nx][ny] != null && map[nx][ny].type == 1) { // 계단에 들어가면
								if(map[nx][ny].num < 3) {
									map[nx][ny].num++;
									q.add(new Object(0, nx, ny, 0, cur.num));
								} else 
									q.add(new Object(0, cur.x, cur.y, -1, cur.num));
							
							} else {
								q.add(new Object(0, nx, ny, -1, 0));
								visited[nx][ny] = true;
							}
						}
					
					} else {
						if(cur.stair_time + 1 != map[cur.x][cur.y].stair_time) // 계단 시간과 사람이 계단에 머무른 시간이 같으면 poll 아니면 q에 넣음
							q.add(new Object(0, cur.x, cur.y, ++cur.stair_time, cur.num));
						else
							map[cur.x][cur.y].num--;
					}
				}
				
				print();
				time++;
			}
			string.append("#").append(tc).append(" ").append(time).append("\n");
		}
		System.out.println(string);
	}
	

	private static void print() {
		System.out.println("-------------------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != null)
					System.out.print(map[i][j].num + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
		
		System.out.println("11111111111");
	}


	static class Object {
		int type; // 사람인지(0), 계단인지(1)
		int x;
		int y;
		int stair_time; // 사람: 계단에 있은 시간, 계단: 그 계단을 지나갈 떄 걸리는 시간
		int num; // 사람: (?), 계단: 그 계단 위에 사람이 얼마나 있는지
		
		Object(int type, int x, int y, int stair_time, int num){
			this.type = type;
			this.x = x;
			this.y = y;
			this.stair_time = stair_time;
			this.num = num;
		}
	}
}
