package jungol.Beginner_Coder.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1901_소수구하기 {
	static boolean[] isComposit = new boolean[1000001];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 사전에 prime 미리 구하기
		findPrime();
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			int minus = 0;
			if(!isComposit[num]) {
				sb.append(num).append("\n");
				continue;
			}
			else {
				while(true) {
					
					if(!isComposit[num - minus] && isComposit[num + minus]) {
						sb.append(num - minus).append("\n");
						break;
					}
					else if(isComposit[num - minus] && !isComposit[num + minus]) {
						sb.append(num + minus).append("\n");
						break;
					}
					
					else if (!isComposit[num - minus] && !isComposit[num + minus]) {
						sb.append(num - minus).append(" ").append(num + minus).append("\n");
						break;
					}
					
					minus++;
				}
			}
		}
		
		System.out.println(sb);
	}

	private static void findPrime() {
		
		for (int i = 2; i * i <= 1000000; i++) {
			if(isComposit[i]) continue;
			
			for (int j = i * 2; j <= 1000000; j += i) {
				isComposit[j] = true;
			}
			
		}
	}

}
