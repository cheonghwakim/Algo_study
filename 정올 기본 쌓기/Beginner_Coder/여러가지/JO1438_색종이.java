package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1438_색종이 {
	static int N;
	static boolean[][] attached = new boolean[100][100];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
		
			for (int j = h; j < h + 10; j++) {
				for (int k = w; k < w + 10; k++) {
					attached[j][k] = true;
				}
			}
		}
		
		int area = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(attached[i][j])
					area++;
			}
		}
		System.out.println(area);
	}
}
