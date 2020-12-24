package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966_프린터큐 {
	static int T, N, M, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				q.add(new int[] {i, priority});
				pq.add(priority);
			}
			
			int idx = 1;
			while(!q.isEmpty()) {
				
				if(pq.peek() > q.peek()[1]) {
					int[] cur = q.poll();
					q.add(cur);
				} else {
					if(q.poll()[0] == M) {
						answer = idx;
						break;
					}
					pq.poll();
					idx++;
				}
			}
			sb.append(idx).append("\n");
		}
		System.out.println(sb);
	}
}
