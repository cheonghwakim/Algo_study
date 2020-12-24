package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이분 탐색 (int 범위 -2^31 ~ 2^31)
public class BOJ1654_랜선자르기 {
	static int K, stick[], max;
	static long N, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Long.parseLong(st.nextToken());
		
		stick = new int[K];
		for (int i = 0; i < K; i++) {
			stick[i] = Integer.parseInt(br.readLine());
			max = max < stick[i] ? stick[i] : max;
		}
		
		long start = 1;
		long end = max;
		long middle;
	
		while(start <= end) {
			
			middle = (start + end) / 2;
			
			long cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += stick[i] / middle;
			}
			
			if(cnt < N)
				end = middle - 1;
			else if (cnt >= N) {
				start = middle + 1;
				answer = answer < middle ? middle : answer;
			}
		}
		
		System.out.println(answer);
		
	}

}
