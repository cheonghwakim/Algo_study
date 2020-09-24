package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2216 주사위 쌓기 https://www.acmicpc.net/problem/2116
public class BOJ2216_주사위쌓기 {
	static int N, max, dice[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 마주보는 것들 쌍을 맞춰 배열에 넣음(abcdef -> abcfde)
			dice[i][0] = Integer.parseInt(st.nextToken());
			dice[i][1] = Integer.parseInt(st.nextToken());
			dice[i][2] = Integer.parseInt(st.nextToken());
			dice[i][4] = Integer.parseInt(st.nextToken());
			dice[i][5] = Integer.parseInt(st.nextToken());
			dice[i][3] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 6; i++) { // 밑면이 될 수 있는 조건 6
			search(0, dice[0][i], 0);
		}
		
		System.out.println(max);
	}
	
	public static void search(int num, int start, int sum) {
		if(num == N) {
			if(max < sum)
				max = sum;
			return;
		}
		
		int idx = 0;
		for (int i = 0; i < 6; i++) {
			if(start == dice[num][i]) {
				idx = i;
				break;
			}
		}
		
		int opposite;
		if(idx + 3 < 6)
			opposite = dice[num][idx + 3];
		else
			opposite = dice[num][idx - 3];
		
		int tmp = 0;
		for (int i = 0; i < 6; i++) {
			if(start == i + 1 || opposite == i + 1)
				continue;
			tmp = i + 1;
		}
		sum += tmp;
		search(num + 1, opposite, sum);
	}

}
