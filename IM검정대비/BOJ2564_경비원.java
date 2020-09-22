package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2564 경비원 https://www.acmicpc.net/problem/2564
public class BOJ2564_경비원 {
	static int N, row, col, distance;
	static int[][] point;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		point = new int[N + 1][2];
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken()); // 방향
			point[i][1] = Integer.parseInt(st.nextToken()); // 위치
		}
		
		int tmp, tmp2;
		for (int i = 0; i < N; i++) {
			if(point[N][0] == 1) { // 동근이의 방향에 따라 (북쪽이면)
				
				if(point[i][0] == 1) {
					distance += Math.abs(point[N][1] - point[i][1]);
				
				} else if(point[i][0] == 2) {
					tmp = point[N][1] + col + point[i][1];
					tmp2 = (row - point[N][1]) + col + (row - point[i][1]);
					distance += Math.min(tmp, tmp2);	
				
				} else if(point[i][0] == 3) {
					distance += point[N][1] + point[i][1];
				
				} else if(point[i][0] == 4) {
					distance += (row - point[N][1]) + point[i][1];
				}
			}		
			
			else if(point[N][0] == 2) { // 동근이의 방향에 따라 (남쪽이면)
				
				if(point[i][0] == 1) {
					tmp = point[N][1] + col + point[i][1];
					tmp2 = (row - point[N][1]) + col + (row - point[i][1]);
					distance += Math.min(tmp, tmp2);
					
				} else if(point[i][0] == 2) {
					distance += Math.abs(point[N][1] - point[i][1]);
					
				} else if(point[i][0] == 3) {
					distance += point[N][1] + (col - point[i][1]);
					
				} else if(point[i][0] == 4) {
					distance += (row - point[N][1]) + (col - point[i][1]);
					
				}
			}	
			
			else if(point[N][0] == 3) { // 동근이의 방향에 따라 (서쪽이면)
				
				if(point[i][0] == 1) {
					distance += point[N][1] + point[i][1];
					
				} else if(point[i][0] == 2) {
					distance += (col - point[N][1]) + point[i][1];
					
				} else if(point[i][0] == 3) {
					distance += Math.abs(point[N][1] - point[i][1]);
					
				} else if(point[i][0] == 4) {
					tmp = point[N][1] + row + point[i][1];
					tmp2 = (col - point[N][1]) + row + (col - point[i][1]);
					distance += Math.min(tmp, tmp2);
					
				}
			}		
			
			else if(point[N][0] == 4) { // 동근이의 방향에 따라 (동쪽이면)
				
				if(point[i][0] == 1) {
					distance += point[N][1] + (row -point[i][1]);
					
				} else if(point[i][0] == 2) {
					distance += (col - point[N][1]) + (row - point[i][1]);
					
				} else if(point[i][0] == 3) {
					tmp = point[N][1] + row + point[i][1];
					tmp2 = (col - point[N][1]) + row + (col - point[i][1]);
					distance += Math.min(tmp, tmp2);
					
				} else if(point[i][0] == 4) {
					distance += Math.abs(point[N][1] - point[i][1]);
					
				}
			}			
		}
		System.out.println(distance);

	}
}
