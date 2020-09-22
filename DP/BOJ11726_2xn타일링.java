package boj;

import java.util.Scanner;
// 백준 11726 2xn 타일링 https://www.acmicpc.net/problem/11726
public class BOJ11726_2xn타일링 {
	static int n;
	static int[] memo;
	
	public static int fibo(int n) {
		if(n == 1)
			return memo[1] = 1;
		if(n == 2)
			return memo[2] = 2;
		
		if(n >= 3 && memo[n] == 0) {
			memo[n] = (fibo(n - 1) + fibo(n - 2)) % 10007;
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		memo = new int[n + 1];
		
		System.out.println(fibo(n));
	}
}
