package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5585_거스름돈 {
	static int N, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 1000 - Integer.parseInt(br.readLine());

		cnt += N / 500;
		N %= 500;
		
		cnt += N / 100;
		N %= 100;
		
		cnt += N / 50;
		N %= 50;
		
		cnt += N / 10;
		N %= 10;
		
		cnt += N / 5;
		N %= 5;
		
		cnt += N / 1;
		
		System.out.println(cnt);
	}
}