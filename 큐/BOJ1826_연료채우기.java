package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1826_연료채우기 {
	static int N, L, P;
	static ArrayList<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken()); // 현재 연료의 양
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		int cur = 0, cnt = 0;
		for (int i = 0; i <= N; i++) {
			
			if(cur + P >= L)
				break;
			
			// 현재 연료 양으로 갈 수 있는 주유소를 pq에 다 넣음
			if(i < N && P >= list.get(i)[0] - cur) {
				pq.add(new int[] {list.get(i)[1], list.get(i)[0]});
			} else {

				if(pq.size() > 0) {
					P = P + pq.peek()[0] - pq.peek()[1] + cur;
					cur = pq.poll()[1];
					cnt++;
				} else {
					System.out.println(-1);
					return;
				}
				i--;
			}
		}
		System.out.println(cnt);
	}
}