package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1161_하노이1 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 2, 3); // n개를 1: 현재기둥, 2: 보조기둥, 3: 목표기둥으로 옮기겠다
		System.out.println(sb);
	}

	private static void hanoi(int n, int from, int mid, int to) {
		if(n == 0) {
			return; // 옮기기 끝남
		}
		
		hanoi(n - 1, from, to, mid); // n - 1개를 보조 기둥으로 옮겨야 함
		sb.append(n).append(" : ").append(from).append(" -> ").append(to).append("\n");
		
		hanoi(n - 1, mid, from, to); // 보조 기둥에 있던 애들을 다시 목표기둥으로 옮겨야 함
	}
}