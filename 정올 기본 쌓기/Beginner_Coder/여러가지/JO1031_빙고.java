package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1031_빙고 {
	static int numcnt, map[][] = new int[5][5];
	static boolean[][] deleted = new boolean[5][5];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				numcnt++;
				int num = Integer.parseInt(st.nextToken());
				
				delete(num);
				
				if(numcnt >= 12) {
					if(isBingo()) {
						System.out.println(numcnt);
						return;
					}
				}
			}
		}
	}

	private static boolean isBingo() {
		int totalCnt = 0;
		for (int i = 0; i < 5; i++) {
			int rcnt = 0, ccnt = 0;
			for (int j = 0; j < 5; j++) {
				if(deleted[i][j]) {
					rcnt++;
				}
				if(deleted[j][i]) {
					ccnt++;
				}
			}
			if(rcnt == 5)
				totalCnt++;
			if(ccnt == 5)
				totalCnt++;
		}
		
		if(deleted[0][0] && deleted[1][1] && deleted[2][2] && deleted[3][3] && deleted[4][4])
			totalCnt++;
		if(deleted[0][4] && deleted[1][3] && deleted[2][2] && deleted[3][1] && deleted[4][0])
			totalCnt++;
		
		if(totalCnt >= 3)
			return true;
		return false;
	}

	private static void delete(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == num) {
					deleted[i][j] = true;
				}
			}
		}
	}
}
