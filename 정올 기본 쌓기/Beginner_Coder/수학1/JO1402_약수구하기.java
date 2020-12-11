package jungol.Beginner_Coder.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1402_약수구하기 {
	static int n, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if(n % i == 0 && ++cnt == k) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
	}

}
