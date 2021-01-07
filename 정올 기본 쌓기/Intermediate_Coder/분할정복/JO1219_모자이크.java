package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// **
public class JO1219_모자이크 {
	static int R, C, num_paper, num, min, max_height, error[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		min = Math.min(R, C); // 행, 열 중 작은 값
		
		num_paper = Integer.parseInt(br.readLine()); // 색종이 장수
		num = Integer.parseInt(br.readLine()); // 잘못 칠해진 칸의 개수
		error = new int[num];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			max_height = Math.max(max_height, Integer.parseInt(st.nextToken()));
			error[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(error);
		
		// 종이의 크기를 분할 정복
		int left = max_height;
		int right = min;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(need(mid) <= num_paper) {
				// 가능하다면
				right = mid;
			
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
	}

	private static int need(int width) {
		
		// 색종이 폭이 width일 때, 잘못된 곳을 메꾸는데 필요한 종이 수
		int prev = -1;
		int ret = 0;
		for (int i = 0; i < error.length; i++) {
			if(prev == -1 || prev + width <= error[i]) { // 종이를 처음 놓음 || (prev, prev + width]까지 커버
				prev = error[i];
				ret++;
			}
		}
		
		return ret;
	}
}