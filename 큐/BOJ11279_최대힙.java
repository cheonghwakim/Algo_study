package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279_최대힙 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 알아두기!
		
		int num;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
		
			if(num == 0) {
				if(!pq.isEmpty())
					sb.append((pq.poll())).append("\n");
				else 
					sb.append(0).append("\n");
			} else {
				pq.add(num);
			}
			
		}
		System.out.println(sb);
	}

}
