package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018_체스판다시칠하기 {
	static int N, M, min = Integer.MAX_VALUE;
	static String[][] map;
	static boolean change[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new String[N][M];
		change = new boolean[2][N][M]; // 0은 B먼저: 짝수& 짝수 줄 B/ 1은 W먼저: 홀수행 & 짝수줄 W
		for (int i = 0; i < N; i++) {
			String string = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = string.split("")[j];
				
				if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
					if(map[i][j].equals("B")) change[1][i][j] = true;
					if(map[i][j].equals("W")) change[0][i][j] = true;		
				
				} else if((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
					if(map[i][j].equals("B")) change[0][i][j] = true; // W여야 함
					if(map[i][j].equals("W")) change[1][i][j] = true;		
				} 
			}
		}
		
		// change[][][] 에서 랜덤으로 8*8을 선택해서  true의 개수 세기
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				
				int cnt1 = 0, cnt2 = 0;
				for (int i2 = i; i2 < i + 8; i2++) {
					for (int j2 = j; j2 < j + 8; j2++) {
						if(change[0][i2][j2]) cnt1++;
						if(change[1][i2][j2]) cnt2++;
					}
				}
				
				if(min > cnt1) min = cnt1;
				if(min > cnt2) min = cnt2;
			}
		}
		
		System.out.println(min);
	}

}
