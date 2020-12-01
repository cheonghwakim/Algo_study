package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간초과
public class BOJ1715_카드정렬하기_시간초과 {
	static int N, answer = Integer.MAX_VALUE, cards[], result[];
	static boolean[] checked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cards = new int[N];
		result = new int[N];
		checked = new boolean[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}
//		if(N == 1) {
//			System.out.println(cards[0]);
//			return;
//		} 
		perm(0);
		System.out.println(answer);
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			int cur_result = 0;
			for (int i = 0; i < result.length; i++) {
//				System.out.print(result[i] + " ");
				if(i == 0)
					cur_result = cards[result[i]];
				else
					cur_result += cards[result[i]] + cards[result[i - 1]];
			}
//			System.out.println();
			if(answer > cur_result) 
				answer = cur_result;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!checked[i]) {
				checked[i] = true;
				result[cnt] = i;
				perm(cnt + 1);
				checked[i] = false;
			}
		}
	}
	
	
}
