package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839_설탕배달 {
	static int N, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		while(N > 0) {
			
			if(N % 5 == 0) {
				cnt++;
				N -= 5;
			} else if(N % 3 == 0) {
				cnt++;
				N -= 3;
			} else if (N > 5) {
				cnt++;
				N -= 5;
			} else {
				cnt = -1;
				break;
			}
		}

		System.out.println(cnt);
	}
}