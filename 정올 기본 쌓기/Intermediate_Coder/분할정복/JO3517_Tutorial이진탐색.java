package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO3517_Tutorial이진탐색 {
	static long a[];
	static int N, Q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		a = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		
		Q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			long num = Long.parseLong(st.nextToken());
			
			sb.append(binarySearch_recur(0, N - 1, num)).append(" ");
		}
		sb.append("\n");
		
		System.out.println(sb);
	}

	private static Object binarySearch(int low, int high, long target) {
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(a[mid] == target) return mid;
			else if(a[mid] > target) 
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	private static int binarySearch_recur(int low, int high, long target) {
		
		if(low > high)
			return -1;
		
		int mid = (low + high) / 2;
		
		if(a[mid] == target)
			return mid;
		
		if(a[mid] > target)
			return binarySearch_recur(low, mid - 1, target);
		
		return binarySearch_recur(mid + 1, high, target);
	}
}
