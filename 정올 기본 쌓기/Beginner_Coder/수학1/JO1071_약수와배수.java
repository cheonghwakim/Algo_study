package jungol.Beginner_Coder.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1071_약수와배수 {
	static int n, nums[], m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		
		int divisor = 0, multiple = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] <= m && m % nums[i] == 0) divisor += nums[i];
			if(nums[i] >= m && nums[i] % m == 0) multiple += nums[i];
		}
		
		sb.append(divisor).append("\n").append(multiple);
		System.out.println(sb);
		
	}
}
