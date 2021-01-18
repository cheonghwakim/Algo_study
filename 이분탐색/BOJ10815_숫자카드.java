package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815_숫자카드 {
	static int N, M, nums[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(isIn(num))
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}
		
		System.out.println(sb);
	}

	private static boolean isIn(int num) {
		int start = 0, end = N - 1;
		
		while(start <= end) {
			
			int mid = (start + end) / 2;
			
			if(nums[mid] == num)
				return true;
			else if(nums[mid] < num)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}
}