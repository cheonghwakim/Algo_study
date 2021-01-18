package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920_수찾기_이분탐색 {
	static int N, M, num[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			
			if(binarysearch(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append("\n");
				continue;
			}
			sb.append(0).append("\n");
		}		
		System.out.println(sb);
	}

	private static boolean binarysearch(int input) {
		int start = 0, end = N - 1;
		while(start <= end) {
			
			int mid = (start + end) / 2;
			
			if(num[mid] == input)
				return true;
			else if(num[mid] < input) {
				start = mid + 1;
			} else
				end = mid - 1;
		}
		
		return false;
	}
}
