package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ** 다시 풀어보기
public class BOJ2004_조합0의개수 {
	static long n, m; // n! / (n - m)! x m!
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		long up_5 = 0, up_2 = 0;
		long down_5 = 0, down_2 = 0;

		up_5 = Count(n, 5);
		down_5 = Count(m, 5);
		down_5 += Count(n - m, 5);
		
		up_2 = Count(n, 2);
		down_2 = Count(m, 2);
		down_2 += Count(n - m, 2);
		
		long min = Math.min(up_5 - down_5, up_2 - down_2);
		System.out.println(min);
	}

	private static long Count(long l, int num) {
		long cnt = 0;
		while(l >= num) {
			cnt += l / num;
			l /= num;
		}
	
		return cnt;
		
	}

}
