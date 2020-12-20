package jungol.Beginner_Coder.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO3106_진법변환 {
	static long A, B, dec;
	static String N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		while(true) {
			if(cnt == 100) break;
			
			st = new StringTokenizer(br.readLine());
			
			A = Long.parseLong(st.nextToken());
			if(A == 0) break;
			
			N = st.nextToken();
			B = Long.parseLong(st.nextToken());
		

			// A진법인 N을 우선 10진법으로 바꾸기
			dec = 0;
			if(A != 10) {	
				for (int i = 0; i < N.length(); i++) {
//					long digit = (long) Math.pow(A,  N.length() - i - 1); // 이렇게 하면 오차 발생!!! 주의
					long value;
					
					if(N.charAt(i) >= 'A' && N.charAt(i) <= 'Z') 
						value = N.charAt(i) - 55;
					else 
						value = N.charAt(i) - '0';

					for (int j = N.length() - i - 1; j > 0; j--) {
						value *= A;
					}
					dec += value;
				}
			} else 
				dec = Long.parseLong(N);		
			
			if(dec == 0) {
				sb.append(0).append("\n");
				continue;
			}
			
			// 10진법인 dec를 B진법으로 바꾸기
			ArrayList<Character> list = new ArrayList<>();
			while(true) {
				if(dec <= 0) break;
				
				if(dec % B >= 10) {
					char tmp = (char) (65 + dec % B - 10);
					list.add(tmp);
				} else {
					char tmp = (char) (dec % B + '0');
					list.add(tmp);
				}
				
				dec /= B;
			}
			
			for (int i = list.size() - 1; i >= 0; i--) {
				sb.append(list.get(i));
			}
			sb.append("\n");
			
			cnt++;
		}
		
		System.out.println(sb);
	}

}
