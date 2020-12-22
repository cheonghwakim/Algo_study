package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다르게 풀어보기
public class BOJ1436_영화감독숌 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int num = 666;
		while(true) {
			String compare = Integer.toString(num);
			if(compare.contains("666"))
				N--;
			
			if(N == 0) {
				System.out.println(compare);
				return;
			}
			
			num++;
		}
	}
}
