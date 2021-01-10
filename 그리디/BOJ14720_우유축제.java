package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14720_우유축제 {
	static int N, cnt;
	static int[] order = { 0, 1, 2 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(order[idx % 3] == Integer.parseInt(st.nextToken())) {
				idx++;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}