package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1421_나무꾼이다솜 {
	static int N, C, W, max, height[];
	static long cost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		height = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
			if(max < height[i])
				max = height[i];
		}
		
		for (int i = max; i >= 1; i--) { // 나무들 중 가장 작은 길이만큼은 잘라야 함
			int cut = 0;
			long cur_cost = 0;
		
			for (int j = 0; j < N; j++) { 
				if(height[j] < i)
					continue;
				
				int divide = height[j] / i;
				if(height[j] % i != 0)
					cut = divide;
				else
					cut = divide - 1;
				
				if(i*divide*W - cut*C > 0)
					cur_cost += i*divide*W - cut*C;
			}
			
			if(cost < cur_cost)
				cost = cur_cost;
		}
		System.out.println(cost);
	}

}
