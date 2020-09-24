package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 2477 참외밭 https://www.acmicpc.net/problem/2477
public class BOJ2477_참외밭 {
	static int K, c, r, result, cmax, rmax;
	static int[] space;
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		check = new boolean[6];
		space = new int[6];
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()); // idx가 1, 2면 동서 / 3, 4면 남북
			space[i] = Integer.parseInt(st.nextToken());
			
			if(idx == 1 || idx == 2) {
				if(cmax < space[i])
					cmax = space[i];
			
			} else if(idx == 3 || idx == 4) {
				if(rmax < space[i])
					rmax = space[i];
				
			}
		}
		
		for (int i = 0; i < 6; i++) {
			if(space[i] == cmax || space[i] == rmax) {
				check[i] = true;
				if(i + 1 > 5) {
					check[0] = true;
				} else {
					check[i + 1] = true;
				}
				
				if(i - 1 < 0) {
					check[5] = true;
				} else {
					check[i - 1] = true;
				}
				
			}
		}
		
		int tmp = 1;
		for (int j = 0; j < 6; j++) {
			if(!check[j])
				tmp *= space[j];
		}
		result = (rmax*cmax - tmp)*K;
		System.out.println(result);
	}

}
