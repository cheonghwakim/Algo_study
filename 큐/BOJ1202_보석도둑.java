package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 틀림 -> 
public class BOJ1202_보석도둑 {
	static int N, K;
	static ArrayList<Integer> bags = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		PriorityQueue<Jwelry> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			pq.add(new Jwelry(weight, price));
		}
		
		for (int i = 0; i < K; i++) {
			int bag = Integer.parseInt(br.readLine());
			bags.add(bag);
		}
		Collections.sort(bags);
		
		int result = 0;
		while(!pq.isEmpty()) {
			Jwelry jwel= pq.poll();
			
			int size = bags.size();
			for (int i = 0; i < size; i++) {
				if(bags.get(i) >= jwel.weight) {
					result += jwel.price;
					bags.remove(i);
					break;
				}
			}	
			
			if(bags.size() == 0)
				break;
		}
		System.out.println(result);
	}
	
	static class Jwelry implements Comparable<Jwelry>{
		int weight;
		int price;
		
		Jwelry(int weight, int price){
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jwelry o) {
			if(o.weight != this.weight)
				return this.weight - o.weight;
			else
				return o.price - this.price;
		}
	}

}
