package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1309_팩토리얼 {
	static long[] D;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		D = new long[n + 1];
		D[0] = 1;
		D[1] = 1;
		sb.append(factorial(sb, n)).append("\n");
		System.out.println(sb);
	}

	private static long factorial(StringBuilder sb, int n) {
		if(n == 1) {
			sb.append("1! = 1\n");
			return 1;
		}
		sb.append(n).append("! = ").append(n).append(" * ").append(n - 1).append("!\n");
		return D[n] = n * factorial(sb, n - 1);
	}
}