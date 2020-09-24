package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1244 스위치 켜고 끄기 https://www.acmicpc.net/problem/1244
public class BOJ1244_스위치켜고끄기 {
	static int N, S;
	static boolean[] tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder string = new StringBuilder();
		
		tmp = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int type = Integer.parseInt(st.nextToken());
			if(type == 0)
				tmp[i + 1] = false;
			else
				tmp[i + 1] = true;
		}
		S = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if(n == 1) {
				int idx = 1;
				while(idx*t <= N) {
					tmp[idx*t] = !tmp[idx*t];
					idx++;
				}
			} else {
				int idx = 0;
				tmp[t] = !tmp[t];
				while(t - idx > 0 && t + idx <= N) {
					if(tmp[t - idx] == tmp[t + idx]) {
						tmp[t - idx] = !tmp[t - idx];
						tmp[t + idx] = !tmp[t + idx];
					} else 
						break;
					
					idx++;
				}
			}
		}	
		
		for (int i = 1; i <= N; i++) {
			if(tmp[i] == true)
				string.append(1).append(" ");
			else
				string.append(0).append(" ");
			
			if(i % 20 == 0)
				string.append("\n");
		}
		
		System.out.println(string);
		
	}

}
