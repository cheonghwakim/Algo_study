package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1202_보석도둑 {
	static int N, K, answer;
	static ArrayList<Integer> bags = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		PriorityQueue<Jwelry> pq = new PriorityQueue<>(new Comparator<Jwelry>(){
			@Override
			public int compare(Jwelry o1, Jwelry o2) {
				if(o1.weight != o2.weight)
					return o1.weight - o2.weight;
				else {
					return o2.price - o1.price;
				}
				
			}
		});
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
		
//		while(!pq.isEmpty()) {
//			Jwelry jwel= pq.poll();
//			
//			int size = bags.size();
//			for (int i = 0; i < size; i++) {
//				if(bags.get(i) >= jwel.weight) {
//					result += jwel.price;
//					bags.remove(i);
//					break;
//				}
//			}	
//			
//			if(bags.size() == 0)
//				break;
//		}
		
		// 가격 내림차순
		PriorityQueue<Jwelry> baginjwel = new PriorityQueue<>(new Comparator<Jwelry>(){
			@Override
			public int compare(Jwelry o1, Jwelry o2) {
				return o2.price - o1.price;
			}
		});
		for (int i = 0; i < bags.size(); i++) {
			Jwelry cur = pq.poll();
			
			if(bags.get(i) >= cur.weight) {
				baginjwel.add(cur);
			}
			
			if(!baginjwel.isEmpty()) {
				answer += baginjwel.poll().price;
			}
		}
		
		System.out.println(answer);
	}
	
	static class Jwelry{
		int weight;
		int price;
		
		Jwelry(int weight, int price){
			this.weight = weight;
			this.price = price;
		}
	}

}
