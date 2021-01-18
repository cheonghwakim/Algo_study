package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Arrays.sort보다 PriorityQueue가 더 빠르다 --> 카운팅 정렬 O(N)
public class BOJ10989_수정렬하기3 {
	static int N, counting[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		counting = new int[10001];

		// Counting Sort
		for (int i = 0; i < N; i++) {
			counting[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		for (int i = 1; i < 10001; i++) {
			if(counting[i] == 0)
				continue;
			
			while(counting[i] > 0) {
				sb.append(i).append("\n");
				counting[i]--;
			}
		}
		System.out.println(sb);
	}
}