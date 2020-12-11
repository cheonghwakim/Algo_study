package jungol.Beginner_Coder.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유클리드 호제법
// 여러 수의 최소공배수 구하기
// ex. A, B, C
// 1. A와 B의 최소공배수를 구한다.
// 2. 1에서 구한 최소공배수와 C의 최소공배수를 구한다.
public class JO1002_최대공약수최소공배수 {
	static int n, nums[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(min > nums[i]) min = nums[i];
		}
		
		int gcd = GCD(nums[0], nums[1]);
		int lcm = nums[0] * nums[1] / gcd;
		for (int i = 2; i < nums.length; i++) {
			lcm = (lcm * nums[i]) / GCD(lcm, nums[i]);
			gcd = GCD(nums[i], gcd);
			
		}
		
		sb.append(gcd).append(" ").append(lcm);
		System.out.println(sb);
		
	}
	
	static int GCD(int a, int b) {
		int gcd;
		while(true) {
			gcd = a % b;
			if(gcd == 0) break;
			
			a = b;
			b = gcd;
		}
		return b;
	}
	
	
//	// 재귀 (a > b임을 가정!)
//	static int GCD(int a, int b) {
//		if(b == 0) return a;
//		else return GCD(b, a%b);
//	}

}
