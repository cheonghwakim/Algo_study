package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286_절댓값힙 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) < Math.abs(o2))
				return -1;
			else if(Math.abs(o1) > Math.abs(o2))
				return 1;
			else {
				if(o1 > o2)
					return 1;
				else
					return -1;
			}
			
		}
	});
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder string = new StringBuilder();
		
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0)
				pq.add(num);
			else if(num == 0) {
				if(pq.size() == 0)
					string.append(0).append("\n");
				else
					string.append(pq.poll()).append("\n");
			}
		}
		System.out.println(string);
	}
}
