package jungol.Beginner_Coder.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1534_10진수를2816진수로 {
	static int N, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	
		if(B == 2) {
			System.out.println(Integer.toBinaryString(N));
			return;
			
		} else if(B == 8) {
			System.out.println(Integer.toOctalString(N));
			return;
			
		} else {
			String answer = Integer.toHexString(N).toUpperCase();
			
			System.out.println(answer);
			return;
		}
	}
}
