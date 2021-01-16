package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609_최대공약수와최소공배수 {
	static int num1, num2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		
		int GCD = gcd(num1, num2);
		int LMC = num1 * num2 / GCD;
		
		System.out.println(GCD);
		System.out.println(LMC);
	}

	private static int gcd(int num1, int num2) {
		if(num1 % num2 == 0)
			return num2;
		return gcd(num2, num1 % num2);
	}
}