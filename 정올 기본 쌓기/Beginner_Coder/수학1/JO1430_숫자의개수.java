package jungol.Beginner_Coder.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1430_숫자의개수 {
	static int A, B, C, nums[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		nums = new int[10];
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		
		int result = A * B * C;
		char[] multiple = Integer.toString(result).toCharArray(); // 기억하기!!
		
		for (int i = 0; i < multiple.length; i++) {
			nums[multiple[i] - '0']++;
		}
		
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]).append("\n");
		}
		System.out.println(sb);
	}

}
