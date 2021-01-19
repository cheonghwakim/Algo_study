package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158_요세푸스문제 {
	static int N, K;
	static String nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			q.add(i + 1);
		}
		
		int idx = 0;
		sb.append("<");
		while(!q.isEmpty()) {
			
			if(q.size() != 1 && idx % K == K - 1) {
				sb.append(q.poll()).append(", ");
			} else {
				int num = q.poll();
				q.add(num);
			}
			
			if(q.size() == 1) {
				sb.append(q.poll()).append(">");
				break;
			}
			idx++;
		}
		System.out.println(sb);
	}
}