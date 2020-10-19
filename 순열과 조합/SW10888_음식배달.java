package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW10888_음식배달 {
	static int T, N, answer = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<int[]> food = new ArrayList<>();
	static ArrayList<int[]> house = new ArrayList<>();
	static int[] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder string = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			food.clear();
			house.clear();		
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 1) 
						food.add(new int[] {i, j});
					if(map[i][j] == 1) 
						house.add(new int[] {i, j});
				}
			}
			
			
			answer = Integer.MAX_VALUE;
			for (int i = 1; i <= food.size(); i++) {
				result = new int[i];
				comb(0, 0, i);
			}
			
			string.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(string);
		
	}

	private static void comb(int cnt, int cur, int r) {
		if(cnt == r) {
			
			// 배달거리 구하기
			int fee = 0; // 운영비			
			for (int i = 0; i < result.length; i++) { // 각 음식점 운영비 미리 더함
				fee += map[food.get(result[i])[0]][food.get(result[i])[1]];
			}
			for (int i = 0; i < house.size(); i++) { // 모든 집에 대해서
				int x = house.get(i)[0];
				int y = house.get(i)[1];
				
				int distance = Integer.MAX_VALUE;
				for (int j = 0; j < result.length; j++) { // 모든 음식점에 대해서 
					int fx = food.get(result[j])[0];
					int fy = food.get(result[j])[1];
					
					int tmp = Math.abs(x - fx) + Math.abs(y - fy); // 배달 거리 구하기
					if(distance > tmp) // 배달 거리 중 가장 작은 게 배달 거리가 됨.
						distance = tmp;
				}
				fee += distance;
				if(answer < fee) return; // 이전에 구한 운영비보다 커지면 그냥 return
			}

			if(answer > fee)
				answer = fee;
			
			return;
		}
		
		for (int i = cur; i < food.size(); i++) {
			result[cnt] = i;
			comb(cnt + 1, i + 1, r);
		}
	}
	

}
