package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// ** 틀림
public class BOJ1043_거짓말 {
	static int N, M, cnt, truth[], parents[], rank[];
	static ArrayList<ArrayList<Integer>> party = new ArrayList<>();

	// 일단 유니온 파인드로 그룹 묶고 - 그룹 별로
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		rank = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		truth = new int[n];
		// 진실을 아는 사람들 넣어줌
		for (int i = 0; i < n; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}
		
		// 파티에 오는 사람 목록
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			party.add(new ArrayList<Integer>());
			
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				party.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		init();
		
		
		// 각 파티에 참여한 사람끼리 묶기
		// union
		for (int i = 0; i < M; i++) {
			int cur = party.get(i).get(0);
			for (int j = 1; j < party.get(i).size(); j++) {
				union(cur, party.get(i).get(j));
			}
		}
		
		// 각 파티에서 진실을 아는 사람과 묶여있으면 과장 XX
		for (int i = 0; i < M; i++) {
			boolean isPossible = true;
			int cur = party.get(i).get(0);
			
			for (int j = 0; j < truth.length; j++) {
				if(find(cur) == find(truth[j])) {
					isPossible = false;
					break;
				}
			}
			
			if(isPossible) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static void init() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			link(aRoot, bRoot);
		}
	}

	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}		
	
	private static void link(int a, int b) {
		if(rank[a] < rank[b])
			parents[b] = a;
		else
			parents[a] = b;
	}
}