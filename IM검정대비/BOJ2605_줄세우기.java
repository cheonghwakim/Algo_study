package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 백준 2605 줄 세우기 https://www.acmicpc.net/problem/2605
public class BOJ2605_줄세우기 {
	static int N, num, tmp;
	static LinkedList<Integer> result = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder string = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			if(i == 0) 
				result.add(i + 1);
			num = Integer.parseInt(st.nextToken());

			// result.length - num에 i + 1를 넣고 원래 그 자리부터 뒤는 한 칸씩 밀려남 
			result.add(result.size() - num - 1, i + 1);
		}

		
		for (int i = 0; i < N; i++) {
			string.append(result.get(i) + " ");
		}
		System.out.println(string);
	}

}
