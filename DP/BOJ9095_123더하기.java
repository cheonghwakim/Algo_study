package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095_123더하기 {
	static int T, N, D[] = new int[11];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder string = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		D[0] = 1;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 3; j++) {
				if(i - j >= 0) {
					D[i] += D[i - j];
				}
			}
		}
			
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			string.append(D[N]).append("\n");
		}
		System.out.println(string);
	}

}
