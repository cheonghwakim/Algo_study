package jungol.Beginner_Coder.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2811_소수와합성수 {
	static int num;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			num = Integer.parseInt(st.nextToken());
			
			isPrime(num, sb);
		}
		
		System.out.println(sb);
	}

	private static void isPrime(int num, StringBuilder sb) {
		if(num == 1) {
			sb.append("number one").append("\n");
			return;
		}
		
		for (int i = 2; i * i <= num; i++) {
			
			if(num % i == 0) {
				sb.append("composite number").append("\n");
				return;
			}
		}
		
		sb.append("prime number").append("\n");
	}

}
