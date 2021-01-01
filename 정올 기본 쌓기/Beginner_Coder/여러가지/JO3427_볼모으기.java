package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JO3427_볼모으기 {
	static int N, red, blue, answer = Integer.MAX_VALUE;
	static ArrayList<Character> balls = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String ball = br.readLine();
		for (int i = 0; i < N; i++) {
			balls.add(ball.charAt(i));
			if(balls.get(i) == 'R') red++;
			else blue++;
		}
		
		// 왼쪽으로 이동
		int cnt = 0; // 연속된 개수 셈
		for (int i = 0; i < N; i++) {
			if(balls.get(0) != balls.get(i)) 
				break;
			cnt++;
		} 
		// 1. 파란색 왼쪽으로
		if(balls.get(0) == 'B') answer = Math.min(answer, blue - cnt);
		else answer = Math.min(answer, blue);
		
		// 2. 빨간색 왼쪽으로
		if(balls.get(0) == 'R') answer = Math.min(answer, red - cnt);
		else answer = Math.min(answer, red);
		
		// 오른쪽으로 이동
		cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			if(balls.get(N - 1) != balls.get(i))
				break;
			cnt++;
		}
		
		// 3. 파란색 오른쪽으로
		if(balls.get(N - 1) == 'B') answer = Math.min(answer, blue - cnt); // 파란색 오른쪽으로
		else answer = Math.min(answer, blue); 
		
		// 4. 빨간색 오른쪽으로
		if(balls.get(N - 1) == 'R') answer = Math.min(answer, red - cnt);
		else answer = Math.min(answer, red);
		
		System.out.println(answer);
	}
}