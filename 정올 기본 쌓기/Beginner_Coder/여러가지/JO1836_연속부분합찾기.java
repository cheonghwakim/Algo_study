package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1836_연속부분합찾기 {
	static int N, arr[], max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if(sum < 0)
				sum = 0;
			
			if(max < sum) max = sum;
		}
		
		System.out.println(max);
	}
}
