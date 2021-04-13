package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2115_벌꿀채취 {
	static int T, N, M, C, max[];
	static int[][] map, dirs = { {0, 1} };
	static boolean[][] visited;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		
			map = new int[N][N];
			visited = new boolean[N][N];
			max = new int[2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					visited[i][j] = true;
					map[i][j] = (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
				}
			}
			
			// dfs로 하다가 M개 만큼 선택 -> 합이 C가 되지 않는 선에서 수익이 최대가 되는 숫자를 고름
			// 애초에 제곱을 해서 넣어주고 합이 C^2보다 작은 선에서 수익이 최대가 되는 숫자를 고름  => 안되나..?
			// 계속해서 갱신 --> 이렇게 첫번째로 합이 높은 것, 두번째로 합이 높은 것 선택
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean[][] checked = new boolean[N][N];
					int[] result = new int[M];

					dfs(i, j, checked, result, 0);
				}
			}
			
			int max_sum = max[0] + max[1];
			System.out.println("#" + tc + " " + max_sum);
			
		}
	}

	private static void dfs(int x, int y, boolean[][] checked, int[] result, int cnt) {
		if(cnt == M) {
			for (int i = 1; i <= M; i++) {
				int[] answer = new int[i];
				comb(i, 0, 0, result, answer);
			}
			return;
		}
		
		checked[x][y] = true;
		result[cnt] = map[x][y];
		
		for (int d = 0; d < dirs.length; d++) {
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || checked[nx][ny])
				continue;
			
			
			dfs(nx, ny, checked, result, cnt + 1);
		}
		return;
	}

	private static void comb(int r, int cnt, int cur, int[] result, int[] answer) {
		if(cnt == r) {		
			sum = 0;
			for (int i = 0; i < r; i++) {
				sum += result[answer[i]];
				if(sum > C*C)
					return;
			}
			
			if(max[0] < sum) {
				max[1] = max[0];
				max[0] = sum;
			}
			else if(max[0] > sum && max[1] < sum)
				max[1] = sum;
			return;
		}
		
		for (int i = cur; i < M; i++) {
			answer[cnt] = i;
			comb(r, cnt + 1, i + 1, result, answer);
		}
	}

}
