package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// swea 4613 러시아 국기 같은 깃발 https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQl9TIK8qoDFAXj&categoryId=AWQl9TIK8qoDFAXj&categoryType=CODE&&&&&&&&&
public class SW4613_러시아국기같은깃발 {
	static int T, N, M, cnt = Integer.MAX_VALUE;
	static int[] white, blue, red;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder string = new StringBuilder();
		
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			white = new int[N];
			blue = new int[N];
			red = new int[N];
			
			for (int i = 0; i < N; i++) {
				String tmps = br.readLine();
				for (int j = 0; j < M; j++) {
					String s = tmps.split("")[j];
					if(s.equals("W"))
						white[i]++;
					else if(s.equals("B"))
						blue[i]++;
					else if(s.equals("R"))
						red[i]++;
				}
			}
			
			int tmp = 0;
			for (int i = 1; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					
					// W는 0 ~ i-1까지
					for (int k = 0; k < i; k++) {
						tmp += M - white[k]; // white로 칠해야 하는 횟수
					}
					// B i+1 ~ j-1까지
					for (int k = i; k < j; k++) {
						tmp += M - blue[k];
					}
					// R는 j ~ N-1
					for (int k = j; k < N; k++) {
						tmp += M - red[k];
					}
					
					if(cnt > tmp) {
						cnt = tmp;
					}
					tmp = 0;
				}
			}
			string.append("#").append(tc).append(" ").append(cnt).append("\n");
			cnt = Integer.MAX_VALUE;
		}
		System.out.println(string);
	}

}
