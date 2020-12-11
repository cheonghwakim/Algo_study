package jungol.Beginner_Coder.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1658_최대공약수와최소공배수 {
	static int num1, num2, GCD, LCM;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
	
		int end = num1 > num2 ? num2: num1;
		for (int i = end; i >= 1; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				GCD = i;
				LCM = (num1 / i) * (num2 / i) * i;
				break;
			}
		}
		sb.append(GCD).append("\n").append(LCM);
		System.out.println(sb);
	}

}
