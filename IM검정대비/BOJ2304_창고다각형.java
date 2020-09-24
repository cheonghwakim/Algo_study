package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 2304 창고 다각형 https://www.acmicpc.net/problem/2304
public class BOJ2304_창고다각형 {
	static int N, max, sum, idx, height, totalmax, maxidx;
	static ArrayList<bar> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			idx = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			if(totalmax <= height) {// 전체 막대 중 가장 긴 막대
				maxidx = idx;
				totalmax = height;
			}
			list.add(new bar(idx, height));
		}
		Collections.sort(list);
		
		// 앞에서부터 가장 큰 막대까지
		for (int i = 0; i < N; i++) {
			if(i == 0)
				max = i; // 큰 높이 인덱스 
			
			if(list.get(max).height <= list.get(i).height) {
				sum += (list.get(i).idx - list.get(max).idx)*list.get(max).height;
				max = i;
			}
			
			if(list.get(i).idx == maxidx) {
				break;
			}
		}
		
		// 뒤에서부터 가장 큰 막대까지
		for (int i = N - 1; i >= 0; i--) {
			if(i == N - 1)
				max = i;
			
			if(list.get(max).height <= list.get(i).height) {
				sum += (list.get(max).idx - list.get(i).idx)*list.get(max).height;
				max = i;
			}

			if(list.get(i).idx == maxidx)
				break;
		}
		
		sum += totalmax;
		System.out.println(sum);
	}
	
	static class bar implements Comparable<bar>{
		int idx;
		int height;
		
		bar(int idx, int height){
			this.idx = idx;
			this.height = height;
		}

		@Override
		public int compareTo(bar o) {
			return this.idx - o.idx;
		}
	}
}
