package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1240_제곱근 {
	static long N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
	
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		System.out.println(findSqrt(0, N / 2));
	}

	private static long findSqrt (long start, long end) {
		
		long answer = 0, mid = 0;
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(mid * mid == N) return mid;	
			// long의 범위를 벗어나게 되면 음수 발생
			// 따라서 음수가 발생한 경우 원하는 것보다 큰 값이라고 판단
			// mid * mid <= 0 을 넣어줘야 함!
			else if(mid * mid <= 0 || mid * mid > N) 
				end = mid - 1;
			else { 
				answer = mid;
				start = mid + 1;
			}
		}
		
		return answer;
	}
}