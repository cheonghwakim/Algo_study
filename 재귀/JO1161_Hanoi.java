package com.ssafy.jungol;

import java.util.Scanner;

// 2번 기둥에 마지막것만 빼고 옮김 -> 마지막거 3번째 기둥에 -> 2번에 있는 거 차례대로 3번째 기둥으로
// 큰 원판이 작은 원판에 있으면 안 됨!
public class JO1161_Hanoi {
	
	static int N; // 원판 개수		
	static StringBuilder string = new StringBuilder();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		
		N = scan.nextInt();
		
		Hanoi(N, 1, 2, 3);
		//System.out.println(string);
	}

	
	// 필요한 정보: 원판 개수, 기둥 개수
	private static void Hanoi(int N, int first, int second, int third) {
		if(N == 0)
			return;
		// 첫번째 기둥에 있는 걸 세 번째 기둥으로
		if(N == 1)
			System.out.println(N + " : " + first + " -> " +  third);
		else {
			Hanoi(N - 1, first, third, second);
			System.out.println(N + " : " + first + " -> " +  third);
			//string.append(N + " : " + first + " -> " + third + "\n");
			
			//두번째 기둥에 있는 걸 세 번째 기둥으로
	    	Hanoi(N - 1, second, first, third);
		}
	}

}
