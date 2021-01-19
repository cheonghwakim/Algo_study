package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1158_요세푸스문제_ArrayList {
	static int N, K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(i + 1);
		}
		
		sb.append("<");
		int idx = 0;
		while(!list.isEmpty()) {
			idx = (idx + K - 1) % list.size();
			
			sb.append(list.get(idx));
			list.remove(idx);
			if(list.size() != 0)
				sb.append(", ");
			else
				sb.append(">");
		}
		System.out.println(sb);
	}
}