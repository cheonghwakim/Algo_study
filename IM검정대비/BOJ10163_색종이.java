package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 백준 10163 색종이 https://www.acmicpc.net/problem/10163
public class BOJ10163_색종이 {
	static int N, cnt = 1;
	static int[][] space = new int[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < x + w; j++) {
				for (int k = y; k < y + h; k++) {
					space[j][k] = cnt;
				}
			}
			
			cnt++;
		}
				
		for (int k = 1; k <= N; k++) {
			int sum = 0;		
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if(space[i][j] == k)
						sum++;
				}
			}
			System.out.println(sum);
		}
		
	}

}
