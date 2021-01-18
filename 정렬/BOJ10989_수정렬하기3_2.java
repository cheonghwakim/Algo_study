package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Arrays.sort보다 PriorityQueue가 더 빠르다 --> 카운팅 정렬 O(N)
public class BOJ10989_수정렬하기3_2 {
	static int N, counting[], nums[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		counting = new int[10001];
		nums = new int[N];
		
		// Counting Sort
		// 과정 1. array에 숫자 넣고 해당 숫자를 index로 하는 counting 배열의 값을 1씩 증가시킴
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			counting[nums[i]]++;
		}
		
		// 과정 2. counting 배열의 값을 누적합으로 변환시킴
		for (int i = 1; i < counting.length; i++) {
			counting[i] += counting[i - 1];
		}
		
		int[] result = new int[N];
		// 과정 3. counting 배열의 각 값은 (시작점 - 1)을 알려줌
		for (int i = 0; i < N; i++) {
			result[counting[nums[i]]-- - 1] = nums[i];
		}

		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
}