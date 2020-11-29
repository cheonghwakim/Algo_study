package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ11724_연결요소의개수 {
	static int N, M, parents[], rank[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		rank = new int[N + 1];
		init();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			union(u, v);
		}
		
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(find(i));
		}
		System.out.println(set.size());
	}

	private static void init() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot)
			link(aRoot, bRoot);
	}
	
	private static void link(int a, int b) {
		if(rank[a] > rank[b])
			parents[b] = a;
		else {
			parents[a] = b;
			if(rank[a] == rank[b])
				rank[b]++;
		}
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		else return parents[a] = find(parents[a]);
	}
	
	
}
