package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978_소수찾기 {
	static int N, nums[], max;
	static boolean isComposite[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			max = max < nums[i] ? nums[i] : max;
		}
		
		isComposite = new boolean[max + 1];
		for (int i = 2; i * i <= max; i++) {
			if(isComposite[i]) continue;
			
			for (int j = i * 2; j <= max; j += i) {
				isComposite[j] = true;
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(!isComposite[nums[i]] && nums[i] != 0 && nums[i] != 1)
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
