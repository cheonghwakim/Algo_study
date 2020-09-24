package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 2628 종이자르기 https://www.acmicpc.net/problem/2628
public class BOJ2628_종이자르기 {
	static int C, R, N, max;
	static int[][] space;
	static ArrayList<Integer> x = new ArrayList<>();
	static ArrayList<Integer> x_length = new ArrayList<>();
	static ArrayList<Integer> y = new ArrayList<>();
	static ArrayList<Integer> y_length = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		space = new int[C][R];
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if(type == 0) {
				x.add(num);
			} else {
				y.add(num);
			}
		}
		
		x.add(R);
		y.add(C);
		Collections.sort(x);
		Collections.sort(y);
		
		for (int i = 0; i < x.size(); i++) {
			if(i == 0) {
				x_length.add(x.get(i));
			} else {
				x_length.add(x.get(i) - x.get(i - 1));
			}
		}
		
		for (int i = 0; i < y.size(); i++) {
			if(i == 0) {
				y_length.add(y.get(i));
			} else {
				y_length.add(y.get(i) - y.get(i - 1));
			}
		}
		
		Collections.sort(x_length);
		Collections.sort(y_length);

		System.out.println(x_length.get(x_length.size() - 1)*y_length.get(y_length.size() - 1));
	}

}
