package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 13300 방 배정 https://www.acmicpc.net/problem/13300
public class BOJ13300_방배정 {
	static int N, K, S, Y;
	static ArrayList<ArrayList<Integer>> w = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> m = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 6; i++) {
			w.add(new ArrayList<Integer>());
			m.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			if(S == 0) {
				w.get(Y - 1).add(1);
			}else {
				m.get(Y - 1).add(1);
			}				
		}
		
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			cnt += w.get(i).size() / K;
			if(w.get(i).size() % K != 0)
				cnt += 1;
			
			cnt += m.get(i).size() / K;
			if(m.get(i).size() % K != 0)
				cnt += 1;
		}
		
		System.out.println(cnt);
		
	}

}
